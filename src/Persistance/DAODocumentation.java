package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.Documentation;

public class DAODocumentation implements DAOCRUD<Documentation, String> {
	Connection conn;

	@Override
	public void creer(Documentation a) {
		// TODO Auto-generated method stub
		String titre =a.getTitre();
		String contenue=a.getContenu();
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet = "INSERT INTO Documentation (Titre,Contenu) VALUES (?,?)";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1, titre);
			ps.setString(2, contenue);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Documentation read(String titre) {
		String contenu= null;
		
		
		ResultSet resultat = null;
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		try {
			String requet="SELECT * FROM Documentation WHERE Titre=?";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1,titre);
			resultat = ps.executeQuery();
		}catch(SQLException e) {
			System.out.println(e);
		}
		try{
			while(resultat.next()) {
				
				titre=resultat.getString("Titre");
				contenu=resultat.getString("Contenu");
			}	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Documentation doc = new Documentation(titre,contenu);
		return doc;
	}

	@Override
	public void update(Documentation a) {
		// TODO Auto-generated method stub
		String titre =a.getTitre();
		String contenue=a.getContenu();
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet = "UPDATE Documentation SET Titre=?,Contenu=? WHERE Titre=?";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1, titre);
			ps.setString(2, contenue);
			ps.setString(3, titre);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleat(Documentation a) {
		// TODO Auto-generated method stub
		String titre =a.getTitre();
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet = "DELETE FROM Documentation WHERE Titre=?";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1, titre);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
