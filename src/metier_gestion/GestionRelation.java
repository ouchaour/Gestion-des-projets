package metier_gestion;             // ajout le grad de prof  resposable

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import Metier.Etudiant;
import Metier.Professeur;
import Metier.Projet;
import Persistance.DAOProjet;
import Persistance.DAORelation_profe_etudiant;
import Persistance.DaoEtudiant;
import Persistance.DaoProfesseur;

public class GestionRelation {
	private DAORelation_profe_etudiant relation = new DAORelation_profe_etudiant();
	
	
	private boolean existeEtudiant(String etudiant_id){
		if(relation.getprofesseur(etudiant_id)== null) return true;
		else return false;
	}
	private boolean ExisteProjet(String titre) {
		if(relation.isexist_projet(titre))return false;
		else return true;
	}
	
	private void ajouter_final (String prof_id , String etudiant_id , String projet_titre) {
		if(!this.existeEtudiant(etudiant_id)) {
			if(!this.ExisteProjet(projet_titre)){
				this.relation.creer(prof_id, etudiant_id, projet_titre);
			}else System.out.println("Projet deja affecté");
			
		}else System.out.println("Etudiant a deja a projet en cour");
	}
	
	private boolean peutAffecteProjet(String prof_id, String projet_titre) {    // test si le grade du prof lui permet d'affecter le projet et test le mois
		DaoProfesseur daoprof= new DaoProfesseur();
		DAOProjet daoProjet = new DAOProjet();
		Professeur professeur= new Professeur();
		Projet projet = new Projet();
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();// get le mois 
		
		professeur = daoprof.read(prof_id);
		projet = daoProjet.read(projet_titre);
		
		if(professeur.getGrade().toString().equals("Responsable") &&  projet.getType().toString().equals("Doctorat") && month==10)return true; 
		if(professeur.getGrade().toString().equals("Cordonateur") && ((projet.getType().toString().equals("PFA")&& month==6 )|| (projet.getType().toString()=="PFE"&&  month==2))) return true;
		else return false;
	}
	
	private boolean peutAffecteEtudiant(String prof_id, String etudiant_id) { // le prof et l'etudiant appartienent à la même departement
		DaoProfesseur daoprof= new DaoProfesseur();
		DaoEtudiant daoEtudiant = new DaoEtudiant();
		Professeur professeur= new Professeur();
		Etudiant etudiant = new Etudiant();
		
		professeur = daoprof.read(prof_id);
		etudiant= daoEtudiant.read(etudiant_id);
		
		if(professeur.getDepartement().getNom()==etudiant.getFiliere().getDepartementAttache().getNom())return true;
		else return false;
	}
	
	public void add(String prof_id , String etudiant_id , String projet_titre) {
		if(this.peutAffecteEtudiant(prof_id, etudiant_id)) {
			if(this.peutAffecteProjet(prof_id, projet_titre)) {
				this.ajouter_final(prof_id, etudiant_id, projet_titre);
			}else System.out.println("le grade du professeur ne lui permet pas d'affecter ce type de projet ou ce projet projet ne peut etre affecte dans ce mois");
		}else System.out.println(" le professeur ne peut pas affecte projet a un etudiant d'autre departement");
	}
	
	
	public void update (String prof_id , String etudiant_id , String projet_titre) {
		this.delete(etudiant_id);
		this.add(prof_id, etudiant_id, projet_titre);
	}
	
	
	public void delete(String etudiant_id) {
		if(this.existeEtudiant(etudiant_id)) {
			this.relation.delete(etudiant_id);
		}else System.out.println("L'etudiant n'exist pas");
	}
}
