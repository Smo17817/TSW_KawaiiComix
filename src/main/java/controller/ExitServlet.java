package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrello;
import model.Prodotto;

@WebServlet("/ExitServlet")
public class ExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ExitServlet.class.getName());
	private static final String error = "Errore";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// prima di invalidare la sessione ci prendiamo i dati dal carrello
		HttpSession session = request.getSession(false);
		String query = "INSERT INTO carrello_prodotto (carrello_id , prodotto_isbn) VALUES (?,?)";

		try (Connection connection = DbManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);) {

			if (((Carrello) session.getAttribute("carrello")).getCarrello().isEmpty()) {
				session.invalidate();
				response.sendRedirect("login.jsp");
				return;
			}
			Carrello carrello = (Carrello) session.getAttribute("carrello");
			ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) carrello.getCarrello();
			ArrayList<String> isbnList = new ArrayList<>();

			for (Prodotto prod : prodotti) {
				isbnList.add(prod.getIsbn());
			}

			for (String isbn : isbnList) {
				ps.setInt(1, carrello.getId());
				ps.setString(2, isbn);
				ps.executeUpdate();
			}

			session.invalidate(); // Invalida la sessione, rimuovendo tutti gli attributi ad essa associati
			response.sendRedirect("login.jsp"); // Reindirizza all'URL specificato (pagina di login nel nostro esempio)
		} catch (SQLException e) {
			logger.log(Level.ALL, error, e);
		} catch (IOException e) {
			logger.log(Level.ALL, error, e);
		}
	}

}
