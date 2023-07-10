package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

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

@WebServlet("/OrdineServlet")
public class OrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(OrdineServlet.class.getName());
	private String error = "Errore";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;

		try (Connection connection = DbManager.getConnection();){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Statement s = connection.createStatement();
			OrdiniList ol = new OrdiniList();
			Ordine o = null;
			OrdineSingolo os = null;

			String query = "SELECT * FROM ordine_singolo";
			ResultSet rs = s.executeQuery(query);
			ArrayList<OrdineSingolo> osList = new ArrayList<>();
			/* ricerca di tutti gli ordini singoli del database */
			while (rs.next()) {
				int idSingle = rs.getInt("id");
				int quantita = rs.getInt("quantità");
				double totParziale = rs.getDouble("totale_parziale");
				int ordini_id = rs.getInt("ordini_id");
				String prodIsbn = rs.getString("prodotti_isbn");
				String prodNome = rs.getString("prodotti_nome");
				String prodImg = rs.getString("prodotti_img");

				os = new OrdineSingolo(idSingle, quantita, totParziale, ordini_id, prodIsbn, prodNome, prodImg);
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
			logger.log(Level.ALL, error, e);
		} catch (ServletException e) {
			logger.log(Level.ALL, error, e);
		} catch (IOException e) {
			logger.log(Level.ALL, error, e);
		}
	}

}
