package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		RequestDispatcher dispatcher = null;
		PrintWriter out = response.getWriter();
		Gson json = new Gson();
		String pattern = "\\./images/[^/]+\\.[a-zA-Z]{3,4}";
		String prodotto = (String) request.getParameter("scelta");
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String immagine = request.getParameter("immagine");
		double prezzo = 0.00;
		String prezzoString = request.getParameter("prezzo");
		String quantitaString = request.getParameter("quantita");
		int quantita = -1;
		String genere = request.getParameter("genere");
		String categoria = request.getParameter("categoria");
		
		if (prodotto.equals("") || prodotto.equals("-seleziona un prodotto-")) {
			HashMap<String, String> responseMap = new HashMap<>();
            responseMap.put("status", "Invalid_prodotto");
            String jsonResponse = json.toJson(responseMap);
            response.setContentType("application/json");
            out.write(jsonResponse);
            out.flush();
			return;
		}
		
		if(nome.equals("")) {
			HashMap<String, String> responseMap = new HashMap<>();
            responseMap.put("status", "Invalid_nome");
            String jsonResponse = json.toJson(responseMap);
            response.setContentType("application/json");
            out.write(jsonResponse);
            out.flush();
			return;
		}
		
		if(descrizione.equals("")) {
			HashMap<String, String> responseMap = new HashMap<>();
            responseMap.put("status", "Invalid_descrizione");
            String jsonResponse = json.toJson(responseMap);
            response.setContentType("application/json");
            out.write(jsonResponse);
            out.flush();
			return;
		}
		
		Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(immagine);
		
		if(immagine.equals("") || !(matcher.matches())) {
			HashMap<String, String> responseMap = new HashMap<>();
            responseMap.put("status", "Invalid_path");
            String jsonResponse = json.toJson(responseMap);
            response.setContentType("application/json");
            out.write(jsonResponse);
            out.flush();
			return;
		}
		
		
		if((prezzoString == null) || (prezzoString.isEmpty())) {
		    	System.out.println("ciao");
				HashMap<String, String> responseMap = new HashMap<>();
	            responseMap.put("status", "Invalid_prezzo");
	            String jsonResponse = json.toJson(responseMap);
	            response.setContentType("application/json");
	            out.write(jsonResponse);
	            out.flush();
				return;
	    }else {
		    prezzo = Double.parseDouble(prezzoString);
		    if(prezzo == 0.00) {
				HashMap<String, String> responseMap = new HashMap<>();
	            responseMap.put("status", "Invalid_prezzo");
	            String jsonResponse = json.toJson(responseMap);
	            response.setContentType("application/json");
	            out.write(jsonResponse);
	            out.flush();
				return;
		    }
	    }
	    	
		
		

		if((quantitaString == null) || (quantitaString.isEmpty())) {
				HashMap<String, String> responseMap = new HashMap<>();
	            responseMap.put("status", "Invalid_quantita");
	            String jsonResponse = json.toJson(responseMap);
	            response.setContentType("application/json");
	            out.write(jsonResponse);
	            out.flush();
				return;
		}else {
			quantita = Integer.parseInt(quantitaString);
			if(quantita == 0) {
				HashMap<String, String> responseMap = new HashMap<>();
	            responseMap.put("status", "Invalid_quantita");
	            String jsonResponse = json.toJson(responseMap);
	            response.setContentType("application/json");
	            out.write(jsonResponse);
	            out.flush();
				return;
				
			}
		}
		
		
		if(genere.equals("") || genere.equals("-scegliere genere-")) {
			HashMap<String, String> responseMap = new HashMap<>();
            responseMap.put("status", "Invalid_genere");
            String jsonResponse = json.toJson(responseMap);
            response.setContentType("application/json");
            out.write(jsonResponse);
            out.flush();
			return;
		}
		
		if(categoria.equals("") || categoria.equals("-scegliere categoria")) {
			HashMap<String, String> responseMap = new HashMap<>();
            responseMap.put("status", "Invalid_categoria");
            String jsonResponse = json.toJson(responseMap);
            response.setContentType("application/json");
            out.write(jsonResponse);
            out.flush();
			return;
		}
		
		try {
			
			int rowCount =0;
			connection = DbManager.getConnection();
			String query = "SELECT isbn FROM prodotti WHERE nome = '" + prodotto + "'";
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(query);
			
			rs.next();
			String isbn = rs.getString("isbn");
					
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
			ps.setString(8, isbn);
			rowCount = ps.executeUpdate();
			
			if(rowCount > 0) {
				HashMap<String, String> responseMap = new HashMap<>();
	            responseMap.put("status", "success");
	            responseMap.put("url", "profilo.jsp");
	            String jsonResponse = json.toJson(responseMap);
	            response.setContentType("application/json");
	            out.write(jsonResponse);
	            out.flush();
	            return;
			}
			else {
				HashMap<String, String> responseMap = new HashMap<>();
	            responseMap.put("status", "failed");
	            String jsonResponse = json.toJson(responseMap);
	            response.setContentType("application/json");
	            out.write(jsonResponse);
	            out.flush();
	            return;
			}

		} catch (SQLException e) {
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
