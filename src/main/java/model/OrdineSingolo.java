package model;

import servlet.Prodotto;

public class OrdineSingolo {
	private int id;
	private int quantita;
	private double totParziale;
	private int ordini_id;
	private Prodotto prodotto;
	
	public OrdineSingolo(int id, int quantita, double totParziale, int ordini_id, Prodotto prodotto) {
		super();
		this.id = id;
		this.quantita = quantita;
		this.totParziale = totParziale;
		this.ordini_id = ordini_id;
		this.prodotto = prodotto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getTotParziale() {
		return totParziale;
	}

	public int getOrdini_id() {
		return ordini_id;
	}

	public void setOrdini_id(int ordini_id) {
		this.ordini_id = ordini_id;
	}

	public void setTotParziale(double totParziale) {
		this.totParziale = totParziale;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	
	
}
