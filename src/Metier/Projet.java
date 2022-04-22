package Metier;

import java.util.ArrayList;

public class Projet  {
	private String titre ;
	private int duree ;
	private int dateDeparte ;

	private ArrayList<Etape> etapes = new ArrayList<Etape>();
	public Projet() {
		super();
	}
	public Projet(String titre, int duree, int dateDeparte ) {
		super();
		this.titre = titre;
		this.duree = duree;
		this.dateDeparte = dateDeparte;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public int getDateDeparte() {
		return dateDeparte;
	}
	public void setDateDeparte(int dateDeparte) {
		this.dateDeparte = dateDeparte;
	}

}
