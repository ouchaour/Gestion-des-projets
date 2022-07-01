package metier_gestion;     //pas de delete

import Metier.Etape;
import Persistance.DAOEtape;

public class GestionEtape {
	private Etape etape = new Etape();
	private DAOEtape daoetape= new DAOEtape();
	public GestionEtape() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private boolean existe (String premieretape) {
		if(daoetape.read(premieretape)== null)return false;
		else return true;
	}
	
	public void add(Etape etape) {
		if(!this.existe(etape.getPremierEtape())) {
			this.daoetape.creer(etape);
		}else System.out.println("Etape existe dejat");
	}
	
	public void update (Etape etape) {
		if(this.existe(etape.getPremierEtape())) {
			this.daoetape.update(etape);
		}else  System.out.println("Etape n'existe pas");
	}
	
	public Etape read(String premieretape) {
		if(!this.existe(premieretape)) {
			this.etape= daoetape.read(premieretape);
			  return etape;
        }else System.out.println("Etape n'exist pas");
        return null;
	}
	
}
