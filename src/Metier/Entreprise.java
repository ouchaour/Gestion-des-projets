package Metier;

public class Entreprise {
	private String nom ;
	private String Adresse ;
	private String email ;
	private int telephone ;
	private Personne resposable ;
	
	public Entreprise() {
		super();
	}
	public Entreprise(String nom, String adresse, String email, int telephone, Personne resposable) {
		super();
		this.nom = nom;
		Adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.resposable = resposable;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public Personne getResposable() {
		return resposable;
	}
	public void setResposable(Personne resposable) {
		this.resposable = resposable;
	}
}
