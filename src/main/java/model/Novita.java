package model;

import java.util.ArrayList;

public class Novita {
	ArrayList<Articolo> list = new ArrayList<>();
	
	public Novita() {
		super();
	}

	public ArrayList<Articolo> getNovita() {
		return list;
	}
	
	public void add(Articolo a) {
		list.add(a);
	}
}
