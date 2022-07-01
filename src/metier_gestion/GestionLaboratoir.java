package metier_gestion;

import Metier.Laboratoire;
import Persistance.DAOLaboratoire;

public class GestionLaboratoir {
	private Laboratoire labo = new Laboratoire();
	private DAOLaboratoire daolabo = new DAOLaboratoire();
	public GestionLaboratoir() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private boolean existe(String nom) {
		if(this.daolabo.read(nom)==null)return false;
		else return true;
	}
	
	public void add(Laboratoire lab) {
		if(!this.existe(lab.getNom())) {
			daolabo.creer(lab);
		}else System.out.println("L'aboratoir existe deja ");
	}
	
	public Laboratoire read(String nom) {
		if(this.existe(nom)) {
			this.labo=daolabo.read(nom);
			return labo;
		}else System.out.println("L'aboratoir n'existe pas");
		return null;
	}
	
	public void update(Laboratoire lab) {
		if(this.existe(lab.getNom())) {
			daolabo.update(lab);
		}else System.out.println("L'aboratoir n'existe pas");
	}
	public void delete(String nom) {
		if(this.existe(nom)) {
			this.labo= daolabo.read(nom);
			this.daolabo.deleat(labo);
		}else  System.out.println("L'aboratoir n'existe pas pour le supprimer");
	}
}
