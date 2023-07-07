package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrello;
import model.Prodotto;

/**
 * Servlet implementation class RimuoviProdotto
 */
@WebServlet("/RimuoviProdotto")
public class RimuoviProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimuoviProdotto() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Carrello carrello = (Carrello) session.getAttribute("carrello");
		String isbnProdotto = request.getParameter("isbn");
		RequestDispatcher dispatcher = null;
		
		ArrayList<Prodotto> list = (ArrayList<Prodotto>) carrello.getCarrello();
		

		for(Prodotto p : list) {
			if(isbnProdotto != null) {
				if(p.getIsbn().equals(isbnProdotto)) {
					list.remove(p);
					break;
				}
			}else {
					return;
			}
		}
		
		carrello.setCarrello(list);
		session.setAttribute("carrello", carrello);
		
		return;
			
	}

}
