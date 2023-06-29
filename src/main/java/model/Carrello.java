package model;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
	private ArrayList<Prodotto> list = new ArrayList<>();
	
	public List<Prodotto> getCarrello() {
		return list;
	}

	public void setCarrello(List<Prodotto> carrello) {
		this.list = (ArrayList<Prodotto>) carrello;
	}

	public void add(Prodotto p) {
		list.add(p);
	}
	
	public void empty() {
		list.clear();
	}
}
