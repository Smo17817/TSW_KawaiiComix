package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ExitServlet")
public class ExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		session.invalidate(); // Invalida la sessione, rimuovendo tutti gli attributi ad essa associati
	
		try {
			response.sendRedirect("login.jsp"); // Reindirizza all'URL specificato (pagina di login nel nostro esempio)
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
