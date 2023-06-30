package controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = null;
		RequestDispatcher dispatcher = null;
		
		/*if (ServletFileUpload.isMultipartContent(request)) {
	    try {
	        // Creazione di un oggetto FileItemFactory
	        DiskFileItemFactory factory = new DiskFileItemFactory();

	        // Impostazione della directory temporanea in cui verranno memorizzati i file
	        File tempDir = (File) getServletContext().getAttribute("javax.servlet.context.tempdir");
	        factory.setRepository(tempDir);

	        // Creazione di un oggetto ServletFileUpload
	        ServletFileUpload fileUpload = new ServletFileUpload(factory);

	        // Parsing della richiesta per ottenere una lista di oggetti FileItem
	        List<FileItem> items = fileUpload.parseRequest(request);

	        // Iterazione sugli oggetti FileItem
	        for (FileItem item : items) {
	            // Controllo se l'oggetto FileItem rappresenta un campo di input di tipo file
	            if (!item.isFormField()) {
	                // Ottenimento del nome dell'immagine
	                String fileName = item.getName();

	                // Spostamento dell'immagine nella cartella del tuo progetto
	                File uploadDir = new File("ProgettoTsw/src/main/webapp/images");
	                if (!uploadDir.exists()) {
	                    uploadDir.mkdirs();
	                }
	                System.out.print(uploadDir);
	                File uploadedFile = new File(uploadDir, fileName);
	                System.out.print(uploadedFile);
	                item.write(uploadedFile);

	                // Esegui altre azioni necessarie con l'immagine
	                // ...

	                // Invio di una risposta al client
	                response.getWriter().println("Upload completato: " + fileName);
	            }
	        }
	    } catch (Exception e) {
	        response.getWriter().println("Upload fallito: " + e.getMessage());
	    }
	} else {
	    response.getWriter().println("La richiesta non contiene un file caricato.");
	} */
		String query = "INSERT INTO prodotti(isbn, nome, descrizione, immagine_prod, prezzo, quantita, genere_nome, categoria_nome) values(?,?,?,?, ?, ?, ?, ?)";
		
		
		try {
			String isbn = request.getParameter("isbn");
			System.out.print(isbn);
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
