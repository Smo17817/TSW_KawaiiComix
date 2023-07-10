package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Prodotto;
import model.ProdottoComparator;

@WebServlet("/CatalogServlet")
public class CatalogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CatalogServlet.class.getName());
	private final String error = "Errore";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson json = new Gson();

		try (Connection connection = DbManager.getConnection();){			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM prodotti");
			ResultSet rs = ps.executeQuery();
			PrintWriter out = response.getWriter();
			ArrayList<Prodotto> catalogo = new ArrayList<>();

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
			Collections.sort(catalogo, new ProdottoComparator());
			out.write(json.toJson(catalogo));

			ps.close();
			rs.close();

		} catch (SQLException e) {
			logger.log(Level.ALL, error, e);
		}catch (IOException e) {
			logger.log(Level.ALL, error, e);
		} 
	}

}
