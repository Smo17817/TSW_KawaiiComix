package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Novita implements Serializable{
	private static final long serialVersionUID = 1L;
	private transient ArrayList<Articolo> list = new ArrayList<>();
	
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
