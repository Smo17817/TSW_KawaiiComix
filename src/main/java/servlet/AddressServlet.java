package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection connection = null;
		RequestDispatcher dispatcher = null;
		User user = (User) session.getAttribute("user");
		String indirizzo = request.getParameter("indirizzo");
		String cap = request.getParameter("cap");
		String citta = request.getParameter("citta");
		String provincia = request.getParameter("provincia");
		String nazione = request.getParameter("nazione");
		
		try {
			DbManager manager = new DbManager();
			connection = manager.getConnection();	
			
			if(user == null) {
				dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}
			
			Statement s = connection.createStatement();
			String query = "SELECT * FROM address WHERE user_id=" + user.getId();
			ResultSet rs = s.executeQuery(query);
			
			if(!rs.next()) {
				query = "INSERT INTO address (indirizzo, codice_postale, citta, provincia, nazione, user_id) values(?, ?, ?, ?, ?, ?)";
				PreparedStatement ps =connection.prepareStatement(query);
				ps.setString(1, indirizzo);
				ps.setString(2, cap);
				ps.setString(3, citta);
				ps.setString(4, provincia);
				ps.setString(5, nazione);
				ps.setInt(6, user.getId());
				ps.executeUpdate();
				ps.close();	
			}else {
				query = "UPDATE address SET indirizzo = ?, codice_postale = ?, citta = ?, provincia = ?, nazione = ? WHERE user_id = ?";
				PreparedStatement ps =connection.prepareStatement(query);
				ps.setString(1, indirizzo);
				ps.setString(2, cap);
				ps.setString(3, citta);
				ps.setString(4, provincia);
				ps.setString(5, nazione);
				ps.setInt(6, user.getId());
				ps.executeUpdate();
				ps.close();	
			}
			
			rs.close();
			
			/*sia se si crea, sia se si modifica, le informazioni in sessione vanno aggiornate*/
			Indirizzo i = new Indirizzo(indirizzo, cap, citta, provincia, nazione);	
			session.setAttribute("indirizzo", i);
			
			dispatcher = request.getRequestDispatcher("indirizzo.jsp");
			dispatcher.forward(request, response);
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}


}
