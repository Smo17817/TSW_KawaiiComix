package model;

import java.util.Date;

public class Articolo {
	private int id;
	private String titolo;
	private String sottotitolo;
	private Date data;
	private String corpo;
	private String video;
	private String immagine;
	
	

	public Articolo(int id, String titolo, String sottotitolo, Date data, String corpo, String video, String immagine) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.sottotitolo = sottotitolo;
		this.data = data;
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

	public String getSottotitolo() {
		return sottotitolo;
	}

	public void setSottotitolo(String sottotitolo) {
		this.sottotitolo = sottotitolo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
