import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.directory.SearchControls;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Metier.Departement;
import Metier.Professeur;
import metier_gestion.GestionDepartement;
import metier_gestion.GestionProfesseur;

public class page2 implements ActionListener {

	private JPanel contentP;
	JFrame frame2 = new JFrame();
	GestionProfesseur gestionProfesseur=new GestionProfesseur();
	GestionDepartement gestionDepartement = new GestionDepartement();
	Departement depart = new Departement();
	Professeur professeur = new Professeur();
	
	JButton botona_1 = new JButton("Ajouter");
	JButton botona_2 = new JButton("Modifier");
	JButton botona_3 = new JButton("Supprimer");
	JButton botona_4 = new JButton("Archivage et Edition");
	JButton botonas = new JButton("search");
	JButton botonad = new JButton("search");
	JButton botonav = new JButton("Valider");
	pane_dsupp supp = new pane_dsupp();
	pane_dajout entrer = new pane_dajout();
	pane_dmodif modif = new pane_dmodif();
	pane_dsearch search = new pane_dsearch();
	pane_dsearch_delet searchd = new pane_dsearch_delet();
	String smia;
	
	public page2() {
		frame2.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 12));
		frame2.setTitle("Page 2");
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentP = new JPanel();
		contentP.setBackground(Color.WHITE);
		contentP.setBounds(0, 0, 1080,720);
		
		
		botona_1.setForeground(Color.BLACK);
		botona_1.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		botona_1.setBorder(null);
		botona_1.setBackground(new Color(255, 239, 213));
		botona_1.setBounds(0, 123, 335, 95);
		botona_1.setFocusable(false);
		botona_1.addActionListener(this);
		contentP.add(botona_1);
		
		botona_2.setForeground(Color.BLACK);
		botona_2.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		botona_2.setBorder(null);
		botona_2.setBackground(new Color(255, 239, 213));
		botona_2.setBounds(0, 223, 335, 95);
		botona_2.setFocusable(false);
		botona_2.addActionListener(this);
		contentP.add(botona_2);
		
		botona_3.setForeground(Color.BLACK);
		botona_3.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		botona_3.setBorder(null);
		botona_3.setBackground(new Color(255, 239, 213));
		botona_3.setBounds(0, 323, 335, 95);
		botona_3.setFocusable(false);
		contentP.add(botona_3);
		
		botona_4.setForeground(Color.BLACK);
		botona_4.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		botona_4.setBorder(null);
		botona_4.setBackground(new Color(255, 239, 213));
		botona_4.setBounds(0, 423, 335, 95);
		botona_4.setFocusable(false);
		contentP.add(botona_4);
		
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Agency FB", Font.PLAIN, 15));
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\youssef\\Desktop\\66.jpg"));
		lblNewLabel_4.setBounds(0, 0, 1080, 720);
		contentP.add(lblNewLabel_4);

		frame2.setLayout(null);
		frame2.setSize(1080, 720);
		frame2.setVisible(true);
		frame2.add(contentP);
		
		botona_3.addActionListener(e -> botona_3.setBackground(Color.black));
		botona_3.addActionListener(e -> botona_3.setForeground(Color.white));
		
		botona_4.addActionListener(e -> botona_4.setBackground(Color.black));
		botona_4.addActionListener(e -> botona_4.setForeground(Color.white));
		contentP.setLayout(null);
	}
	//---------------------------- pane 1---------------------------------------
	public class pane_dajout{
		JPanel contentPane2 = new JPanel();
		pane_dajout(){
			contentPane2.setBounds(380, 112, 640, 485);
			contentPane2.setLayout(null);
			contentPane2.setVisible(false);
			frame2.add(contentPane2);
			
			JLabel lbl1 = new JLabel("Nom d'utilisateur");
			lbl1.setForeground(Color.WHITE);
			lbl1.setFont(new Font("Arial Black", Font.PLAIN, 14));
			lbl1.setBounds(80, 60, 140, 18);
			contentPane2.add(lbl1);
			
			JTextField nom = new JTextField();
			nom.setFont(new Font("Arial Black", Font.PLAIN, 13));
			nom.setBounds(80, 90, 160, 26);
			contentPane2.add(nom);
			//---------------------------------
			JLabel lbl2 = new JLabel("Prénom d'utilisateur");
			lbl2.setForeground(Color.WHITE);
			lbl2.setFont(new Font("Arial Black", Font.PLAIN, 14));
			lbl2.setBounds(400, 60, 160, 18);
			contentPane2.add(lbl2);
			
			JTextField prenom = new JTextField();
			prenom.setFont(new Font("Arial Black", Font.PLAIN, 13));
			prenom.setBounds(400, 90, 160, 26);
			contentPane2.add(prenom);
			//------------------------------------
			
			JLabel lbl3 = new JLabel("Password");
			lbl3.setForeground(Color.WHITE);
			lbl3.setFont(new Font("Arial Black", Font.PLAIN, 14));
			lbl3.setBounds(80, 160, 140, 18);
			contentPane2.add(lbl3);
			
			JTextField pass = new JTextField();
			pass.setFont(new Font("Arial Black", Font.PLAIN, 13));
			pass.setBounds(80, 190, 160, 26);
			contentPane2.add(pass);
			//-------------------------------------
			
			JLabel lbl4 = new JLabel("Grade");
			lbl4.setForeground(Color.WHITE);
			lbl4.setFont(new Font("Arial Black", Font.PLAIN, 14));
			lbl4.setBounds(400, 160, 140, 18);
			contentPane2.add(lbl4);
			
			JTextField grade = new JTextField();
			grade.setFont(new Font("Arial Black", Font.PLAIN, 13));
			grade.setBounds(400, 190, 160, 26);
			contentPane2.add(grade);
			//------------------------------------
			
			JLabel lbl5 = new JLabel("Email");
			lbl5.setForeground(Color.WHITE);
			lbl5.setFont(new Font("Arial Black", Font.PLAIN, 14));
			lbl5.setBounds(80, 260, 140, 18);
			contentPane2.add(lbl5);
			
			JTextField email = new JTextField();
			email.setFont(new Font("Arial Black", Font.PLAIN, 13));
			email.setBounds(80, 290, 160, 26);
			contentPane2.add(email);
			//-------------------------------------------
			JLabel lbl6 = new JLabel("Département");
			lbl6.setForeground(Color.WHITE);
			lbl6.setFont(new Font("Arial Black", Font.PLAIN, 14));
			lbl6.setBounds(400, 260, 140, 18);
			contentPane2.add(lbl6);
			
			JTextField departement = new JTextField();
			departement.setFont(new Font("Arial Black", Font.PLAIN, 13));
			departement.setBounds(400, 300, 160, 26);
			contentPane2.add(departement);
			//-------------------------------------------
			JLabel lbl7 = new JLabel("ID");
			lbl7.setForeground(Color.WHITE);
			lbl7.setFont(new Font("Arial Black", Font.PLAIN, 14));
			lbl7.setBounds(240, 340, 140, 18);
			contentPane2.add(lbl7);
			
			JTextField id = new JTextField();
			id.setFont(new Font("Arial Black", Font.PLAIN, 13));
			id.setBounds(240, 370, 160, 26);
			contentPane2.add(id);
			//------------------------------------------------
			
			botonav.setForeground(Color.white);
			botonav.setBackground(new Color(0x012030));
			botonav.setBounds(270, 440, 90, 35);
			botonav.setBorder(new RoundBtn(15));
			botonav.setFocusable(false);
			contentPane2.add(botonav);
		    botonav.addActionListener(new ActionListener() {
			      //capture the event on JTextField
			      public void actionPerformed(ActionEvent e) {
			    	  //on recupaire les donnees et on les ajoute au professeur, et on appelle 
			    	  //gestionprofesseur.
			    	  professeur.setNom(nom.getText());
			    	  professeur.setPrenom(prenom.getText());
			    	  professeur.setEmail(email.getText());
			    	  professeur.setPassword(Integer.valueOf(pass.getText()));
			    	  professeur.setGrade(grade.getText());
			    	  professeur.setId(id.getText());
			    	  depart=gestionDepartement.read(departement.getText());
			    	  professeur.setDepartement(depart);
			    	  gestionProfesseur.add(professeur);
			      }
			    });
			
			JLabel lblNewLabel_4 = new JLabel("New label");
			lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\youssef\\Desktop\\99.jpg"));
			lblNewLabel_4.setBounds(0, 0, 640, 485);
			contentPane2.add(lblNewLabel_4);
		}
	}
	//----------------------------------pane 2.0---------------------------------
	public class pane_dsearch{
		JPanel contentPane31 = new JPanel();
		JTextField tsearch = new JTextField();
		pane_dsearch(){
			contentPane31.setBounds(480, 85, 400, 35);
			contentPane31.setLayout(null);
			contentPane31.setVisible(false);
			frame2.add(contentPane31);
			//-------------------------------------------
			tsearch.setFont(new Font("Arial Black", Font.PLAIN, 13));
			tsearch.setBounds(10, 3, 280, 30);
			contentPane31.add(tsearch);
			smia=tsearch.getText();
			
			botonas.setBackground(new Color(0x012030));
			botonas.setForeground(Color.WHITE);
			botonas.setBounds(320, 3, 75, 30);
			botonas.setFocusable(false);
			contentPane31.add(botonas);
		    botonas.addActionListener(new ActionListener() {
			      //capture the event on JTextField
			      public void actionPerformed(ActionEvent e) {
			    	if(gestionProfesseur.existe(tsearch.getText()))
						modif.contentPane3.setVisible(true);
					else {
						System.out.println("No such user exist: " + tsearch.getText());
					}
			      }
			    });
		}

	}

	//----------------------------------pane 2.1---------------------------------
	public class pane_dmodif{
		JPanel contentPane3 = new JPanel();
		pane_dmodif(){
			contentPane3.setBounds(380, 135, 640, 485);
			contentPane3.setLayout(null);
			contentPane3.setVisible(false);
			frame2.add(contentPane3);
			
			JLabel lbl1 = new JLabel("Nom d'utilisateur");
			lbl1.setForeground(Color.WHITE);
			lbl1.setFont(new Font("Arial Black", Font.PLAIN, 14));
			lbl1.setBounds(80, 80, 140, 18);
			contentPane3.add(lbl1);
			
			JTextField nom = new JTextField();
			nom.setFont(new Font("Arial Black", Font.PLAIN, 13));
			nom.setBounds(80, 110, 160, 26);
			contentPane3.add(nom);
			//---------------------------------
			JLabel lbl2 = new JLabel("Prénom d'utilisateur");
			lbl2.setForeground(Color.WHITE);
			lbl2.setFont(new Font("Arial Black", Font.PLAIN, 14));
			lbl2.setBounds(400, 80, 160, 18);
			contentPane3.add(lbl2);
			
			JTextField prenom = new JTextField();
			prenom.setFont(new Font("Arial Black", Font.PLAIN, 13));
			prenom.setBounds(400, 110, 160, 26);
			contentPane3.add(prenom);
			//------------------------------------
			
			JLabel lbl3 = new JLabel("Password");
			lbl3.setForeground(Color.WHITE);
			lbl3.setFont(new Font("Arial Black", Font.PLAIN, 14));
			lbl3.setBounds(80, 180, 140, 18);
			contentPane3.add(lbl3);
			
			JTextField pass = new JTextField();
			pass.setFont(new Font("Arial Black", Font.PLAIN, 13));
			pass.setBounds(80, 210, 160, 26);
			contentPane3.add(pass);
			//-------------------------------------
			
			JLabel lbl4 = new JLabel("Grade");
			lbl4.setForeground(Color.WHITE);
			lbl4.setFont(new Font("Arial Black", Font.PLAIN, 14));
			lbl4.setBounds(400, 180, 140, 18);
			contentPane3.add(lbl4);
			
			JTextField grade = new JTextField();
			grade.setFont(new Font("Arial Black", Font.PLAIN, 13));
			grade.setBounds(400, 210, 160, 26);
			contentPane3.add(grade);
			//------------------------------------
			
			JLabel lbl5 = new JLabel("Email");
			lbl5.setForeground(Color.WHITE);
			lbl5.setFont(new Font("Arial Black", Font.PLAIN, 14));
			lbl5.setBounds(80, 280, 140, 18);
			contentPane3.add(lbl5);
			
			JTextField email = new JTextField();
			email.setFont(new Font("Arial Black", Font.PLAIN, 13));
			email.setBounds(80, 310, 160, 26);
			contentPane3.add(email);
			//-------------------------------------------
			JLabel lbl6 = new JLabel("Département");
			lbl6.setForeground(Color.WHITE);
			lbl6.setFont(new Font("Arial Black", Font.PLAIN, 14));
			lbl6.setBounds(400, 280, 140, 18);
			contentPane3.add(lbl6);
			
			JTextField departement = new JTextField();
			departement.setFont(new Font("Arial Black", Font.PLAIN, 13));
			departement.setBounds(400, 320, 160, 26);
			contentPane3.add(departement);
			//--------------------------------------------
			JLabel lbl7 = new JLabel("ID");
			lbl7.setForeground(Color.WHITE);
			lbl7.setFont(new Font("Arial Black", Font.PLAIN, 14));
			lbl7.setBounds(240, 340, 140, 18);
			contentPane3.add(lbl7);
			
			JTextField id = new JTextField();
			id.setFont(new Font("Arial Black", Font.PLAIN, 13));
			id.setBounds(240, 370, 160, 26);
			contentPane3.add(id);
			
			JButton botonav = new JButton("Modifier");
			botonav.setForeground(Color.white);
			botonav.setBackground(new Color(0x012030));
			botonav.setBounds(270, 440, 90, 35);
			botonav.setBorder(new RoundBtn(15));
			botonav.setFocusable(false);
			contentPane3.add(botonav);
		    botonav.addActionListener(new ActionListener() {
			      //capture the event on JTextField
			      public void actionPerformed(ActionEvent eve) {
			    	  //on recupaire les donnees et on les ajoute au professeur, et on appelle 
			    	  //gestionprofesseur.
			    	  professeur.setNom(nom.getText());
			    	  professeur.setPrenom(prenom.getText());
			    	  professeur.setEmail(email.getText());
			    	  professeur.setPassword(Integer.valueOf(pass.getText()));
			    	  professeur.setGrade(grade.getText());
			    	  professeur.setId(id.getText());
			    	  depart=gestionDepartement.read(departement.getText());
			    	  professeur.setDepartement(depart);
			    	  gestionProfesseur.add(professeur);
			      }
			    });
			
			JLabel lblNewLabel_4 = new JLabel("New label");
			lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\youssef\\Desktop\\99.jpg"));
			lblNewLabel_4.setBounds(0, 0, 640, 485);
			contentPane3.add(lblNewLabel_4);
		}
	}
	//----------------------------------pane 3.0---------------------------------
	public class pane_dsearch_delet{
		JPanel contentPane33 = new JPanel();
		JTextField dsearch = new JTextField();
		pane_dsearch_delet(){
			contentPane33.setBounds(480, 85, 400, 35);
			contentPane33.setLayout(null);
			contentPane33.setVisible(false);
			frame2.add(contentPane33);
			//-------------------------------------------
			dsearch.setFont(new Font("Arial Black", Font.PLAIN, 13));
			dsearch.setBounds(10, 3, 280, 30);
			contentPane33.add(dsearch);
			//smia=dsearch.getText();
			
			botonad.setBackground(new Color(0x012030));
			botonad.setForeground(Color.WHITE);
			botonad.setBounds(320, 3, 75, 30);
			botonad.setFocusable(false);
			contentPane33.add(botonad);
		    botonad.addActionListener(new ActionListener() {
			      //capture the event on JTextField
			      public void actionPerformed(ActionEvent event) {
			    	if(gestionProfesseur.existe(dsearch.getText()))
						supp.contentPane32.setVisible(true);
					else {
						System.out.println("No such user exist: " + dsearch.getText());
					}
			      }
			    });
		}

	}
	//-------------------------------------pane 3.1-----------------------------------
	public class pane_dsupp{
		JPanel contentPane32 = new JPanel();
		pane_dsupp(){
				contentPane32.setBounds(380, 135, 640, 485);
				contentPane32.setLayout(null);
				contentPane32.setVisible(false);
				frame2.add(contentPane32);
				
				JLabel lbl1 = new JLabel("Nom d'utilisateur");
				lbl1.setForeground(Color.WHITE);
				lbl1.setFont(new Font("Arial Black", Font.PLAIN, 14));

				contentPane32.add(lbl1);
				
				JButton botona_delet = new JButton("Delete");
				botona_delet.setForeground(Color.white);
				botona_delet.setBackground(new Color(0x012030));
				botona_delet.setBounds(80, 80, 140, 18);
				botona_delet.setBorder(new RoundBtn(15));
				botona_delet.setFocusable(false);
				contentPane32.add(botona_delet);
//			    botona_delet.addActionListener(new ActionListener() {
//				      //capture the event on JTextField
//				      public void actionPerformed(ActionEvent e) {
//				    	  //on recupaire les donnees et on les ajoute au professeur, et on appelle 
//				    	  //gestionprofesseur.
//				    	  professeur.setNom(nom.getText());
//				    	  professeur.setPrenom(prenom.getText());
//				    	  professeur.setEmail(email.getText());
//				    	  professeur.setPassword(Integer.valueOf(pass.getText()));
//				    	  professeur.setGrade(grade.getText());
//				    	  professeur.setId(id.getText());
//				    	  depart=gestionDepartement.read(departement.getText());
//				    	  professeur.setDepartement(depart);
//				    	  gestionProfesseur.add(professeur);
//				      }
//				    });
				
				JLabel lblNewLabel_4 = new JLabel("New label");
				lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\youssef\\Desktop\\99.jpg"));
				lblNewLabel_4.setBounds(0, 0, 640, 485);
				contentPane32.add(lblNewLabel_4);
			}
		}
	
	//--------------------------------pane 3----------------------------------------
	
	void reinitialiser(JButton j) {
		j.setForeground(Color.BLACK);
		j.setBackground(new Color(255, 239, 213));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	 
	 if(e.getSource()==botona_1) {
		entrer.contentPane2.setVisible(true);
		botona_1.setBackground(Color.black);
		botona_1.setForeground(Color.white);
		search.contentPane31.setVisible(false);
		modif.contentPane3.setVisible(false);
		reinitialiser(botona_2);
	 }
	 else if(e.getSource()==botona_3) {
		 
			search.contentPane31.setVisible(true);
			 botona_2.setBackground(Color.black);
			botona_2.setForeground(Color.white);
			entrer.contentPane2.setVisible(false);
		
		reinitialiser(botona_2);
	 }
	 else if(e.getSource()==botona_2) {

		
		search.contentPane31.setVisible(true);
		 botona_2.setBackground(Color.black);
		botona_2.setForeground(Color.white);
		entrer.contentPane2.setVisible(false);
		
		reinitialiser(botona_1);
	 }

	}
	
}
