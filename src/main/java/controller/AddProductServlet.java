package controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String getFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		String[] tokens = contentDisposition.split(";");
		
		for(String token : tokens) {
			if(token.trim().startsWith("filename")) {
				return token.substring(token.indexOf('=') + 1).trim().replace("\"","");
			}
		}
		return null;
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = null;
		RequestDispatcher dispatcher = null;
		
		String query = "INSERT INTO prodotti(isbn, nome, descrizione, immagine_prod, prezzo, quantita, genere_nome, categoria_nome) values(?,?,?,?, ?, ?, ?, ?)";
		
		
		try {
			String isbn = request.getParameter("isbn");
			String nome = request.getParameter("nome");
			String descrizione = request.getParameter("descrizione");
			String immagine = request.getParameter("immagine");
			double prezzo = Double.parseDouble(request.getParameter("prezzo"));
			int quantita = Integer.parseInt(request.getParameter("quantita"));
			String genere = request.getParameter("genere");
			String categoria = request.getParameter("categoria");
			connection = DbManager.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, isbn);
			ps.setString(2, nome);
			ps.setString(3, descrizione);
			ps.setString(4, immagine);
			ps.setDouble(5, prezzo);
			ps.setInt(6, quantita);
			ps.setString(7, genere);
			ps.setString(8, categoria);
			ps.executeUpdate();
			
			
			Part imagePart = request.getPart("file");
			if(imagePart.getSize() != 0 ) {
				String file = getFileName(imagePart);
				String saveDirectory = "/Users/davidedelfranconatale/Desktop/Eclipse/ProgettoTsw/src/main/webapp/images";
	            String imagePath = saveDirectory+ File.separator + file; // Percorso per salvare l'immagine
	            imagePart.write(imagePath);
			}

			dispatcher = request.getRequestDispatcher("profilo.jsp");
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
