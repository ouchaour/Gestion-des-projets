package Metier;

public class Etudiant extends Personne{
	private Filiere filiere ;
	private String niveau ;
	private String password;
	public Etudiant() {
		super();
	}
	public Etudiant(String nom, String prenom, String email, Filiere filiere, String niveau,String password) {
		super(nom, prenom, email);
		this.filiere = filiere;
		this.niveau = niveau;
		this.password=password;
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
	protected String getPassword() {
		return password;
	}
	protected void setPassword(String password) {
		this.password = password;
	}
	

}
