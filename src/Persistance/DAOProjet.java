package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Metier.Etape;
import Metier.Projet;
import Metier.ProjetType;

public class DAOProjet implements DAOCRUD<Projet,String> { //titre ; type

	@Override
	public void creer(Projet a) {
		// TODO Auto-generated method stub
		String titre = a.getTitre();
		String type = a.getType().toString();
		Integer duree = a.getDuree();
		Date dateDepart= a.getDateDeparte();
		ArrayList <Etape>list=a.getEtapes();
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet = "INSERT INTO Projet (Titre,Type,Duree,Date de depart,Etapes) VALUES (?,?,?,?)";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1, titre);
			ps.setString(2, type);
			ps.setInt(3, duree);
			ps.setDate(4,  (java.sql.Date) dateDepart);
			String etapes = "";
		    for(Etape e : list) { 
		        if(etapes.equals("")) {
		            etapes = e.getPremierEtape();
		        } else {
		            etapes +="," + e.getPremierEtape();
		        }
		    }
		    ps.setString(4,etapes);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

	@Override
	public Projet read(String titre) {
		
		Integer duree = null;
		ProjetType type = null;
		Date dateDepart= null;
		ArrayList <Etape>list_etapes=new ArrayList<>();
		Etape one_etape=new Etape();
		DAOEtape daoetape= new DAOEtape();
		String etapes[]=null;
		
		ResultSet resultat = null;
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet="SELECT * FROM Projet WHERE Titre=?";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1,	titre);
			resultat = ps.executeQuery();
		}catch(SQLException e) {
			System.out.println(e);
		}
		try{
			while(resultat.next()) {
				duree=resultat.getInt("Duree");
				type=ProjetType.valueOf(resultat.getString("Type"));
				dateDepart=resultat.getDate("Date de depart");
				etapes=resultat.getString("Etapes").split(",");
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		for(String i : etapes) {
			one_etape=daoetape.read(i);
			list_etapes.add(one_etape);
			}
		Projet p = new Projet(titre,type, duree, dateDepart,list_etapes);
		return p;
	}

	@Override
	public void update(Projet a) {
		// TODO Auto-generated method stub
		String titre = a.getTitre();
		String type = a.getType().toString();
		Integer duree = a.getDuree();
		Date dateDepart= a.getDateDeparte();
		ArrayList <Etape>list=a.getEtapes();
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet = "Update Projet set Titre=?,Type=?,Duree=?,Date de depart=?,Etapes=? WHERE Titre=?";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1, titre);
			ps.setString(2, type);
			ps.setInt(3, duree);
			ps.setDate(4, (java.sql.Date) dateDepart);
			String etapes = "";
		    for(Etape e : list) { 
		        if(etapes.equals("")) {
		            etapes = e.getPremierEtape();
		        } else {
		            etapes +="," + e.getPremierEtape();
		        }
		    }
		    ps.setString(5,etapes);
		    ps.setString(6, titre);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleat(Projet a) {
		// TODO Auto-generated method stub
	String titre =a.getTitre();
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		try {
			String requet ="DELETE FROM Projet WHERE Titre=?";
			
			ps= conn.prepareStatement(requet);
			ps.setString(1, titre);
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
