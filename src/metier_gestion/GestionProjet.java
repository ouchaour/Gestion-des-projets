package metier_gestion;

import Metier.Projet;
import Persistance.DAOProjet;
import Persistance.DAORelation_profe_etudiant;


public class GestionProjet {
	private DAOProjet daoprojet;
	private Projet projet;
	private DAORelation_profe_etudiant relation = new DAORelation_profe_etudiant();
	
	private boolean existe (String titre) {
		if(daoprojet.read(titre)==null)return false;
		else return true;
	}
	
	public void ajouter (Projet projet ) {
		if(!this.existe(projet.getTitre())) {
			daoprojet.creer(projet);
		}
		else System.out.println("Existe deja");
	}
	
	public void delete(String titre) {
		if(this.existe(projet.getTitre())) {
			if(!this.relation.isexist_projet(titre)){
				this.projet=daoprojet.read(titre);
				daoprojet.deleat(projet);
			}else System.out.println("impossible de supprimer un projet dejat affectter");
		}else System.out.println("Existe pas pour le supprimer");
	}
	public void update(Projet projet) {
		daoprojet.update(projet);
	}
	
	public Projet read(String titre) {
		if(this.existe(projet.getTitre())) {
		 this.projet = daoprojet.read(titre);
		return this.projet;
		}else System.out.println("projet n'existe pas");
		return null;
	}
	
}
