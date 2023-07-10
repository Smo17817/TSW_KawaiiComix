package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// prima di invalidare la sessione ci prendiamo i dati dal carrello
		HttpSession session = request.getSession(false);
		Connection connection = null;
		
		if(session.getAttribute("carrello").equals(null))
			session.invalidate();
			
		Carrello carrello = (Carrello) session.getAttribute("carrello");
		ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) carrello.getCarrello();
		ArrayList<String> isbnList = new ArrayList<>();
		
		
		for (Prodotto prod : prodotti) {
			isbnList.add(prod.getIsbn());
		}
		try {
			connection = DbManager.getConnection();

			for (String isbn : isbnList) {
				String query = "INSERT INTO carrello_prodotto (carrello_id , prodotto_isbn) VALUES (?,?)";
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setInt(1, carrello.getId());
				ps.setString(2, isbn);
				ps.executeUpdate();
			}

			session.invalidate(); // Invalida la sessione, rimuovendo tutti gli attributi ad essa associati
			response.sendRedirect("login.jsp"); // Reindirizza all'URL specificato (pagina di login nel nostro esempio)
		} catch (SQLException e) {
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
