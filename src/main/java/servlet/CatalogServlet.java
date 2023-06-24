package servlet;

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

/**
 * Servlet implementation class CatalogServlet
 */
@WebServlet("/CatalogServlet")
public class CatalogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection connection = null;
		
		try {
			DbManager manager = new DbManager();
			connection = manager.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM prodotti");
			ResultSet rs = ps.executeQuery();
			Catalogo catalogo = new Catalogo();
			

			while(rs.next()) {
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("catalogo.jsp");
			dispatcher.forward(request, response);
			
			rs.close();
			
		}catch (SQLException e) {
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
