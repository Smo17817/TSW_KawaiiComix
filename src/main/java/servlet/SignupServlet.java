package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Connection con = null;
		RequestDispatcher dispatcher = null;
		
		String query = "INSERT INTO site_user(nome,cognome,email_address,password) values(?,?,?,?)";
		try {	 
			con = DbManager.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, nome);
			ps.setString(2, cognome);
			ps.setString(3, email);
			ps.setString(4, password);
			
			int rowCount = ps.executeUpdate();
			dispatcher = request.getRequestDispatcher("./signup.jsp");
			
			if(rowCount > 0) {
				request.setAttribute("status", "success");
				 
			}else {
				request.setAttribute("status", "failed");
			}
			
			dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con == null)
					return;
				else
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
