package servlet;

public class Prodotto {
	private String isbn;
	private String nome;
	private String descrizione;
	private String img;
	private String genere;
	private String categoria;
	private int quantita;
	private double prezzo;
	
	public Prodotto(String isbn, String nome, String descrizione, String img, String genere, String categoria,
			int quantita, double prezzo) {
		super();
		this.isbn = isbn;
		this.nome = nome;
		this.descrizione = descrizione;
		this.img = img;
		this.genere = genere;
		this.categoria = categoria;
		this.quantita = quantita;
		this.prezzo = prezzo;
	}
	
	
	
	@Override
	public String toString() {
		return "Prodotto [isbn=" + isbn + ", nome=" + nome + ", descrizione=" + descrizione + ", img=" + img
				+ ", genere=" + genere + ", categoria=" + categoria + ", quantita=" + quantita + ", prezzo=" + prezzo
				+ "]";
	}



	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
}
