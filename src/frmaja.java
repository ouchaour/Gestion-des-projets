import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;

public class frmaja extends JFrame {

	private JPanel contentPane;
	private JTextField txtLor;
	private JTextField textField_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmaja frame = new frmaja();
					frame.setSize(780, 500);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmaja() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\youssef\\Desktop\\2.jpg"));
		setForeground(Color.GREEN);
		setFont(new Font("Copperplate Gothic Light", Font.BOLD, 12));
		setTitle("Farmaja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JLabel lblNewLabel = new JLabel("Nom d'utilisateur");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(307, 65, 85, 18);
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JButton botona = new JButton("Confirmer");
		botona.setForeground(Color.white);
		botona.setBackground(new Color(0x012030));
		botona.setBounds(310, 260, 90, 30);
		botona.setBorder(new RoundBtn(15)); 
		contentPane.add(botona);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom d'utilisateur");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNewLabel_1.setBounds(307, 130, 109, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNewLabel_2.setBounds(307, 193, 96, 18);
		contentPane.add(lblNewLabel_2);
		
		txtLor = new JTextField();
		txtLor.setFont(new Font("Agency FB", Font.BOLD, 13));
		txtLor.setBounds(300, 94, 110, 25);
		contentPane.add(txtLor);
		txtLor.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Agency FB", Font.BOLD, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(300, 157, 110, 25);
		contentPane.add(textField_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Agency FB", Font.BOLD, 13));
		textField.setColumns(10);
		textField.setBounds(300, 214, 110, 25);
		contentPane.add(textField);
		
		JLabel tlowen = new JLabel("");
		tlowen.setForeground(new Color(0, 206, 209));
		tlowen.setBackground(new Color(0, 206, 209));
		tlowen.setBounds(285, 60, 140, 200);
		tlowen.setOpaque(true);
		contentPane.add(tlowen);
		

		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\youssef\\Desktop\\3.jpg"));
		lblNewLabel_4.setBounds(0, 0, 780, 500);
		contentPane.add(lblNewLabel_4);
		
	}

}

class RoundBtn implements Border 
{
    private int r;
    RoundBtn(int r) {
        this.r = r;
    }
    public Insets getBorderInsets(Component c) {
        return new Insets(this.r+1, this.r+1, this.r+2, this.r);
    }
    public boolean isBorderOpaque() {
        return true;
    }
    public void paintBorder(Component c, Graphics g, int x, int y, 
    int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, r, r);
    }
}