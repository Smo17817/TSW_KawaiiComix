package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrello;
import model.Prodotto;
import model.User;

@WebServlet("/AddOrdineServlet")
public class AddOrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection connection = null;
		RequestDispatcher dispatcher = null;
		User user = (User) session.getAttribute("user");
		Carrello carrello = (Carrello) session.getAttribute("carrello");
		int address_id = -1;

		try {
			connection = DbManager.getConnection();

			String query = "SELECT id FROM address WHERE user_id = " + user.getId();
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(query);

			if (rs.next())
				address_id = rs.getInt("id");

			Calendar c = Calendar.getInstance();
			java.util.Date javaDate = c.getTime();
			java.sql.Date sqlDate = new Date(javaDate.getTime());

			double totale = Double.parseDouble(request.getParameter("totale"));
			Random random = new Random();
			int ordine_id = 10000 + random.nextInt(90000);

			query = "INSERT INTO ordini (id, data, totale, site_user_id, stato_ordine_id, metodo_spedizione_id, address_id) values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, ordine_id);
			ps.setDate(2, sqlDate);
			ps.setDouble(3, totale);
			ps.setInt(4, user.getId());
			ps.setInt(5, 1); // completato
			ps.setInt(6, 1); // posteItaliane
			ps.setInt(7, address_id);
			ps.executeUpdate();

			String values[] = request.getParameter("quantita").split(",");
			int i = 0;

			for (Prodotto p : carrello.getCarrello()) {
				p.setQuantita(Integer.parseInt(values[i]));
				i++;
			}

			for (Prodotto p : carrello.getCarrello()) {
				System.out.println(p.toString());
				query = "INSERT INTO ordine_singolo (quantità, totale_parziale, ordini_id, prodotti_isbn) " + "values("
						+ p.getQuantita() + ", " + (p.getPrezzo() * p.getQuantita()) + ", " + ordine_id + ", "
						+ p.getIsbn() + ")";

				s.executeUpdate(query);
			}

			session.setAttribute("carrello", new Carrello());

			dispatcher = request.getRequestDispatcher("profilo.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
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
