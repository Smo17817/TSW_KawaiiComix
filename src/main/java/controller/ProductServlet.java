package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Prodotto;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		HttpSession session = request.getSession();
		Connection c = null;

		try {
			c = DbManager.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM prodotti WHERE isbn = ?");
			ps.setString(1, isbn);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String nome = rs.getString("nome");
				String descrizione = rs.getString("descrizione");
				String img = rs.getString("immagine_prod");
				String genere = rs.getString("genere_nome");
				String categoria = rs.getString("categoria_nome");
				int quantita = rs.getInt("quantita");
				double prezzo = rs.getDouble("prezzo");
				Prodotto p = new Prodotto(isbn, nome, descrizione, img, genere, categoria, quantita, prezzo);

				request.setAttribute("prodotto", p);
				session.setAttribute("prodotto", p); // velocizza le cose in caso di acquisto
				RequestDispatcher dispatcher = request.getRequestDispatcher("prodotto.jsp");
				dispatcher.forward(request, response);
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (c != null)
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

}
