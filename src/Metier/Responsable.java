package Metier;

public class Responsable {
	private String ID;
	private String nom;
	private Integer telephone;
	private String adresse;
	public Responsable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Responsable(String ID,String nom, Integer telephone, String adresse) {
		super();
		this.ID=ID;
		this.nom = nom;
		this.telephone = telephone;
		this.adresse = adresse;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getTelephone() {
		return telephone;
	}
	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	
}
