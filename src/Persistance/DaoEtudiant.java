package Persistance;
import Metier.Etudiant;
import Metier.Filiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DaoEtudiant implements DAOCRUD<Etudiant,String> {
	Connection conn;
	public DaoEtudiant(){
		conn = Connexion.getConnexion();
	}
	/*public ArrayList<Etudiant> getAll() {
	ArrayList<Etudiant> list = new ArrayList<Etudiant>();
	ResultSet resultat = null;
	try {
		resultat = this.conn.createStatement().executeQuery("SELECT * FROM Etudiant");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    String nom="";
    String prenom="";
    String email="";
    Filiere flr=new Filiere(); 
    String niveau="";
    String filiere="";
    Integer passwd=null;
    String id=null;
	try {
		while(resultat.next())
		{
		    nom = resultat.getString("nom");
		    prenom = resultat.getString("prenom");
		    email = resultat.getString("email");
		    filiere= resultat.getString("filiere");
		    niveau = resultat.getString("niveau");
		    passwd = resultat.getInt("passwd");
		    id= resultat.getString("id");
		    flr.setNom(filiere);
		    list.add(new Etudiant(nom, prenom,email, flr,niveau,passwd,id));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
	}
	
	*/
	public Etudiant read (String id){
		Etudiant Etudiant;
		ResultSet resultat = null;
		try {
			resultat = this.conn.createStatement().executeQuery("SELECT * FROM Etudiant where "
					+ "passwd = " + "'id'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nom = null;
		String prenom = null;
	    String email=null;
	    Filiere flr=new Filiere();
	    DAOFiliere daofilier = new DAOFiliere();
	    String niveau=null;
	    String filiere_nom=null;
	    Integer passwd=null;
		boolean isEmpty=false;
		try {
			while(resultat.next())
			{
			    isEmpty=true;
			    nom = resultat.getString("Nom");
			    prenom = resultat.getString("Prenom");
			    email = resultat.getString("Email");
			    filiere_nom= resultat.getString("Filiere");
			    niveau = resultat.getString("Niveau");
			    passwd = resultat.getInt("Passwd");
			    id=resultat.getString("ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isEmpty){
			flr = daofilier.read(filiere_nom);
			Etudiant = new Etudiant(id,nom, prenom,email,passwd,flr,niveau);
			return Etudiant;
		}
		else return null;
		}
	
	public void creer(Etudiant a) {
			String nom = a.getNom();
			String prenom = a.getPrenom();
		    String email=a.getEmail();
		    Filiere flr=a.getFiliere();
		    String niveau=a.getNiveau();
		    String filiere=flr.getNom();
		    Integer password=a.getPassword();
		    String id=a.getId();
		    
		    Connection conn = Connexion.getConnexion();
			PreparedStatement ps = null;
			
			try {
				String query = "INSERT INTO Etudiant(Non,Prenom,Email,Filiere,Niveau,ID,Password) VALUES (?,?,?,?,?,?,?)";
				
				ps =conn.prepareStatement(query);
				 ps.setString(1,id);
				 ps.setString(2,nom);
				 ps.setString(3, prenom);
				 ps.setString(4, email);
				 ps.setString(5, niveau);
				 ps.setString(6, filiere);
				 ps.setInt(7, password);
				 
				 ps.executeUpdate();
	
				 
			}catch (Exception e) {
				System.out.println(e);
			}
			
	}
	
	public void update (Etudiant a) {
		String nom = a.getNom();
		String prenom = a.getPrenom();
	    String email=a.getEmail();
	    Filiere flr=a.getFiliere();
	    String niveau=a.getNiveau();
	    String filiere=flr.getNom();
	    Integer password=a.getPassword();
	    String id=a.getId();
	    
	    Connection conn = Connexion.getConnexion();
		PreparedStatement ps =null;
		
		try {
			String query="UPDATE Etudiant SET ID=?,Nom=?,Prenom=?,Email=?,Niveau=?,Filiere=?,Password=? WHERE ID=?";
			ps= conn.prepareStatement(query);
			
			ps.setString(1,id);
			ps.setString(2,nom);
			ps.setString(3,prenom);
			ps.setString(4,email);
			ps.setString(5,niveau);
			ps.setString(6,filiere);
			ps.setInt(7,password);
			ps.setString(8,id);
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void deleat(Etudiant a) {
	    String id=a.getId();
	    Connection conn = Connexion.getConnexion();
		PreparedStatement ps =null;
		try {
			String query = "DELETE FROM Etudiant WHERE ID=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}