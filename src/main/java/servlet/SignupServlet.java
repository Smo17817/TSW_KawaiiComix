package servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String query = "INSERT INTO site_user values (?, ?, ?, ?)"; 
		MyConnection mc = new MyConnection();
		try {	 
			PreparedStatement ps = MyConnection.getConnection().prepareStatement(query);
			ps.setString(1, nome);
			ps.setString(2, cognome);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("index.jsp");
	}
}
