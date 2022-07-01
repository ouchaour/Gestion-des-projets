package Metier;

public class Entreprise {
	private String nom ;
	private String Adresse ;
	private String email ;
	private int telephone ;
	private Responsable resposable ;
	
	public Entreprise() {
		super();
	}
	public Entreprise(String nom, String adresse, String email, int telephone, Responsable resposable) {
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
	public Responsable getResposable() {
		return resposable;
	}
	public void setResposable(Responsable resposable) {
		this.resposable = resposable;
	}
}
