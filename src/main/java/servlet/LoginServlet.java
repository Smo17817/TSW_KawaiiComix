package servlet;

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


@WebServlet("/Login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		String query = "SELECT * FROM site_user WHERE email_address = ? and password = ?";
		
		try {
			con = DbManager.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				User user = new User(id, email, nome, cognome);
				/* quando logga crea anche un carrello vuoto*/
				Carrello carrello = new Carrello();
				carrello.add(new Prodotto("", "", "", "", "", "", 0, 0));
				session.setAttribute("carrello", carrello);
				
				query = "SELECT * FROM address WHERE user_id = " + id;
				Statement s = con.createStatement();
				rs = s.executeQuery(query);
				
				/*quando si fa il log in, vengono caricate anche le info sull'indirizzo*/
				if(rs.next()) {
					String indirizzo = rs.getString("indirizzo");
					String cap = rs.getString("codice_postale");
					String citta = rs.getString("citta");
					String provincia = rs.getString("provincia");
					String nazione = rs.getString("nazione");
					Indirizzo i = new Indirizzo(indirizzo, cap, citta, provincia, nazione);
					session.setAttribute("indirizzo", i);
				}else { 
					/*se l'indirizzo è inesistente, ne viene creato uno di default (serve per i placeholder */
					session.setAttribute("indirizzo", new Indirizzo("Inserisci i tuoi dati", "", "", "", ""));
				}
							
				session.setAttribute("user", user);
				dispatcher = request.getRequestDispatcher("index.jsp");
			}else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			
			dispatcher.forward(request, response);
		}catch(Exception e) { 
			e.printStackTrace();
		}finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
