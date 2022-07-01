package Metier;

import java.util.ArrayList;

public class Laboratoire {
	private String nom ;
	private String email ;
	private Professeur responsable ;
	private ArrayList<Personne> memeber = new ArrayList<>() ;						// type de member 	
	public Laboratoire() {
		super();
	}
	
	public Laboratoire(String nom, String email, Professeur responsable, ArrayList<Personne> memeber) {
		super();
		this.nom = nom;
		this.email = email;
		this.responsable = responsable;
		this.memeber = memeber;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Professeur getResponsable() {
		return responsable;
	}
	public void setResponsable(Professeur responsable) {
		this.responsable = responsable;
	}
	public ArrayList<Personne> getMemeber() {
		return memeber;
	}
	public void setMemeber(ArrayList<Personne> memeber) {
		this.memeber = memeber;
	}
	
}
