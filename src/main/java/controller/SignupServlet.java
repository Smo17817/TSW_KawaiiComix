package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SignupServlet.class.getName());
	private final String error = "Errore";
	private final String status = "status";
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		RequestDispatcher dispatcher = null;
		String q = "SELECT email_address FROM site_user WHERE email_address=?";	
		
		try (Connection connection = DbManager.getConnection();){
			PreparedStatement ps = connection.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				request.setAttribute(status, "duplicato");
				dispatcher = request.getRequestDispatcher("signup.jsp");
				dispatcher.forward(request, response);
				return;
			}
			
			String query = "INSERT INTO site_user(nome,cognome,email_address,password) values(?,?,?,?)";
		
			ps = connection.prepareStatement(query);
			ps.setString(1, nome);
			ps.setString(2, cognome);
			ps.setString(3, email);
			ps.setString(4, password);

			int rowCount = 0;

			if (!((nome.equals("")) || (cognome.equals("")) || (email.equals("")) || (password.equals("")))) {
				rowCount = ps.executeUpdate();
			}
			dispatcher = request.getRequestDispatcher("login.jsp");

			if (rowCount > 0) {
				request.setAttribute(status, "success");

			} else {
				request.setAttribute(status, "failed");
			}

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
