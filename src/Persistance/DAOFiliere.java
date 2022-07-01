package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Metier.Departement;
import Metier.Filiere;
import Metier.Professeur;

public class DAOFiliere implements DAOCRUD<Filiere, String>{
	Connection conn;
	
	public DAOFiliere(){
		conn =Connexion.getConnexion();
	}
	public void creer(Filiere a) {
		// TODO Auto-generated method stub
		String nom=a.getNom();
		Departement departement = a.getDepartementAttache();
		Professeur coordonateur = a.getCoordonnateur();
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps =null;
		
		try {
			String requet = "INSERT INTO FILIER (Nom,Departement,Coordonnateur) VALUES (?,?,?)";
			
			ps= conn.prepareStatement(requet);
			ps.setString(1, nom);
			ps.setString(2, departement.getNom());
			ps.setString(3,coordonateur.getId());
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Filiere read(String nom) {
		// TODO Auto-generated method stub
		Departement depart=new Departement();
		Professeur prof = new Professeur();
		String departement_nom=null;
		String coordonateur_id= null;
		DAODepartement daodepartement = new DAODepartement();
		DaoProfesseur daoprof= new DaoProfesseur();
		
		ResultSet resultat1 = null;
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps =null;
		try {
			String query = "SELECT * FROM Filiere WHERE Nom=? ";
			
			ps=conn.prepareStatement(query);
			ps.setString(1, nom);
			resultat1=ps.executeQuery();
		}catch(SQLException e) {
			System.out.println(e);
		}
		try {
			while(resultat1.next())
			{
				nom=resultat1.getString("Nom");
				departement_nom=resultat1.getString("Departement");
				coordonateur_id=resultat1.getString("Cooredonnateur");
				
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		depart = daodepartement.read(departement_nom);
		prof= daoprof.read(coordonateur_id);
		Filiere f = new Filiere(nom,depart,prof);
		return f;
	}

	@Override
	public void update(Filiere a) {
		// TODO Auto-generated method stub
		String nom=a.getNom();
		Departement departement = a.getDepartementAttache();
		Professeur coordonateur = a.getCoordonnateur();
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps =null;
		
		try {
			String requet = "UPDATE  Filiere SET Nom=?,Departement=?,Coordonnateur=? WHERE Nom=?";
			
			ps= conn.prepareStatement(requet);
			ps.setString(1, nom);
			ps.setString(2, departement.getNom());
			ps.setString(3,coordonateur.getId());
			ps.setString(4, nom);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
		

	@Override
	public void deleat(Filiere a) {
		String nom=a.getNom();
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps =null;
		try {
			String query = "DELETE FROM Filiere WHERE Nom=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, nom);
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<Filiere> getall(String dep_nom){
		Departement depart=new Departement();
		Professeur prof = new Professeur();
		String departement_nom=null;
		String nom=null;
		String coordonateur_id= null;
		DAODepartement daodepartement = new DAODepartement();
		DaoProfesseur daoprof= new DaoProfesseur();
		ArrayList<Filiere> list = new ArrayList<>();
		
		ResultSet resultat1 = null;
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps =null;
		try {
			String query = "SELECT * FROM Filiere WHERE Departement=? ";
			
			ps=conn.prepareStatement(query);
			ps.setString(1, dep_nom);
			resultat1=ps.executeQuery();
		}catch(SQLException e) {
			System.out.println(e);
		}
		try {
			while(resultat1.next())
			{
				nom=resultat1.getString("Nom");
				departement_nom=resultat1.getString("Departement");
				coordonateur_id=resultat1.getString("Cooredonnateur");
				depart = daodepartement.read(departement_nom);
				prof= daoprof.read(coordonateur_id);
				Filiere f = new Filiere(nom,depart,prof);
				list.add(f);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
