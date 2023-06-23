package servlet;

import java.util.ArrayList;

public class Catalogo {
	private ArrayList<Prodotto> catalogo = new ArrayList<>();
	
	public ArrayList<Prodotto> getCatalogo() {
		return catalogo;
	}

	public void setCarrello(ArrayList<Prodotto> carrello) {
		this.catalogo = carrello;
	}

	public void add(Prodotto p) {
		catalogo.add(p);
	}
	
	public void empty(Prodotto p) {
		catalogo.clear();
	}
}
