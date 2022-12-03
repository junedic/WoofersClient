package view.terminLöschen;

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

public class terminEingabe {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					terminEingabe window = new terminEingabe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public terminEingabe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 0, 128));
		frame.getContentPane().setLayout(null);
		
		TextField textField = new TextField();
		textField.setBounds(344, 166, 106, 21);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel = new JLabel("TerminID");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(160, 147, 120, 67);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bitte geben Sie ID des Termins ein");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(117, 43, 470, 82);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Zur\u00FCck");
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBackground(new Color(255, 128, 64));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 19));
		btnNewButton.setBounds(136, 247, 120, 52);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnOk = new JButton("OK");
		btnOk.setForeground(new Color(0, 0, 255));
		btnOk.setBackground(new Color(255, 128, 64));
		btnOk.setFont(new Font("Arial", Font.PLAIN, 19));
		btnOk.setBounds(405, 247, 120, 52);
		frame.getContentPane().add(btnOk);
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
