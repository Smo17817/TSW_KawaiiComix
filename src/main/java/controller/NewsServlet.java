package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Articolo;
import model.Novita;

@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		Connection connection = null;
		Novita novita = new Novita();
		try {
			connection = DbManager.getConnection();

			String query = "SELECT * FROM novita";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String titolo = rs.getString("titolo");
				String corpo = rs.getString("corpo");
				String video = rs.getString("video");
				String immagine = rs.getString("immagine");

				Articolo a = new Articolo(id, titolo, corpo, video, immagine);
				novita.add(a);
			}
			/* Così vengono mostrate prima le notizie più recenti e poi le più datate */
			Collections.reverse(novita.getNovita());
			session.setAttribute("novita", novita);

			dispatcher = request.getRequestDispatcher("novita.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
