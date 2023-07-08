package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password1 = request.getParameter("password");
		String password2 = request.getParameter("conf-password");
		String status = "status";
		String url = "richiestapassword.jsp";

		int rowCount = 0;
		Connection connection = null;
		RequestDispatcher dispatcher = null;
		
		try {
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

			connection = DbManager.getConnection();
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
