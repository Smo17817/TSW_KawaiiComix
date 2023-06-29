package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Indirizzo;
import model.User;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection connection = null;
		RequestDispatcher dispatcher = null;
		User user = (User) session.getAttribute("user");
		String indirizzo = request.getParameter("indirizzo");
		String cap = request.getParameter("cap");
		String citta = request.getParameter("citta");
		String provincia = request.getParameter("provincia");
		String nazione = request.getParameter("nazione");

		try {
			if (indirizzo.equals(null) || indirizzo.equals("")) {
				request.setAttribute("status", "Invalid_address");
				dispatcher = request.getRequestDispatcher("indirizzo.jsp");
				dispatcher.forward(request, response);
				return;
			}
			if (citta.equals(null) || citta.equals("")) {
				request.setAttribute("status", "Invalid_citta");
				dispatcher = request.getRequestDispatcher("indirizzo.jsp");
				dispatcher.forward(request, response);
				return;
			}
			if (provincia.equals(null) || provincia.equals("")) {
				request.setAttribute("status", "Invalid_provincia");
				dispatcher = request.getRequestDispatcher("indirizzo.jsp");
				dispatcher.forward(request, response);
				return;
			}
			if (cap.equals(null) || cap.equals("") || (cap.length() != 5)) {
				request.setAttribute("status", "Invalid_cap");
				dispatcher = request.getRequestDispatcher("indirizzo.jsp");
				dispatcher.forward(request, response);
				return;
			}
			if (nazione.equals(null) || nazione.equals("") || nazione.equals("-effettua una scelta-")) {
				request.setAttribute("status", "Invalid_nazione");
				dispatcher = request.getRequestDispatcher("indirizzo.jsp");
				dispatcher.forward(request, response);
				return;
			}

			connection = DbManager.getConnection();
			Statement s = connection.createStatement();
			String query = "SELECT * FROM address WHERE user_id=" + user.getId();
			ResultSet rs = s.executeQuery(query);
			int rowCount = 0;

			if (!rs.next()) {
				query = "INSERT INTO address (indirizzo, codice_postale, citta, provincia, nazione, user_id) values(?, ?, ?, ?, ?, ?)";
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, indirizzo);
				ps.setString(2, cap);
				ps.setString(3, citta);
				ps.setString(4, provincia);
				ps.setString(5, nazione);
				ps.setInt(6, user.getId());
				rowCount = ps.executeUpdate();
				ps.close();
			} else {
				query = "UPDATE address SET indirizzo = ?, codice_postale = ?, citta = ?, provincia = ?, nazione = ? WHERE user_id = ?";
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, indirizzo);
				ps.setString(2, cap);
				ps.setString(3, citta);
				ps.setString(4, provincia);
				ps.setString(5, nazione);

				ps.setInt(6, user.getId());
				rowCount = ps.executeUpdate();
				ps.close();
			}

			rs.close();

			if (rowCount > 0) {
				request.setAttribute("status", "success");
				/*
				 * sia se si crea, sia se si modifica, le informazioni in sessione vanno
				 * aggiornate
				 */
				Indirizzo i = new Indirizzo(indirizzo, cap, citta, provincia, nazione);
				session.setAttribute("indirizzo", i);

			} else {
				request.setAttribute("status", "failed");
			}

			dispatcher = request.getRequestDispatcher("indirizzo.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
