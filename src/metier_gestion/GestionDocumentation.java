package metier_gestion;



import Metier.Documentation;

import Persistance.DAODocumentation;

public class GestionDocumentation {
	 private Documentation doc = new Documentation();
	 private DAODocumentation daoDocumentation = new DAODocumentation();
	public GestionDocumentation() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	  private boolean existe (String titre) {
	        if(daoDocumentation.read(titre)==null)return false;
	        else return true;
	    }
	    public void add(Documentation a) {
	        if(!this.existe(a.getTitre())) {
	            daoDocumentation.creer(a);
	        }
	        else System.out.println("cet Filiere existe deja!");
	    }
	    public void update(Documentation a){
	         this.daoDocumentation.update(a);
	    }
	    public void delete(String titre){
	        if(this.existe(titre)) {
	        this.doc = daoDocumentation.read(titre);
	        daoDocumentation.deleat(doc);
	            }else System.out.println("le projet n'existe pas !");
	     }
	    public Documentation read(String titre) {
	        if(this.existe(titre)) {
	            this.doc = daoDocumentation.read(titre);
	            return this.doc;}
	        else System.out.println("le projet n'existe pas!");
	        return null ;
	    }
}
