
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Page3 {

	private JPanel contentPane2;

	JFrame frame3 = new JFrame();

	public Page3() {
		JPanel contentPane2 = new JPanel();
		contentPane2.setBackground(Color.WHITE);
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		//frame3.setContentPane(contentPane2);
		contentPane2.setLayout(null);
		
		
		JButton botona_1 = new JButton("Ajouter");
		botona_1.setForeground(Color.WHITE);
		botona_1.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		botona_1.setBorder(null);
		botona_1.setBackground(Color.BLACK);
		botona_1.setBounds(0, 123, 335, 92);
		contentPane2.add(botona_1);
		
		JButton botona_2 = new JButton("Modifier");
		botona_2.setForeground(Color.BLACK);
		botona_2.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		botona_2.setBorder(null);
		botona_2.setBackground(new Color(255, 239, 213));
		botona_2.setBounds(0, 223, 335, 95);
		contentPane2.add(botona_2);
		
		JButton botona_3 = new JButton("Supprimer");
		botona_3.setForeground(Color.BLACK);
		botona_3.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		botona_3.setBorder(null);
		botona_3.setBackground(new Color(255, 239, 213));
		botona_3.setBounds(0, 323, 335, 95);
		contentPane2.add(botona_3);
		
		JButton botona_4 = new JButton("Archivage et Edition");
		botona_4.setForeground(Color.BLACK);
		botona_4.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		botona_4.setBorder(null);
		botona_4.setBackground(new Color(255, 239, 213));
		botona_4.setBounds(0, 423, 335, 95);
		contentPane2.add(botona_4);
		
		JLabel lbl1 = new JLabel("Nom d'utilisateur");
		lbl1.setForeground(Color.WHITE);
		lbl1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lbl1.setBounds(430, 130, 140, 18);
		contentPane2.add(lbl1);
		
		JTextField nom = new JTextField();
		nom.setFont(new Font("Arial Black", Font.PLAIN, 13));
		nom.setBounds(430, 160, 160, 26);
		contentPane2.add(nom);
		nom.setColumns(10);
		//---------------------------------
		JLabel lbl2 = new JLabel("Prénom d'utilisateur");
		lbl2.setForeground(Color.WHITE);
		lbl2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lbl2.setBounds(750, 130, 160, 18);
		contentPane2.add(lbl2);
		
		JTextField prenom = new JTextField();
		prenom.setFont(new Font("Arial Black", Font.PLAIN, 13));
		prenom.setBounds(750, 160, 160, 26);
		contentPane2.add(prenom);
		prenom.setColumns(10);
		//------------------------------------
		
		JLabel lbl3 = new JLabel("Password");
		lbl3.setForeground(Color.WHITE);
		lbl3.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lbl3.setBounds(430, 230, 140, 18);
		contentPane2.add(lbl3);
		
		JTextField pass = new JTextField();
		pass.setFont(new Font("Arial Black", Font.PLAIN, 13));
		pass.setBounds(430, 260, 160, 26);
		contentPane2.add(pass);
		pass.setColumns(10);
		//-------------------------------------
		
		JLabel lbl4 = new JLabel("Grade");
		lbl4.setForeground(Color.WHITE);
		lbl4.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lbl4.setBounds(750, 230, 140, 18);
		contentPane2.add(lbl4);
		
		JTextField grade = new JTextField();
		grade.setFont(new Font("Arial Black", Font.PLAIN, 13));
		grade.setBounds(750, 260, 160, 26);
		contentPane2.add(grade);
		grade.setColumns(10);
		//------------------------------------
		
		JLabel lbl5 = new JLabel("Email");
		lbl5.setForeground(Color.WHITE);
		lbl5.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lbl5.setBounds(430, 330, 140, 18);
		contentPane2.add(lbl5);
		
		JTextField email = new JTextField();
		email.setFont(new Font("Arial Black", Font.PLAIN, 13));
		email.setBounds(430, 360, 160, 26);
		contentPane2.add(email);
		email.setColumns(10);
		//-------------------------------------------
		JLabel lbl6 = new JLabel("Département");
		lbl6.setForeground(Color.WHITE);
		lbl6.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lbl6.setBounds(750, 330, 140, 18);
		contentPane2.add(lbl6);
		
		JTextField departement = new JTextField();
		departement.setFont(new Font("Arial Black", Font.PLAIN, 13));
		departement.setBounds(750, 360, 160, 26);
		contentPane2.add(departement);
		departement.setColumns(10);
		
		JButton botona = new JButton("Valider");
		botona.setForeground(Color.white);
		botona.setBackground(new Color(0x012030));
		botona.setBounds(650, 560, 100, 40);
		botona.setBorder(new RoundBtn(15)); 
		contentPane2.add(botona);
		
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Agency FB", Font.PLAIN, 15));
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\youssef\\Desktop\\77.jpg"));
		lblNewLabel_4.setBounds(0, 0, 1080, 720);
		contentPane2.add(lblNewLabel_4);
		
		frame3.setVisible(true);
		frame3.setSize(1080, 720);
		
	}
}
