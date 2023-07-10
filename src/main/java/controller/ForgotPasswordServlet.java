package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ForgotPasswordServlet.class.getName());
	private String error = "Errore";
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password1 = request.getParameter("password");
		String password2 = request.getParameter("conf-password");
		String status = "status";
		String url = "richiestapassword.jsp";

		int rowCount = 0;
		RequestDispatcher dispatcher = null;
		
		try (Connection connection = DbManager.getConnection();){
			if (email.equals("")) {
				request.setAttribute(status, "Invalid_email");
				request.setAttribute("emailValue", email);
				dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
				return;
			}
			if (password1.equals("") || password2.equals("")) {
				request.setAttribute(status, "Invalid_password");
				dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
				return;
			}
			if (!(password1.equals(password2))) {
				request.setAttribute(status, "Invalid_password2");
				dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
				return;
			}

			String query = "UPDATE site_user SET  password = ? WHERE email_address = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, password1);
			ps.setString(2, email);
			rowCount = ps.executeUpdate();
			ps.close();

			if (rowCount > 0)
				request.setAttribute(status, "success");
			else
				request.setAttribute(status, "failed");

			dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			ps.close();
		} catch (SQLException e) {
			logger.log(Level.ALL, error, e);
		} catch (ServletException e) {
			logger.log(Level.ALL, error, e);
		} catch (IOException e) {
			logger.log(Level.ALL, error, e);
		}
	}

}
