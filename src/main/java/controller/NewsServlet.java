package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	private static final Logger logger = Logger.getLogger(DatiPersonaliServlet.class.getName());
	private String error = "Errore";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		Novita novita = new Novita();
		
		try (Connection connection = DbManager.getConnection();){
			String query = "SELECT * FROM novita";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String titolo = rs.getString("titolo");
				String sottotitolo = rs.getString("sottotitolo");
				String corpo = rs.getString("corpo");
				String video = rs.getString("video");
				String immagine = rs.getString("immagine");
				java.sql.Date dataSql = rs.getDate("data");
				java.util.Date dataJava = new java.util.Date(dataSql.getTime());
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				Articolo a = new Articolo(id, titolo, sottotitolo, sdf.format(dataJava), corpo, video, immagine);
				novita.add(a);
			}
			/* Così vengono mostrate prima le notizie più recenti e poi le più datate */
			Collections.reverse(novita.getNovita());
			session.setAttribute("novita", novita);

			dispatcher = request.getRequestDispatcher("novita.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException e) {
			logger.log(Level.ALL, error, e);
		} catch (ServletException e) {
			logger.log(Level.ALL, error, e);
		} catch (IOException e) {
			logger.log(Level.ALL, error, e);
		} 
	}

}
