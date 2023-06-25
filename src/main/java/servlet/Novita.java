package servlet;

import java.util.ArrayList;

public class Novita {
	private ArrayList<Articolo> novita = new ArrayList<>();

	
	public ArrayList<Articolo> getNovita() {
		return novita;
	}

	public void setNovita(ArrayList<Articolo> novita) {
		this.novita = novita;
	}
	
	public void add(Articolo p) {
		novita.add(p);
	}
	
	public void empty(Articolo p) {
		novita.clear();
	}
	
	
}
