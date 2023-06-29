package model;

public class Indirizzo {
	private String address;
	private String cap;
	private String citta;
	private String provincia;
	private String nazione;
	
	public Indirizzo(String indirizzo, String cap, String citta, String provincia, String nazione) {
		super();
		this.address = indirizzo;
		this.cap = cap;
		this.citta = citta;
		this.provincia = provincia;
		this.nazione = nazione;
	}

	public String getIndirizzo() {
		return address;
	}

	public void setIndirizzo(String indirizzo) {
		this.address = indirizzo;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	
	
	
}
