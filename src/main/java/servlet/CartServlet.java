package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Prodotto prodotto = (Prodotto) session.getAttribute("prodotto");
		Carrello carrello = (Carrello) session.getAttribute("carrello");
		
		if(session.getAttribute("user")==null)
			response.sendRedirect("login.jsp");
		
		
		else {
			/* se il prodotto non si trova in sessione, ce lo mette */
			if (prodotto == null) {
				String isbn = (String) request.getParameter("isbn");
				System.out.println(isbn);
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

						session.setAttribute("prodotto", p);
						carrello.add(p);
						session.setAttribute("carrello", carrello);
					}
					rs.close();
				} catch (SQLException e) {
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

			if (!carrello.getCarrello().contains(prodotto)) // la quantità si modifica solo nel carello.jsp
				carrello.add(prodotto);

			session.setAttribute("carrello", carrello);

			RequestDispatcher dispatcher = request.getRequestDispatcher("carrello.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
;
}