package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrello;
import model.Indirizzo;
import model.Prodotto;
import model.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		Connection connection = null;

		String query = "SELECT * FROM site_user WHERE email_address = ? and password = ?";

		try {
			connection = DbManager.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				User user = new User(id, email, nome, cognome);

				query = "SELECT * FROM address WHERE user_id = " + id;
				Statement s = connection.createStatement();
				rs = s.executeQuery(query);

				/* quando si fa il log in, vengono caricate anche le info sull'indirizzo */
				if (rs.next()) {
					String indirizzo = rs.getString("indirizzo");
					String cap = rs.getString("codice_postale");
					String citta = rs.getString("citta");
					String provincia = rs.getString("provincia");
					String nazione = rs.getString("nazione");
					Indirizzo i = new Indirizzo(indirizzo, cap, citta, provincia, nazione);
					session.setAttribute("indirizzo", i);
				} else {
					/* se l'indirizzo è inesistente, ne viene creato uno di default (serve per i placeholder */
					session.setAttribute("indirizzo", new Indirizzo("Inserisci i tuoi dati", "", "", "", ""));
				}
				
				query = "SELECT * FROM carrello WHERE user_id=" + id;
				rs =  s.executeQuery(query);
				int carrelloid = 0;
				Carrello carrello = null;
				//se l'utente ha un carrello assegnato lo si prende e lo si assegna 
				if(rs.next()) {
					carrelloid = rs.getInt("id");
					 carrello = new Carrello(carrelloid);
				}
				else {
					query = "INSERT INTO carrello(user_id) VALUES (?)";
					ps = connection.prepareStatement(query);
					ps.setInt(1, id);
					ps.executeUpdate();
					query = "SELECT * FROM carrello WHERE user_id=" + id;
					rs = ps.executeQuery(query);
					if(rs.next()) {
						carrelloid = rs.getInt("id");
						 carrello = new Carrello(carrelloid);
					}
				}
				
				query = "SELECT * FROM carrello_prodotto WHERE carrello_id=" + carrelloid;
				rs = s.executeQuery(query);
				
				
				ArrayList<Prodotto> list = (ArrayList<Prodotto>) carrello.getCarrello();
				ArrayList<String> isbnList = new ArrayList<String>();
				while(rs.next()) {
					String isbn = rs.getString("prodotto_isbn");
					isbnList.add(isbn);	
				}
				
				query = "SELECT * FROM prodotti";
				rs = s.executeQuery(query);
				while(rs.next()) {
					if(isbnList.contains(rs.getString("isbn"))){
						String nomeprod = rs.getString("nome");
						String descrizione = rs.getString("descrizione");
						String img = rs.getString("immagine_prod");
						String genere = rs.getString("genere_nome");
						String categoria = rs.getString("categoria_nome");
						int quantita = rs.getInt("quantita");
						double prezzo = rs.getDouble("prezzo");
						Prodotto prodotto = new Prodotto(rs.getString("isbn"), nomeprod, descrizione, img, genere, categoria, quantita, prezzo);
						list.add(prodotto);
					}
				}
				for(String isbn : isbnList) {
					query = "DELETE  FROM carrello_prodotto WHERE prodotto_isbn=" + isbn;
					ps.executeUpdate(query);
				}
				ps.close();
				carrello.setCarrello(list);
				session.setAttribute("carrello", carrello);

				session.setAttribute("user", user);
				dispatcher = request.getRequestDispatcher("index.jsp");
			} else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}

			dispatcher.forward(request, response);
		} catch (Exception e) {
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
