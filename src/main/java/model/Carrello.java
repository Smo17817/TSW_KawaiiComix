package model;

import java.util.ArrayList;

public class Carrello {
	private ArrayList<Prodotto> carrello = new ArrayList<>();
	
	public ArrayList<Prodotto> getCarrello() {
		return carrello;
	}

	public void setCarrello(ArrayList<Prodotto> carrello) {
		this.carrello = carrello;
	}

	public void add(Prodotto p) {
		carrello.add(p);
	}
	
	public void empty() {
		carrello.clear();
	}
}
