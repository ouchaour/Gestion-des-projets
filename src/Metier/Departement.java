package Metier;

import java.util.ArrayList;

public class Departement {
	private String nom ;
	private String email ;
	private Professeur chef ;
	private ArrayList<Professeur> member = new ArrayList<>();
	public Departement() {
		super();
	}
	
	public Departement(String nom, String email, Professeur chef, ArrayList<Professeur> member) {
		super();
		this.nom = nom;
		this.email = email;
		this.chef = chef;
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
		return chef;
	}
	public void setChefDepartement(Professeur chefDepartement) {
		this.chef = chefDepartement;
	}
	public ArrayList<Professeur> getMember() {
		return member;
	}
	public void setMembre(ArrayList<Professeur> member) {
		this.member = member;
	}
	public void ajouter_Membre(Professeur a) {
		this.member.add(a);
	}
	public void delete_membre(Professeur a) {
		this.member.remove(a);
	}
	public boolean chek_membre(Professeur a) {
		if(this.member.contains(a)) return true;
		else return false ;
	}
}
