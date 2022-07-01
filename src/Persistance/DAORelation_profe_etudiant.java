package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.Professeur;
import Metier.Projet;

public class DAORelation_profe_etudiant {
Connection conn;
	
	public DAORelation_profe_etudiant(){
		conn =Connexion.getConnexion();
	}
	public void creer(String prof_id, String etudiant_id , String projet_id) {
		// TODO Auto-generated method stub
		
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps =null;
		
		try {
			String requet = "INSERT INTO Relation (Professeur,Etudiant,Projet) VALUES (?,?,?)";
			
			ps= conn.prepareStatement(requet);
			ps.setString(1, prof_id);
			ps.setString(2, etudiant_id);
			ps.setString(3,projet_id);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete(String etudiant_id) {
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet = "DELETE FROM Relation WHERE Etudiant =?";
			
			ps = conn.prepareStatement(requet);
			ps.setString(1, etudiant_id);
			ps.executeUpdate();
		}catch (Exception e) {
		System.out.println(e);
		}
	}
	
	public Projet getprojet(String etudiant_id) {
		String projet_titre=null;
		Projet projet= new Projet();
		DAOProjet daoProjet=new DAOProjet();
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		ResultSet resultat = null;
		try {
			String query = "SELECT * FROM Relation WHERE Etudiant=? ";
			
			ps=conn.prepareStatement(query);
			ps.setString(1,etudiant_id);
			resultat=ps.executeQuery();
		}catch(SQLException e) {
			System.out.println(e);
		}
		try {
			while(resultat.next())
			{
				projet_titre=resultat.getString("Projet");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		projet=daoProjet.read(projet_titre);
		return projet;
	}
	
	public Professeur getprofesseur(String etudiant_id) {
		String professeur_id=null;
		Professeur prof= new Professeur();
		DaoProfesseur daoprof= new DaoProfesseur();
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		ResultSet resultat = null;
		try {
			String query = "SELECT * FROM Relation WHERE Etudiant=? ";
			
			ps=conn.prepareStatement(query);
			ps.setString(1,etudiant_id);
			resultat=ps.executeQuery();
		}catch(SQLException e) {
			System.out.println(e);
		}
		try {
			while(resultat.next())
			{
				professeur_id=resultat.getString("Professeur");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prof=daoprof.read(professeur_id);
		return prof;
	}
	public boolean isexist_prof(String prof_id) {
		String projet= null;
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		ResultSet resultat = null;
		try {
			String query = "SELECT * FROM Relation WHERE Professeur=? ";
			
			ps=conn.prepareStatement(query);
			ps.setString(1,prof_id);
			resultat=ps.executeQuery();
		}catch(SQLException e) {
			System.out.println(e);
		}
		try {
			while(resultat.next())
			{
				projet=resultat.getString("Projet");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(projet == null)return false;
		else return true ;
	}
	
	public boolean isexist_projet(String projet_id) {
		String prof= null;
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		ResultSet resultat = null;
		try {
			String query = "SELECT * FROM Relation WHERE Projet=? ";
			
			ps=conn.prepareStatement(query);
			ps.setString(1,projet_id);
			resultat=ps.executeQuery();
		}catch(SQLException e) {
			System.out.println(e);
		}
		try {
			while(resultat.next())
			{
				prof=resultat.getString("Professeur");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(prof == null)return false;
		else return true ;
	}
	
}
