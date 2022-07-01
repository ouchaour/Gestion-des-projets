package metier_gestion;

import Metier.Entreprise;
import Persistance.DAOEntreprise;

public class GestionEntreprise {
    private Entreprise entrop = new Entreprise();
    private DAOEntreprise daoentrop = new DAOEntreprise();


    public GestionEntreprise() {
        super();
        // TODO Auto-generated constructor stub
    }

    private boolean existe (String nom) {
        if(daoentrop.read(nom)== null)return false;
        else return true;
    }

    public void add(Entreprise entrop) {
        if(!this.existe(entrop.getNom())) {
            this.daoentrop.creer(entrop);
        }else System.out.println("Entroprise existe dejat");
    }

    public void update (Entreprise entrop) {
        if(this.existe(entrop.getNom())) {
            this.daoentrop.update(entrop);
        }else  System.out.println("Entroprise n'existe pas");
    }

    public void delete(String nom) {
        if(this.existe(nom)) {
            entrop= daoentrop.read(nom);
            daoentrop.deleat(entrop);
        }else System.out.println("Entroprise n'existe pas pour le supprimer");
    }

    public Entreprise read (String nom ) {
        if(this.existe(nom)) {
            entrop = daoentrop.read(nom);
            return entrop;
        }else System.out.println("Responsable n'exist pas");
        return null;
    }
}
