package model;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
	private ArrayList<Prodotto> list = new ArrayList<>();
	private int Id;
	
	public Carrello(int id) {
		this.Id = id;
	}
	
	public List<Prodotto> getCarrello() {
		return list;
	}
	
	public int getId() {
		return Id;
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
