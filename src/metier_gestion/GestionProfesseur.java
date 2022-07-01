package metier_gestion;

import Metier.Professeur;
import Persistance.DAORelation_profe_etudiant;
import Persistance.DaoProfesseur;

public class GestionProfesseur {
	private Professeur prof= new Professeur();
	private DaoProfesseur daoprof= new DaoProfesseur();
	public GestionProfesseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean existe (String id) {
		if(daoprof.read(id)==null)return false;
		else return true;
	}
	
	public void update(Professeur a){
		  if(this.existe(a.getId())) {
		this.daoprof.update(a);}
		  else System.out.println("Professeur n'existe pas");
   }
   public void delete(Professeur a){   // on doit tester si le prof a dejat un projet en cours
	   DAORelation_profe_etudiant relation = new DAORelation_profe_etudiant();
	   if( this.existe(a.getId())) {
		   if(relation.isexist_prof(a.getId())!= true) {
			    this.daoprof.deleat(a);
		   }
		   else System.out.println("Professeur a deja un projet en cours");
	   }else System.out.println("Professeur n'existe pas");
	 
    }
   public void add(Professeur a) {
       if(!this.existe(a.getId())) {
           this.daoprof.creer( a);
       }else System.out.println("Prof existe deja");
    }
   
   public Professeur read (String id ) {
       if(this.existe(id)) {
           prof = daoprof.read(id);
           return prof;
       }else System.out.println("Professeur n'exist pas");
       return null;
   }
}
