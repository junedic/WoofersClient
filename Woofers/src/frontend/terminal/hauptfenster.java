package frontend.terminal;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JProgressBar;
import java.awt.TextArea;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.TextField;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class hauptfenster {

	private JFrame frmWoofersterminal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hauptfenster window = new hauptfenster();
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
	public hauptfenster() {
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
		
		JLabel lblNewLabel_1 = new JLabel("WOOFERS-TERMINAL");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(170, 44, 299, 82);
		frmWoofersterminal.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Kunden bearbeiten");
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBackground(new Color(255, 128, 64));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 19));
		btnNewButton.setBounds(183, 215, 272, 52);
		frmWoofersterminal.getContentPane().add(btnNewButton);
		
		JButton btnOk = new JButton("Termin l\u00F6schen");
		btnOk.setForeground(new Color(0, 0, 255));
		btnOk.setBackground(new Color(255, 128, 64));
		btnOk.setFont(new Font("Arial", Font.PLAIN, 19));
		btnOk.setBounds(319, 152, 165, 52);
		frmWoofersterminal.getContentPane().add(btnOk);
		
		JButton btnNeuenTermin = new JButton("Neuen Termin");
		btnNeuenTermin.setForeground(Color.BLUE);
		btnNeuenTermin.setFont(new Font("Arial", Font.PLAIN, 19));
		btnNeuenTermin.setBackground(new Color(255, 128, 64));
		btnNeuenTermin.setBounds(137, 152, 165, 52);
		frmWoofersterminal.getContentPane().add(btnNeuenTermin);
		
		JButton btnTerminlisteVonKunden = new JButton("Terminliste von Kunden ausgeben");
		btnTerminlisteVonKunden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTerminlisteVonKunden.setToolTipText("");
		btnTerminlisteVonKunden.setForeground(Color.BLUE);
		btnTerminlisteVonKunden.setFont(new Font("Arial", Font.PLAIN, 15));
		btnTerminlisteVonKunden.setBackground(new Color(255, 128, 64));
		btnTerminlisteVonKunden.setBounds(181, 278, 274, 53);
		frmWoofersterminal.getContentPane().add(btnTerminlisteVonKunden);
		
		JButton btnTerminlisteVonKunden_1 = new JButton("Terminliste von Kunden\r\nausgeben");
		btnTerminlisteVonKunden_1.setToolTipText("");
		btnTerminlisteVonKunden_1.setForeground(Color.BLUE);
		btnTerminlisteVonKunden_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnTerminlisteVonKunden_1.setBackground(new Color(255, 128, 64));
		btnTerminlisteVonKunden_1.setBounds(181, 342, 274, 52);
		frmWoofersterminal.getContentPane().add(btnTerminlisteVonKunden_1);
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
