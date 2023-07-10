package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = null;
		RequestDispatcher dispatcher = null;
		PreparedStatement ps = null;

		String titolo = request.getParameter("titolo");
		String sottotitolo = request.getParameter("sottotitolo");
		String corpo = request.getParameter("corpo");
		String immagine = request.getParameter("immagine");
		String video = request.getParameter("video");	
		Calendar c = Calendar.getInstance();
		java.util.Date javaDate = c.getTime();
		java.sql.Date sqlDate = new Date(javaDate.getTime());
		
		if(immagine.equals("")) immagine = null;
		if(video.equals("")) video = null;

		try {
			String query = "INSERT INTO novita (titolo, sottotitolo, data, corpo, immagine, video) values(?, ?, ?, ?, ?, ?)";
			connection = DbManager.getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, titolo);
			ps.setString(2,  sottotitolo);
			ps.setDate(3, sqlDate);
			ps.setString(4, corpo);
			ps.setString(5, immagine);
			ps.setString(6, video);

			ps.executeUpdate();
			
			
			dispatcher = request.getRequestDispatcher("aggiungiNovita.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
}
