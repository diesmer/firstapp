package nl.hu.ipass.application.persistence;

public class Afspraak {
	private int id;
	private String naam_behandeling;
	private String datum;
	private String tijd;
	private int lengte;
	private int user_id;

	public Afspraak(int i, String nb, String dt, String td, int len, int ui) {
		setID(i);
		setNaam_Behandeling(nb);
		setDatum(dt);
		setTijd(td);
		setLengte(len);
		setUser_ID(ui);
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getNaam_Behandeling() {
		return naam_behandeling;
	}

	public void setNaam_Behandeling(String naam_behandeling) {
		this.naam_behandeling = naam_behandeling;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getTijd() {
		return tijd;
	}

	public void setTijd(String tijd) {
		this.tijd = tijd;
	}

	public int getLengte() {
		return lengte;
	}

	public void setLengte(int lengte) {
		this.lengte = lengte;
	}

	public int getUser_ID() {
		return user_id;
	}

	public void setUser_ID(int user_id) {
		this.user_id = user_id;
	}

}
