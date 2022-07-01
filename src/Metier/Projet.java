package Metier;

import java.util.ArrayList;
import java.util.Date;

public class Projet  {
	private String titre ;
	private ProjetType type;
	private int duree ;
	private Date dateDeparte ;

	private ArrayList<Etape> etapes = new ArrayList<Etape>();
	public Projet() {
		super();
	}
	
	public Projet(String titre,ProjetType type, int duree, Date dateDeparte, ArrayList<Etape> etapes) {
		super();
		this.titre = titre;
		this.type=type;
		this.duree = duree;
		this.dateDeparte = dateDeparte;
		this.etapes = etapes;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public ProjetType getType() {
		return type;
	}

	public void setType(ProjetType type) {
		this.type = type;
	}

	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Date getDateDeparte() {
		return dateDeparte;
	}
	public void setDateDeparte(Date dateDeparte) {
		this.dateDeparte = dateDeparte;
	}
	public ArrayList<Etape> getEtapes() {
		return etapes;
	}
	public void setEtapes(ArrayList<Etape> etapes) {
		this.etapes = etapes;
	}
	
}
