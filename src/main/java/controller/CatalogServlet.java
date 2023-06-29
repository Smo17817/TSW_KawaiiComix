package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Catalogo;
import model.Prodotto;
import model.ProdottoComparator;

@WebServlet("/CatalogServlet")
public class CatalogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection connection = null;

		try {
			connection = DbManager.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM prodotti");
			ResultSet rs = ps.executeQuery();
			Catalogo catalogo = new Catalogo();

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

				catalogo.add(p);
			}
			Collections.sort(catalogo.getCatalogo(), new ProdottoComparator());
			session.setAttribute("catalogo", catalogo);

			Statement s = connection.createStatement();
			String query = "SELECT nome FROM genere";
			rs = s.executeQuery(query);
			ArrayList<String> generi = new ArrayList<>();
			/* Aggiunta generi all'arraylist */
			while (rs.next())
				generi.add(rs.getString("nome"));
			Collections.sort(generi);
			session.setAttribute("generi", generi);

			query = "SELECT nome FROM categoria";
			rs = s.executeQuery(query);
			ArrayList<String> categorie = new ArrayList<>();
			/* Aggiunta categorie all'arraylist */
			while (rs.next())
				categorie.add(rs.getString("nome"));
			Collections.sort(categorie);
			session.setAttribute("categorie", categorie);

			RequestDispatcher dispatcher = request.getRequestDispatcher("catalogo.jsp");
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
				if (!connection.equals(null))
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
