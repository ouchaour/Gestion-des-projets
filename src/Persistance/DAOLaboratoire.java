package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Metier.Etudiant;
import Metier.Laboratoire;
import Metier.Personne;
import Metier.Professeur;

public class DAOLaboratoire implements DAOCRUD<Laboratoire, String> {

	@Override
	public void creer(Laboratoire a) {
		// TODO Auto-generated method stub
		String nom = a.getNom();
		String email= a.getEmail();
		String responsable_id = a.getResponsable().getId();
		ArrayList<Personne>memeber =a.getMemeber();
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet = "INSERT INTO Laboratoir(Nom,Email,Responsable,Membres) VALUES (?,?,?,?)";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1, nom);
			ps.setString(2, email);
			ps.setString(3, responsable_id);
			String membres = "";
		    for(Personne e : memeber) { 
		        if(membres.equals("")) {
		            membres = e.getId();
		        } else {
		            membres += "," + e.getId();
		        }
		    } 
		    ps.setString(4,membres);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Laboratoire read(String nom) {
		// TODO Auto-generated method stub
		String email = null;
		String resp_id=null;
		Professeur resp = new Professeur();
		String all_membre_id[]=null;
		ArrayList <Personne> members=new ArrayList<>();
		Professeur one_membre_prof = new Professeur();
		Etudiant one_membre_etud= new Etudiant();
		DaoProfesseur daoprof=new  DaoProfesseur();
		DaoEtudiant daoetud=new DaoEtudiant();
		
		
		
		ResultSet resultat = null;
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		try {
			String requet="SELECT * FROM Laboratoire WHERE Nom=?";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1,	nom);
			resultat = ps.executeQuery();
		}catch(SQLException e) {
			System.out.println(e);
		}
		try{
			while(resultat.next()) {
				email=resultat.getString("Email");
				resp_id=resultat.getString("Responsable");
				all_membre_id=resultat.getString("Members").split(",");
			}	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//on chereche le membre(prof) avec l'id utilisent daoprof puis on l'ajoute dans arraylist
		for(String i : all_membre_id) {
				if(daoetud.read(i)==null) {
					one_membre_prof=daoprof.read(i);
					members.add(one_membre_prof);
				}else {
					one_membre_etud=daoetud.read(i);
					members.add(one_membre_etud);
				}
			one_membre_prof=daoprof.read(i);
			
		
			
			
		}
		
		resp =daoprof.read(resp_id);// chereche les info du resp dans Daoprof 
		Laboratoire e= new Laboratoire(nom,email,resp,members);
		return e;
	}

	@Override
	public void update(Laboratoire a) {
		// TODO Auto-generated method stub
		String nom = a.getNom();
		String email= a.getEmail();
		String responsable_id = a.getResponsable().getId();
		ArrayList<Personne>memeber =a.getMemeber();
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet = "UPDATE Laboratoir SET Nom=?,Email=?,Responsable=?,Membres=? WHERE Nom=?";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1, nom);
			ps.setString(2, email);
			ps.setString(3, responsable_id);
			String membres = "";
		    for(Personne e : memeber) { 
		        if(membres.equals("")) {
		            membres = e.getId();
		        } else {
		            membres +="," + e.getId();
		        }
		    }
		    ps.setString(4,membres);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleat(Laboratoire a) {
		// TODO Auto-generated method stub
		String nom =a.getNom();
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet ="DELETE FROM Laboratoire WHERE Nom=?";
			
			ps= conn.prepareStatement(requet);
			ps.setString(1, nom);
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
