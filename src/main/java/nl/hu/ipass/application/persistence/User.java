package nl.hu.ipass.application.persistence;

public class User {
	private int id;
	private String role;
	private String voornaam;
	private String achternaam;
	private String geboortedatum;
	private String wachtwoord;
	private String emailadres;

	public User(int i, String r, String v, String a, String g, String w,
			String e) {
		setID(i);
		setRole(r);
		setVoornaam(v);
		setAchternaam(a);
		setGeboortedatum(g);
		setWachtwoord(w);
		setEmailadres(e);
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setGeboortedatum(String geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	public String getGeboortedatum() {
		return geboortedatum;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setEmailadres(String emailadres) {
		this.emailadres = emailadres;
	}

	public String getEmailadres() {
		return emailadres;
	}
}
