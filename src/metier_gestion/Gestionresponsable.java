package metier_gestion;


import Metier.Responsable;
import Persistance.DAOResponsable;

public class Gestionresponsable {
	private Responsable respo = new Responsable();
	private DAOResponsable daorespo = new DAOResponsable();
	public Gestionresponsable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private boolean existe (String respo_id) {
		if(daorespo.read(respo_id)== null)return false;
		else return true;
	}
	
	public void add(Responsable responsable) {
		if(!this.existe(responsable.getID())) {
			this.daorespo.creer(responsable);
		}else System.out.println("Responsable existe dejat");
	}
	
	public void update (Responsable responsable) {
		if(this.existe(responsable.getID())) {
			this.daorespo.update(responsable);
		}else  System.out.println("Responsable n'existe pas");
	}
	
	public void delete(String id) {
		if(this.existe(id)) {
			respo= daorespo.read(id);
			daorespo.deleat(respo);
		}else System.out.println("Responsable n'existe pas pour le supprimer");
	}
	
	public Responsable read (String id ) {
		if(this.existe(id)) {
			respo = daorespo.read(id);
			return respo;
		}else System.out.println("Responsable n'exist pas");
		return null;
	}
}
