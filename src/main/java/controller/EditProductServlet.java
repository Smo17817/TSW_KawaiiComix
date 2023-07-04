package controller;

import java.io.File;
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

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		RequestDispatcher dispatcher = null;
		
		try {
			String prodotto = request.getParameter("scelta");
			System.out.println(prodotto);
			String nome = request.getParameter("nome");
			String descrizione = request.getParameter("descrizione");
			String immagine = request.getParameter("immagine");
			double prezzo = Double.parseDouble(request.getParameter("prezzo"));
			int quantita = Integer.parseInt(request.getParameter("quantita"));
			
			connection = DbManager.getConnection();
			String query = "SELECT isbn FROM prodotti WHERE nome = " + prodotto;
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(query);
			
			rs.next();
			String isbn = rs.getString("isbn");
			String genere = rs.getString("genere_nome");
			String categoria = rs.getString("categoria_nome");
			
				
			
			query = "UPDATE prodotti "
					+ "SET nome=?, descrizione=?, immagine_prod=?, prezzo=?, quantita=?, categoria_nome=?, genere_nome=? "
					+ "WHERE isbn=?";	
			
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, nome);
			ps.setString(2, descrizione);
			ps.setString(3, immagine);
			ps.setDouble(4, prezzo);
			ps.setInt(5, quantita);
			ps.setString(6, categoria);
			ps.setString(7, genere);
			ps.setString(8, prodotto);
			ps.executeUpdate();
			

			dispatcher = request.getRequestDispatcher("modificaProdotto.jsp");
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
