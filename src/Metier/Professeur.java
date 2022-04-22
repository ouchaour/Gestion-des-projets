
package Metier;

public class Professeur extends Personne {
	private Departement departement ;
	private String grade ;
	private String password;
	public Professeur() {
		super();
	}
	public Professeur(String nom, String prenom, String email, Departement departement, String grade,int passsword) {
		super(nom, prenom, email);
		this.departement = departement;
		this.grade = grade;
		this.password= password;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	protected String getPassword() {
		return password;
	}
	protected void setPassword(String password) {
		this.password = password;
	}
	
}
