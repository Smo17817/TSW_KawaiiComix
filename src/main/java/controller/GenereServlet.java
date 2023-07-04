package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/GenereServlet")
public class GenereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = null;
		Gson json = new Gson();
		try {
			connection = DbManager.getConnection();
			PrintWriter out = response.getWriter();

			Statement s = connection.createStatement();
			String query = "SELECT nome FROM genere";
			ResultSet rs = s.executeQuery(query);
			ArrayList<String> generi = new ArrayList<>();

			/* Aggiunta generi all'arraylist */
			while (rs.next()) {
				String g = rs.getString("nome");
				generi.add(g);
			}

			Collections.sort(generi);
			out.write(json.toJson(generi));

		} catch (SQLException e) {
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
