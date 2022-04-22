package Persistance;
import Metier.Etudiant;
import Metier.Filiere;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoEtudiant {
	Connection conn;
	public DaoEtudiant(){
		conn = Connexion.getConnexion();
	}
	public ArrayList<Etudiant> getAll() {
	ArrayList<Etudiant> list = new ArrayList<Etudiant>();
	ResultSet resultat = null;
	try {
		resultat = this.conn.createStatement().executeQuery("SELECT * FROM etudiant");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    String nom="";
    String prenom="";
    String email="";
    Filiere flr=new Filiere(); 
    String niveau="";
    String filiere="";
    String passwd="";
	try {
		while(resultat.next())
		{
		    nom = resultat.getString("nom");
		    prenom = resultat.getString("prenom");
		    email = resultat.getString("email");
		    filiere= resultat.getString("filiere");
		    niveau = resultat.getString("niveau");
		    passwd = resultat.getString("passwd");
		    flr.setNom(filiere);
		    list.add(new Etudiant(nom, prenom,email, flr,niveau,passwd));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
	}
	public Etudiant getEtudiant(String passwd){
		Etudiant Etudiant;
		ResultSet resultat = null;
		try {
			resultat = this.conn.createStatement().executeQuery("SELECT * FROM etudiant where "
					+ "passwd = " + "'passwd'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nom = null;
		String prenom = null;
	    String email=null;
	    Filiere flr=new Filiere(); 
	    String niveau=null;
	    String filiere=null;
	    String passwd1=null;
		boolean isEmpty=false;
		try {
			while(resultat.next())
			{
			    isEmpty=true;
			    nom = resultat.getString("nom");
			    prenom = resultat.getString("prenom");
			    email = resultat.getString("email");
			    filiere= resultat.getString("filiere");
			    niveau = resultat.getString("niveau");
			    passwd1 = resultat.getString("passwd");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isEmpty){
			Etudiant = new Etudiant(nom, prenom,email,flr,niveau,passwd1);
			return Etudiant;
		}
		else return null;
	}
}
