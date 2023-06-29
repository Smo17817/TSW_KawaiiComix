package model;

import java.util.ArrayList;
import java.util.List;

public class OrdiniList {
	private ArrayList<Ordine>list = new ArrayList<>();
	
	public List<Ordine> getOrdiniList() {
		return list;
	}

	public void add(Ordine o) {
		list.add(o);
	}
	
	public void empty() {
		list.clear();
	}
}
