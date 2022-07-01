package metier_gestion;

import java.util.ArrayList;

import Metier.Departement;
import Metier.Filiere;
import Persistance.DAODepartement;
import Persistance.DAOFiliere;

public class GestionDepartement {
	private Departement departement =new Departement();
	private DAODepartement daoDepartement= new DAODepartement();
	public GestionDepartement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private boolean existe (String nom) {
		if(this.daoDepartement.read(nom)==null)return false;
		else return true;
	}
	
	public void update(Departement depart) {
		if(this.existe(depart.getNom())) {
			this.daoDepartement.update(depart);
		}
		else System.out.println("Departement n'exist pas");
	}
	
	public Departement read(String nom) {
		if(this.existe(nom)) {
			this.departement=daoDepartement.read(nom);
			return this.departement;
		}else System.out.println("Departement n'exist pas");
		return null;
	}
	
	public void add(Departement depart) {
		if(this.existe(depart.getNom())) {
			this.daoDepartement.creer(depart);
		}else  System.out.println("Departement exist deja");
	}
	
	public void delete(String nom) {
		GestionFiliere filiere = new GestionFiliere();
		DAOFiliere daoFiliere= new DAOFiliere();
		ArrayList<Filiere> list =new ArrayList<>(daoFiliere.getall(nom));
		if(this.existe(nom)) {
			this.departement=daoDepartement.read(nom);
			
			for(Filiere e : list) {
				filiere.delete(e.getNom());
			}
			
			this.daoDepartement.deleat(departement);
		}else  System.out.println("Departement exist deja pour la supprimer");
	}
}
