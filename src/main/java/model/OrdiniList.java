package model;

import java.util.ArrayList;

public class OrdiniList {
	private ArrayList<Ordine>list = new ArrayList<>();
	
	public ArrayList<Ordine> getOrdiniList() {
		return list;
	}

	public void add(Ordine o) {
		list.add(o);
	}
	
	public void empty() {
		list.clear();
	}
}
