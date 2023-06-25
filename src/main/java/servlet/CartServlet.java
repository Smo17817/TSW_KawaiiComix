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
		RequestDispatcher dispatcher = null;
		Carrello carrello = (Carrello) session.getAttribute("carrello");
		String isbn = request.getParameter("isbn");
		User user = (User) session.getAttribute("user");
		Connection connection = null;
		
		
		if( user == null)
			response.sendRedirect("login.jsp");
		else {
			try {
				connection = DbManager.getConnection();
				String query = "SELECT * FROM prodotti WHERE isbn = ?";
				PreparedStatement ps = connection.prepareStatement(query);
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
					Prodotto prodotto = new Prodotto(isbn, nome, descrizione, img, genere, categoria, quantita, prezzo);
					
					/* controlla che ci sia solo una ripetizione per ogni prodotto */
					int flag = 0;
					for(Prodotto p : carrello.getCarrello()) {
						if(prodotto.getIsbn().equals(p.getIsbn()))
							flag = 1;
					}
				
					if(flag == 0) {
						carrello.add(prodotto);
						session.setAttribute("carrello", carrello);
					}
				}
		
				dispatcher = request.getRequestDispatcher("carrello.jsp");
				dispatcher.forward(request, response);

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (connection != null)
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
	}
	
}