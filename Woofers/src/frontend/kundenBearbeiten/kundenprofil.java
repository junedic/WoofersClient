package frontend.kundenBearbeiten;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class kundenprofil {

	private JFrame frmWoofersterminal;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application .
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kundenprofil window = new kundenprofil();
					window.frmWoofersterminal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public kundenprofil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWoofersterminal = new JFrame();
		frmWoofersterminal.setTitle("Hauptmen\u00FC");
		frmWoofersterminal.getContentPane().setBackground(new Color(64, 0, 128));
		frmWoofersterminal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("KundenID: ");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(63, 36, 157, 82);
		frmWoofersterminal.getContentPane().add(lblNewLabel_1);
		
		JButton btnNeuenTermin = new JButton("SPEICHERN");
		btnNeuenTermin.setForeground(Color.BLUE);
		btnNeuenTermin.setFont(new Font("Arial", Font.PLAIN, 19));
		btnNeuenTermin.setBackground(new Color(255, 128, 64));
		btnNeuenTermin.setBounds(210, 410, 157, 38);
		frmWoofersterminal.getContentPane().add(btnNeuenTermin);
		
		JLabel lblNewLabel_1_1 = new JLabel("X");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 28));
		lblNewLabel_1_1.setBounds(210, 36, 157, 82);
		frmWoofersterminal.getContentPane().add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(308, 155, 239, 29);
		frmWoofersterminal.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nachname");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel_1_2.setBounds(63, 129, 157, 82);
		frmWoofersterminal.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Telefon\r\nnummer");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel_1_2_1.setBounds(63, 205, 183, 82);
		frmWoofersterminal.getContentPane().add(lblNewLabel_1_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(308, 236, 239, 29);
		frmWoofersterminal.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("E-Mail");
		lblNewLabel_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel_1_2_1_1.setBounds(63, 290, 183, 82);
		frmWoofersterminal.getContentPane().add(lblNewLabel_1_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(308, 321, 239, 29);
		frmWoofersterminal.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mein Profil");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_3.setFont(new Font("Ink Free", Font.PLAIN, 36));
		lblNewLabel_1_3.setBounds(343, 36, 176, 82);
		frmWoofersterminal.getContentPane().add(lblNewLabel_1_3);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
