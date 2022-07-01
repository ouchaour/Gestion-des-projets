package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Metier.Departement;
import Metier.Professeur; 


public class DaoProfesseur implements DAOCRUD<Professeur,String> //ID,Nom,Prenom,Email,Grade,Departement,Password
{
	Connection conn;
	public DaoProfesseur(){
		conn = Connexion.getConnexion();
	}
	
		public void update(Professeur a) {
			String nom = a.getNom();
			String prenom = a.getPrenom();
			String email=a.getEmail();
			Departement depart=a.getDepartement();
			String grade=String.valueOf(a.getGrade());
			String departement=depart.getNom();
			Integer password=a.getPassword();
			String id=a.getId();
			
			Connection conn = Connexion.getConnexion();
			PreparedStatement ps =null;
			
			try {
				String query="UPDATE Professeur SET ID=?,Nom=?,Prenom=?,Email=?,Grade=?,Departement=?,Password=? WHERE ID=?";
				ps= conn.prepareStatement(query);
				
				ps.setString(1,id);
				ps.setString(2,nom);
				ps.setString(3,prenom);
				ps.setString(4,email);
				ps.setString(5,grade);
				ps.setString(6,departement);
				ps.setInt(7,password);
				ps.setString(8,id);
				ps.executeUpdate();
			}catch(Exception e) {
				System.out.println(e);
			}
	}
		public void deleat(Professeur a) {
			String id=a.getId();
			Connection conn = Connexion.getConnexion();
			PreparedStatement ps =null;
			
			try {
				String query = "DELETE FROM Professeur WHERE ID=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, id);
				ps.executeUpdate();
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
		 
		public void creer(Professeur a) {
			String nom = a.getNom();
			String prenom = a.getPrenom();
			String email=a.getEmail();
			Departement depart=a.getDepartement();
			String grade=String.valueOf(a.getGrade());
			String departement=depart.getNom();
			Integer password=a.getPassword();
			String id=a.getId();
			
			Connection conn = Connexion.getConnexion();
			PreparedStatement ps =null;
			
			try {
				String query = "INSERT INTO Professeur(ID,Non,Prenom,Email,Grade,Departement,Password) VALUES (?,?,?,?,?,?,?)";
				
				ps= conn.prepareStatement(query);
				ps.setString(1,id);
				ps.setString(2,nom);
				ps.setString(3,prenom);
				ps.setString(4,email);
				ps.setString(5,grade);
				ps.setString(6,departement);
				ps.setInt(7,password);
				ps.executeUpdate();
			}catch (Exception e) {
				System.out.println(e);
			}
			DAODepartement d = new DAODepartement();
			d.ajout_Membre(departement, a);
			
		}
		
		public Professeur read(String id) {
			Professeur a = new Professeur();
			String nom =null;
			String prenom = null;
			String email=null; 
			String grade=null;
			String departement_nom=null;
			Integer password=null;  
			Departement depart=new Departement();
			DAODepartement daodepartement = new DAODepartement();
			
			ResultSet resultat1 = null;
			Connection conn = Connexion.getConnexion();
			PreparedStatement ps =null;
			try {
				String query = "SELECT * FROM Profeseur WHERE ID=? ";
				
				ps=conn.prepareStatement(query);
				
				ps.setString(1, id);
				resultat1=ps.executeQuery();
			}catch(SQLException e) {
				System.out.println(e);
			}
			try {
				while(resultat1.next())
				{
					nom=resultat1.getString("Nom");
					prenom=resultat1.getString("Prenom");
					email=resultat1.getString("Email");
					grade=resultat1.getString("Grade");
					password=resultat1.getInt("Password");
					departement_nom=resultat1.getString("Departement");
					
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				depart = daodepartement.read(departement_nom);
				a.setId(id);
				a.setDepartement(depart);
				a.setNom(nom);
				a.setPrenom(prenom);
				a.setEmail(email);
				a.setGrade(grade);
				a.setPassword(password);
				return a;
			}		
}


	
