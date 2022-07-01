package Persistance;       //done 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.Documentation;
import Metier.Etape;

public class DAOEtape implements DAOCRUD<Etape,String> {
	Connection conn;
	public DAOEtape(){
		conn=Connexion.getConnexion();
	}
	public void creer(Etape a) {
		String durre=a.getDuree();
		String premierEtape=a.getPremierEtape();
		String documentation_nom=a.getDocumentation().getTitre();
		String livraison_nom=a.getLivraison().getTitre();
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps =null;
		
		try {
			String query ="INSERT INTO Etape(Durre,PremierEtape,Documentation,Livraison) VALUES (?,?,?,?)";
			
			ps =conn.prepareStatement(query);
			ps.setString(1, durre);
			ps.setString(2, premierEtape);
			ps.setString(3, documentation_nom);
			ps.setString(4, livraison_nom);
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
		
	public void update(Etape a) {
		
		String durre=a.getDuree();
		String premierEtape=a.getPremierEtape();
		String documentation=a.getDocumentation().getTitre();
		String livraison=a.getLivraison().getTitre();
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps =null;
		
		try {
			String query = "UPDATE Etape SET Durre=?,PremierEtape=?,Documentation=?,Livraison=? WHERE  PremierEtape=?";
			ps= conn.prepareStatement(query);
			
			ps.setString(1, durre);
			ps.setString(2, premierEtape);
			ps.setString(3,documentation);
			ps.setString(4,livraison);
			ps.setString(5, premierEtape);
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void deleat(Etape a) {
		String premierEtape =a.getPremierEtape();
		Connection conn =Connexion.getConnexion();
		PreparedStatement ps = null;
		
		
		try {
			String query ="DELETE FROM Etape WHERE PremierEtape=?";
			ps=conn.prepareStatement(query);
			ps.setString(1, premierEtape);
			ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public Etape read(String premierEtape) {
		Etape a;
		String durre = null;
		String documentation_titre=null;
		String livraison_titre= null;
		Documentation documentation = new Documentation();
		Documentation livraison=new Documentation();
		DAODocumentation daoDocumentation=new DAODocumentation();
		DAODocumentation daolivraison =new DAODocumentation(); 
		ResultSet resultat = null;
		boolean isEmpty=false;
		
		Connection conn = Connexion.getConnexion();
		PreparedStatement ps = null;
		
		try {
			String query ="SELECT * FROM Etape Where PremierEtape=?";
			ps=conn.prepareStatement(query);
			
			ps.setString(1, premierEtape);
			resultat=ps.executeQuery();
		}catch(SQLException e) {
			System.out.println(e);
		}
		try {
			while(resultat.next()) {
				isEmpty=true;
				durre=resultat.getString("Duree");
				documentation_titre= resultat.getString("Documentation");
				livraison_titre= resultat.getString("Livraison");
			}
			}catch (SQLException e) {
				e.printStackTrace();
		}
		if(isEmpty) {
			documentation=daoDocumentation.read(documentation_titre);
			livraison=daolivraison.read(livraison_titre);
			a=new Etape(durre,premierEtape,documentation,livraison);
			return a;
		}
		else return null;
	}
	
}
		 
		
		
	

