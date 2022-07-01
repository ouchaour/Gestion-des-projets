package Metier;

public class Professeur extends Personne {
	private Departement departement ;
	private Grade grade ;
	public Professeur() {
		super();
	}
	public Professeur(String id,String nom, String prenom, String email,Integer password, Departement departement, Grade grade) {
		super(nom, prenom, email,id,password);
		this.departement = departement;
		this.grade = grade;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = Grade.valueOf(grade);
	}
	

	
}
