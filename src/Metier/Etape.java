package Metier;

public class Etape {
	private String duree ;
	private String premierEtape;
	private Documentation documentation ;			
	private Documentation livraison ;
	public Etape() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Etape(String duree, String premierEtape, Documentation documentation, Documentation livraison) {
		super();
		this.duree = duree;
		this.premierEtape = premierEtape;
		this.documentation = documentation;
		this.livraison = livraison;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public String getPremierEtape() {
		return premierEtape;
	}
	public void setPremierEtape(String premierEtape) {
		this.premierEtape = premierEtape;
	}
	public Documentation getDocumentation() {
		return documentation;
	}
	public void setDocumentation(Documentation documentation) {
		this.documentation = documentation;
	}
	public Documentation getLivraison() {
		return livraison;
	}
	public void setLivraison(Documentation livraison) {
		this.livraison = livraison;
	}
	
	
	
	
}
