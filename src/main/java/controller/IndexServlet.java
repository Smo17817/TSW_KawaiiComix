package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Prodotto;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection connection = null;

		try {
			connection = DbManager.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM prodotti");
			ResultSet rs = ps.executeQuery();
			ArrayList<Prodotto> prodotti = new ArrayList<>();

			while (rs.next()) {
				String isbn = rs.getString("isbn");
				String nome = rs.getString("nome");
				String descrizione = rs.getString("descrizione");
				String img = rs.getString("immagine_prod");
				String genere = rs.getString("genere_nome");
				String categoria = rs.getString("categoria_nome");
				int quantita = rs.getInt("quantita");
				double prezzo = rs.getDouble("prezzo");
				Prodotto p = new Prodotto(isbn, nome, descrizione, img, genere, categoria, quantita, prezzo);

				prodotti.add(p);
			}
			Collections.reverse(prodotti);
			session.setAttribute("prodotti", prodotti);

			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

			rs.close();

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
