package Metier;

public class Etudiant extends Personne{
	private Filiere filiere ;
	private String niveau ;

	public Etudiant() {
		super();
	}
	public Etudiant(String id,String nom, String prenom, String email,Integer password, Filiere filiere, String niveau) {
		super(nom, prenom, email,id,password);
		this.filiere = filiere;
		this.niveau = niveau;

	}
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	

}
