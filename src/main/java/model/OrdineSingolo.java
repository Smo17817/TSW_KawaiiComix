package model;

public class OrdineSingolo {
	private int id;
	private int quantita;
	private double totParziale;
	private int ordini_id;
	private String prodottoIsbn;
	private String prodottoNome;
	private String prodottoImg;
	
	public OrdineSingolo(int id, int quantita, double totParziale, int ordini_id, String prodottoIsbn,
			String prodottoNome, String prodottoImg) {
		super();
		this.id = id;
		this.quantita = quantita;
		this.totParziale = totParziale;
		this.ordini_id = ordini_id;
		this.prodottoIsbn = prodottoIsbn;
		this.prodottoNome = prodottoNome;
		this.prodottoImg = prodottoImg;
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

	public void setTotParziale(double totParziale) {
		this.totParziale = totParziale;
	}

	public int getOrdini_id() {
		return ordini_id;
	}

	public void setOrdini_id(int ordini_id) {
		this.ordini_id = ordini_id;
	}

	public String getProdottoIsbn() {
		return prodottoIsbn;
	}

	public void setProdottoIsbn(String prodottoIsbn) {
		this.prodottoIsbn = prodottoIsbn;
	}

	public String getProdottoNome() {
		return prodottoNome;
	}

	public void setProdottoNome(String prodottoNome) {
		this.prodottoNome = prodottoNome;
	}

	public String getProdottoImg() {
		return prodottoImg;
	}

	public void setProdottoImg(String prodottoImg) {
		this.prodottoImg = prodottoImg;
	}
	
	
	
}
