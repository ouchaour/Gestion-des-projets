package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.Responsable;

public class DAOResponsable implements DAOCRUD<Responsable,String> {

	@Override
	public void creer(Responsable a) {
		// TODO Auto-generated method stub
		String id =a.getID();
		String nom=a.getNom();
		String adresse =a.getAdresse();
		Integer tele =a.getTelephone();
		
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet = "INSERT INTO Responsable (ID,Nom,Adresse,Telephone) VALUES (?,?,?,?)";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1,id);
			ps.setString(2, nom);
			ps.setString(3, adresse);
			ps.setInt(4, tele);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Responsable read(String id) {
		// TODO Auto-generated method stub
		String nom=null;
		String adresse =null;
		Integer tele=null;
		ResultSet resultat = null;
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		try {
			String requet="SELECT * FROM Responsable WHERE ID=?";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1,id);
			resultat = ps.executeQuery();
		}catch(SQLException e) {
			System.out.println(e);
		}try{
			while(resultat.next()) {
				nom=resultat.getString("Nom");
				adresse=resultat.getString("Adresse");
				tele=resultat.getInt("Telephone");
				
			}	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		Responsable e = new Responsable(id, nom, tele, adresse);
		return e;
	}

	@Override
	public void update(Responsable a) {
		// TODO Auto-generated method stub
		String id =a.getID();
		String nom=a.getNom();
		String adresse =a.getAdresse();
		Integer tele =a.getTelephone();
		
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet = "UPDATE Responsable SET ID=?,Nom=?,Adresse=?,Telephone=? WHERE ID=?";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1,id);
			ps.setString(2, nom);
			ps.setString(3, adresse);
			ps.setInt(4, tele);
			ps.setString(5,id);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleat(Responsable a) {
		
		String id =a.getID();
				
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet = "DELETE FROM Responsable SET WHERE ID=?";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1,id);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
