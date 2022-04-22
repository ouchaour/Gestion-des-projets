package Metier;

public class Filiere {
	private String nom ;
	private Departement departementAttache ;
	private Professeur coordonnateur ;          // type should be member
	public Filiere() {
		super();
	}
	public Filiere(String nom, Departement departementAttache, Professeur coordonnateur) {
		super();
		this.nom = nom;
		this.departementAttache = departementAttache;
		this.coordonnateur = coordonnateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Departement getDepartementAttache() {
		return departementAttache;
	}
	public void setDepartementAttache(Departement departementAttache) {
		this.departementAttache = departementAttache;
	}
	public Professeur getCoordonnateur() {
		return coordonnateur;
	}
	public void setCoordonnateur(Professeur coordonnateur) {
		this.coordonnateur = coordonnateur;
	}
}
