import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class page1 implements ActionListener {

	private JPanel contentPane;
	 JFrame frame1 = new JFrame();
	 JButton botona = new JButton("Professeur");

	/**
	 * Create the frame1.
	 */
	public page1() {
		frame1.setForeground(Color.BLUE);
		frame1.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 12));
		frame1.setTitle("Farmaja");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame1.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		botona.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		botona.setForeground(Color.BLACK);
		botona.setBackground(new Color(255, 239, 213));
		botona.setBounds(67, 42, 160, 42);
		botona.setBorder(null);
		botona.setFocusable(false);
		botona.addActionListener(this);
		contentPane.add(botona);
		
		JButton botona_1 = new JButton("Etudiant");
		botona_1.setForeground(Color.BLACK);
		botona_1.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		botona_1.setBorder(null);
		botona_1.setBackground(new Color(255, 239, 213));
		botona_1.setBounds(67, 142, 160, 42);
		botona_1.setFocusable(false);
		contentPane.add(botona_1);
		
		JButton botona_2 = new JButton("Projet");
		botona_2.setForeground(Color.BLACK);
		botona_2.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		botona_2.setBorder(null);
		botona_2.setBackground(new Color(255, 239, 213));
		botona_2.setBounds(67, 242, 160, 42);
		botona_2.setFocusable(false);
		contentPane.add(botona_2);
		
		
		JButton botona_3 = new JButton("Departement");
		botona_3.setForeground(Color.BLACK);
		botona_3.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		botona_3.setBorder(null);
		botona_3.setBackground(new Color(255, 239, 213));
		botona_3.setBounds(67, 342, 160, 42);
		botona_3.setFocusable(false);
		contentPane.add(botona_3);
		
		JButton botona_4 = new JButton("Filier");
		botona_4.setForeground(Color.BLACK);
		botona_4.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		botona_4.setBorder(null);
		botona_4.setBackground(new Color(255, 239, 213));
		botona_4.setBounds(67, 442, 160, 42);
		botona_4.setFocusable(false);
		contentPane.add(botona_4);
		
		JButton botona_5 = new JButton("Laboratoire");
		botona_5.setForeground(Color.BLACK);
		botona_5.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		botona_5.setBorder(null);
		botona_5.setBackground(new Color(255, 239, 213));
		botona_5.setBounds(67, 542, 160, 42);
		botona_5.setFocusable(false);
		contentPane.add(botona_5);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Agency FB", Font.PLAIN, 15));
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\youssef\\Desktop\\55.png"));
		lblNewLabel_4.setBounds(0, 0, 1080, 720);
		contentPane.add(lblNewLabel_4);
		
		frame1.setSize(1080, 720);
		frame1.setVisible(true);
		
	}

@Override
public void actionPerformed(ActionEvent e) {
 
 if(e.getSource()==botona) {
  frame1.dispose();
  page2 window2 = new page2();
 }
}
}
