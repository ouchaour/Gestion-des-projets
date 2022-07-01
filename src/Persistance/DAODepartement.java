package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Metier.Departement;
import Metier.Professeur;

public class DAODepartement implements DAOCRUD<Departement,String> {   //Nom;Email;Chef;membres
	Connection conn;
	public DAODepartement(){
		conn = Connexion.getConnexion();
	}
	
	
	public void creer(Departement a) {
		String nom = a.getNom();
		String email = a.getEmail();
		String chef = a.getChefDepartement().getNom();
		ArrayList <Professeur> list = new ArrayList<>(a.getMember());
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet = "INSERT INTO Departement(Nom,Email,Chef,Membres) VALUES (?,?,?,?)";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1, nom);
			ps.setString(2, email);
			ps.setString(3, chef);
			String membres = "";
		    for(Professeur e : list) { 
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
	
	public void update(Departement a) {
		String nom = a.getNom();
		String email = a.getEmail();
		String chef_id = a.getChefDepartement().getId();
		ArrayList <Professeur> list = a.getMember();
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet = "UPDATE Departement SET Nom=?,Email=?,Chef=?,Membres=? WHERE Nom=?";
		
			ps=conn.prepareStatement(requet);
			ps.setString(1, nom);
			ps.setString(2, email);
			ps.setString(3, chef_id);
			
			String membres = "";
		    for(Professeur e : list) { 
		        if(membres.equals("")) {
		            membres = e.getId();
		        } else {
		            membres += "," + e.getId();
		        }
		    }
		    ps.setString(4,membres);
		    ps.setString(5, nom);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deleat(Departement a) {
		String nom =a.getNom();
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet ="DELETE FROM Departement WHERE Nom=?";
			
			ps= conn.prepareStatement(requet);
			ps.setString(1, nom);
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}


	public Departement read(String nom) {
		String email = null;
		String chef_id=null;
		Professeur chef = new Professeur();
		DaoProfesseur daochef=new  DaoProfesseur();
		String all_membre_id[]=null;
		ArrayList <Professeur> members=new ArrayList<>();
		Professeur one_membre = new Professeur();
		DaoProfesseur daomembre=new  DaoProfesseur();
		
		
		
		ResultSet resultat = null;
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		try {
			String requet="SELECT * FROM Departement WHERE Nom=?";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1,	nom);
			resultat = ps.executeQuery();
		}catch(SQLException e) {
			System.out.println(e);
		}
		try{
			while(resultat.next()) {
				email=resultat.getString("Email");
				chef_id=resultat.getString("Chef");
				all_membre_id=resultat.getString("Members").split(",");
			}	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//on chereche le membre(prof) avec l'id utilisent daoprof puis on l'ajoute dans arraylist
		for(String i : all_membre_id) {
			one_membre= daomembre.read(i);
			members.add(one_membre);
			
		}
		
		chef =daochef.read(chef_id);// chereche les infos du chef depuis Daoprof 
		Departement e= new Departement(nom,email,chef,members);
		return e;
	}
	
	public void ajout_Membre(String dep_nom,Professeur a) {
		Departement departement=this.read(dep_nom);
		departement.ajouter_Membre(a);
		this.update(departement);
	}
	
	public void delet_membre(String dep_nom,Professeur a) {
		Departement departement =this.read(dep_nom);
		departement.delete_membre(a);
		this.update(departement);
	}
}