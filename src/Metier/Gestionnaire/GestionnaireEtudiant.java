package Metier.Gestionnaire;

import Metier.Etudiant;
import Persistance.DaoEtudiant;

public class GestionnaireEtudiant {
	private DaoEtudiant dao;
	private Etudiant etudiant;
	public GestionnaireEtudiant() {
		super();
		this.dao = new DaoEtudiant();
	}
	public Etudiant getEtudiant(String passwd){
		return dao.getEtudiant(passwd);
	}
}
