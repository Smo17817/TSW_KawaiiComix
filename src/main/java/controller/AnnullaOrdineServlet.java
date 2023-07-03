package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AnnullaOrdineServlet")
public class AnnullaOrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Connection connection = null;
		RequestDispatcher dispatcher = null;
		
		try {
			connection = DbManager.getConnection();
			String query = "UPDATE ordini SET stato_ordine_id = 2 WHERE id = " + id;
			Statement s = connection.createStatement();
			s.executeUpdate(query);
			
			dispatcher = request.getRequestDispatcher("CheckOrders");
			dispatcher.forward(request, response);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
