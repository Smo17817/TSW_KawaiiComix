package model;

public class Articolo {
	private int id;
	private String titolo, corpo;
	private String video, immagine;
	
	

	public Articolo(int id, String titolo, String corpo, String video, String immagine) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.corpo = corpo;
		this.video = video;
		this.immagine = immagine;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	
	
}
