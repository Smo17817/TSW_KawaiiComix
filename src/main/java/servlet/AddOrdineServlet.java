package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OrdineServlet
 */
@WebServlet("/AddOrdineServlet")
public class AddOrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection connection = null;
		RequestDispatcher dispatcher = null;
		User user = (User) session.getAttribute("user");
		int address_id = -1;
		
		try {
			connection = DbManager.getConnection();
			
			String query = "SELECT id FROM address WHERE user_id = " + user.getId();
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(query);
			
			if(rs.next()) 
				address_id = rs.getInt("id");
			
			Calendar c = Calendar.getInstance();
			java.util.Date javaDate = c.getTime();
            java.sql.Date sqlDate = new Date(javaDate.getTime());	
            
            double totale = Double.parseDouble(request.getParameter("totale"));
			
			query = "INSERT INTO ordini (data, totale, site_user_id, stato_ordine_id, metodo_spedizione_id, address_id) values(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setDate(1, sqlDate);
			ps.setDouble(2, totale);
			ps.setInt(3, user.getId());
			ps.setInt(4, 1); //completato
			ps.setInt(5, 1); //posteItaliane
			ps.setInt(6, address_id);
			ps.executeUpdate();
			
			session.setAttribute("carrello", new Carrello());
		
			dispatcher = request.getRequestDispatcher("profilo.jsp");
			dispatcher.forward(request, response);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection == null)
					return;
				else
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
