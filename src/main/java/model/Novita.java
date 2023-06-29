package model;

import java.util.ArrayList;
import java.util.List;

public class Novita {
	private ArrayList<Articolo> list = new ArrayList<>();

	
	public List<Articolo> getNovita() {
		return list;
	}

	public void setNovita(List<Articolo> novita) {
		this.list = (ArrayList<Articolo>) novita;
	}
	
	public void add(Articolo p) {
		list.add(p);
	}
	
	public void empty() {
		list.clear();
	}
	
	
}
