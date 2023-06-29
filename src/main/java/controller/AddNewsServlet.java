package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNewsServlet
 */
@WebServlet("/AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		RequestDispatcher dispatcher = null;
		
		String titolo = (String) request.getParameter("titolo");
		String corpo = (String) request.getParameter("corpo");
		String immagine = (String) request.getParameter("immagine");
		String video = (String) request.getParameter("video");
		System.out.println(titolo + " ciao");
			
		try {
			String query = "INSERT INTO novita (titolo, corpo, immagine, video) values(?, ?, ?, ?)";
			connection = DbManager.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, titolo);
			ps.setString(2, corpo);
			ps.setString(3, immagine);
			ps.setString(4, video);
		
			ps.executeUpdate();
				
			dispatcher = request.getRequestDispatcher("aggiungiNovita.jsp");
			dispatcher.forward(request, response);
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ServletException e) {
			e.printStackTrace();
		}catch (IOException e){
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
