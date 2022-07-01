package metier_gestion;

import Metier.Filiere;
import Persistance.DAOFiliere;

public class GestionFiliere {

	private DAOFiliere daofilliere;
    private Filiere filiere;
    public GestionFiliere() {
        super();

    }
    private boolean existe (String nom) {
        if(daofilliere.read(nom)==null)return false;
        else return true;
    }
    public void add(Filiere a) {
        if(!this.existe(a.getNom())) {
            daofilliere.creer(a);
        }
        else System.out.println("cet Filiere existe deja!");
    }
    public void update(Filiere a){
         this.daofilliere.update(a);
    }
    public void delete(String titre){
        if(this.existe(titre)) {
        this.filiere = daofilliere.read(titre);
        daofilliere.deleat(filiere);
            }else System.out.println("le projet n'existe pas !");
     }
    public Filiere read(String nom) {
        if(this.existe(nom)) {
            this.filiere = daofilliere.read(nom);
            return this.filiere;}
        else System.out.println("le projet n'existe pas!");
        return null ;
    }
}
