package Metier;

import java.util.ArrayList;

public class Departement {
	private String nom ;
	private String email ;
	private Professeur chefDepartement ;
	private ArrayList<Professeur> member = new ArrayList<>();
	public Departement() {
		super();
	}
	public Departement(String nom, String email, Professeur chefDepartement, ArrayList<Professeur> member) {
		super();
		this.nom = nom;
		this.email = email;
		this.chefDepartement = chefDepartement;
		this.member = member;
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
	public Professeur getChefDepartement() {
		return chefDepartement;
	}
	public void setChefDepartement(Professeur chefDepartement) {
		this.chefDepartement = chefDepartement;
	}
	public ArrayList<Professeur> getMember() {
		return member;
	}
	public void setMembre(ArrayList<Professeur> member) {
		this.member = member;
	}
}
