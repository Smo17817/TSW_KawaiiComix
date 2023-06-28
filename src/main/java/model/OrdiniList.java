package model;

import java.util.ArrayList;

public class OrdiniList {
	private ArrayList<Ordine> ordiniList = new ArrayList<>();
	
	public ArrayList<Ordine> getOrdiniList() {
		return ordiniList;
	}

	public void add(Ordine o) {
		ordiniList.add(o);
	}
	
	public void empty() {
		ordiniList.clear();
	}

	public void setOrdiniList(ArrayList<Ordine> ordiniList) {
		this.ordiniList = ordiniList;
	}
}
