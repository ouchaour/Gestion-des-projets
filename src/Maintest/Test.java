package Maintest;
import java.util.ArrayList;

import Metier.Etudiant;
import Persistance.DaoEtudiant;

public class Test {
	public static void main(String[] args) {
		DaoEtudiant dao = new DaoEtudiant();
		
		System.out.println(45);
		ArrayList<Etudiant> array  = dao.getAll();
		for (Etudiant etudiant : array) {
			System.out.println(etudiant);
		}
		
	}
}
