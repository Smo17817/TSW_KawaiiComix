package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Connection connection = null;
		RequestDispatcher dispatcher = null;
		
		String q = "SELECT email_address FROM site_user WHERE email_address=?";
		connection = DbManager.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				request.setAttribute("status", "duplicato");
				dispatcher = request.getRequestDispatcher("signup.jsp");
				dispatcher.forward(request, response);
				return;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = "INSERT INTO site_user(nome,cognome,email_address,password) values(?,?,?,?)";
		try {
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
				request.setAttribute("status", "success");

			} else {
				request.setAttribute("status", "failed");
			}

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
