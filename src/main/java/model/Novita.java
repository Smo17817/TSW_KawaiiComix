package model;

import java.util.ArrayList;
import java.util.List;

public class Novita {
	ArrayList<Articolo> list = new ArrayList<>();
	
	public Novita() {
		super();
	}

	public List<Articolo> getNovita() {
		return list;
	}
	
	public void add(Articolo a) {
		list.add(a);
	}
}
