package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.Entreprise;
import Metier.Responsable;

public class DAOEntreprise implements DAOCRUD<Entreprise, String>{

	@Override
	public void creer(Entreprise a) {
		// TODO Auto-generated method stub
		String nom = a.getNom();
		String email = a.getEmail();
		String adresse = a.getAdresse();
		Integer tele = a.getTelephone();
		String resp_nom = a.getResposable().getNom();
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet = "INSERT INTO Entreprise (Nom,Email,Adresse,telephone,Responsable) VALUES (?,?,?,?)";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1, nom);
			ps.setString(2, email);
			ps.setString(3, adresse);
			ps.setInt(4, tele);
			ps.setString(5, resp_nom);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Entreprise read(String nom) {
		String email= null;
		Integer tele = null;
		String adresse = null;
		String responsable_id= null;
		DAOResponsable daoresponsable=new DAOResponsable();
		Responsable responsable= new Responsable();
		ResultSet resultat = null;
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet="SELECT * FROM Entreprise WHERE Titre=?";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1,nom);
			resultat = ps.executeQuery();
		}catch(SQLException e) {
			System.out.println(e);
		}
		try{
			while(resultat.next()) {
				email=resultat.getString("Email");
				adresse=resultat.getString("Adresse");
				tele = resultat.getInt("Telephone");
				responsable_id=resultat.getString("Responsable");
			}	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		responsable = daoresponsable.read(responsable_id);
		Entreprise e = new Entreprise(nom, adresse, email, tele, responsable);
		return e;
	}

	@Override
	public void update(Entreprise a) {
		// TODO Auto-generated method stub
		String nom = a.getNom();
		String email = a.getEmail();
		String adresse = a.getAdresse();
		Integer tele = a.getTelephone();
		String resp_nom = a.getResposable().getNom();
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet = "UPDATE Entreprise SET Nom=?,Email=?,Adresse=?,telephone=?,Responsable=? WHERE Nom=?";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1, nom);
			ps.setString(2, email);
			ps.setString(3, adresse);
			ps.setInt(4, tele);
			ps.setString(5, resp_nom);
			ps.setString(6, nom);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleat(Entreprise a) {
		
		// TODO Auto-generated method stub
		String nom = a.getNom();
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String requet = "DELETE FROM Entreprise WHERE Nom=?";
			
			ps=conn.prepareStatement(requet);
			ps.setString(1, nom);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
