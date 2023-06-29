package model;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	private ArrayList<Prodotto> list = new ArrayList<>();
	
	public List<Prodotto> getCatalogo() {
		return list;
	}
	
	public void add(Prodotto p) {
		list.add(p);
	}
	
	public void empty() {
		list.clear();
	}
}
