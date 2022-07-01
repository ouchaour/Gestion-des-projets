package metier_gestion;


import Metier.Etudiant;
import Persistance.DaoEtudiant;

public class GestionEtudiant {
	private Etudiant etudiant= new Etudiant();
	private DaoEtudiant daoEtudiant = new DaoEtudiant();

	public GestionEtudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private boolean existe (String id) {
		if(daoEtudiant.read(id)==null)return false;
		else return true;
	}
	
	 public void update(Etudiant a){
		  if(this.existe(a.getId())) {
			this.daoEtudiant.update(a);}
			  else System.out.println("Etudiant n'existe pas");
		   
		}
	 
	 
	 public void delete(Etudiant a){
		 GestionRelation relation = new GestionRelation();
		 if(this.existe(a.getId())) {
			 relation.delete(a.getId());
			 this.daoEtudiant.deleat(a);
			 
			 
		 }
		 else System.out.println("N'exist pas pour le supprimer");
		 }
	 
	 
	 
	 public void add(Etudiant a) {
		if(!this.existe(a.getId())) {
			this.daoEtudiant.creer(a);			
			}else System.out.println("Etudiant existe deja");
		}
	 
	 public Etudiant read (String id ) {
	       if(this.existe(id)) {
	           etudiant = daoEtudiant.read(id);
	           return etudiant;
	       }else System.out.println("Professeur n'exist pas");
	       return null;
	   }
		 
}
