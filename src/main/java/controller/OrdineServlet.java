package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Ordine;
import model.OrdineComparator;
import model.OrdineSingolo;
import model.OrdiniList;
import model.Prodotto;

@WebServlet("/OrdineServlet")
public class OrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection connection = null;
		RequestDispatcher dispatcher = null;

		try {
			connection = DbManager.getConnection();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Statement s = connection.createStatement();
			OrdiniList ol = new OrdiniList();
			Ordine o = null;
			OrdineSingolo os = null;
			Prodotto p = null;

			String query = "SELECT * FROM prodotti";
			ResultSet rs = s.executeQuery(query);
			ArrayList<Prodotto> prodotti = new ArrayList<>();
			while (rs.next()) {
				String isbn = rs.getString("isbn");
				String nome = rs.getString("nome");
				String descrizione = rs.getString("descrizione");
				String img = rs.getString("immagine_prod");
				String genere = rs.getString("genere_nome");
				String categoria = rs.getString("categoria_nome");
				int quantitaProd = rs.getInt("quantita");
				double prezzo = rs.getInt("prezzo");
				p = new Prodotto(isbn, nome, descrizione, img, genere, categoria, quantitaProd, prezzo);
				prodotti.add(p);
			}

			query = "SELECT * FROM ordine_singolo";
			rs = s.executeQuery(query);
			ArrayList<OrdineSingolo> osList = new ArrayList<>();
			/* ricerca di tutti gli ordini singoli del database */
			while (rs.next()) {
				int idSingle = rs.getInt("id");
				int quantita = rs.getInt("quantità");
				double totParziale = rs.getDouble("totale_parziale");
				int ordini_id = rs.getInt("ordini_id");
				String prodIsbn = rs.getString("prodotti_isbn");

				/* Cerco il prodotto che ha l'isbn dell'ordine singolo */
				for (Prodotto prod : prodotti) {
					if (prod.getIsbn().equals(prodIsbn))
						p = prod;
				}
				os = new OrdineSingolo(idSingle, quantita, totParziale, ordini_id, p);
				osList.add(os);
			}

			/* ricerca del gli ordini nel DataBase */
			query = "SELECT * FROM ordini";
			rs = s.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				java.sql.Date dateSql = rs.getDate("data");
				java.util.Date dateJava = new java.util.Date(dateSql.getTime());
				double totale = rs.getDouble("totale");
				int userId = rs.getInt("site_user_id");
				int stato = rs.getInt("stato_ordine_id");
				int spedizione = rs.getInt("metodo_spedizione_id");
				int idIndirizzo = rs.getInt("address_id");
				o = new Ordine(id, sdf.format(dateJava), totale, userId, stato, spedizione, idIndirizzo);
				/* associo ogni ordine ai suoi ordini singoli */
				for (OrdineSingolo temp : osList) {
					if (temp.getOrdini_id() == id)
						o.add(temp);
				}
				ol.add(o);
			}
			Collections.sort(ol.getOrdiniList(), new OrdineComparator());
			
			session.setAttribute("ordini", ol);
			dispatcher = request.getRequestDispatcher("ordine.jsp");
			dispatcher.forward(request, response);

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
