package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.wb.swt.SWTResourceManager;

import java.io.Closeable;
import java.io.IOException;

public class Hauptfenster implements View, Closeable {

	private Shell 	shell;
	private Label 	terminal;
	private Button erstelleTermin;
	private Button entferneTermin;
	private Button terminKunde;
	private Button terminMitarbeiter;
	private Button bearbeiteKunde;
	private Button setzeIP;
	private Text	ip;
	
	public Hauptfenster() {
		shell = new Shell();
		terminal = new Label(shell, SWT.NONE);
		erstelleTermin = new Button(shell, SWT.NONE);
		entferneTermin = new Button(shell, SWT.NONE);
		terminMitarbeiter = new Button(shell, SWT.NONE);
		terminKunde = new Button(shell, SWT.NONE);
		bearbeiteKunde = new Button(shell, SWT.NONE);
		setzeIP = new Button(shell, SWT.NONE);
		ip = new Text(shell, SWT.BORDER);
		ip.insert("IP-Addresse");
		init();
	}

	@Override
	public void weiseElementeZu() {
		terminal 				= new Label(shell, SWT.NONE);
		erstelleTermin = new Button(shell, SWT.NONE);
		entferneTermin = new Button(shell, SWT.NONE);
		terminMitarbeiter = new Button(shell, SWT.NONE);
		terminKunde = new Button(shell, SWT.NONE);
		bearbeiteKunde = new Button(shell, SWT.NONE);
		setzeIP = new Button(shell, SWT.NONE);
		ip 						= new Text(shell, SWT.BORDER);
	}

	@Override
	public void entsorge() {
		terminal.dispose();
		erstelleTermin.dispose();
		entferneTermin.dispose();
		terminKunde.dispose();
		terminMitarbeiter.dispose();
		bearbeiteKunde.dispose();
		setzeIP.dispose();
		ip.dispose();
	}

	@Override
	public void init() {
		initShell();
		initTerminal();
		initButtons();
	}

	private void initShell() {
		shell.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shell.setSize(570, 418);
		shell.setText("Hauptfenster");
		shell.setLayout(null);
		/*
		Label label = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBackground(SWTResourceManager.getColor(255, 128, 0));
		label.setForeground(SWTResourceManager.getColor(255, 128, 0));
		label.setText("\u00F6\u00F6");
		label.setBounds(-12, 118, 572, 2);

		Label lblD = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblD.setText("d");
		lblD.setBounds(0, 67, 560, 2);
		*/
	}

	private void initTerminal() {
		terminal.setAlignment(SWT.CENTER);
		terminal.setForeground(SWTResourceManager.getColor(255, 255, 255));
		terminal.setFont(SWTResourceManager.getFont("Eras Demi ITC", 22, SWT.NORMAL));
		terminal.setBackground(SWTResourceManager.getColor(64, 0, 128));
		terminal.setBounds(91, 75, 370, 37);
		terminal.setText("wOOfers TERMINAL");
	}

	private void initButtons() {
		erstelleTermin.setForeground(SWTResourceManager.getColor(64, 0, 64));
		erstelleTermin.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		erstelleTermin.setBounds(143, 143, 122, 37);
		erstelleTermin.setText("Termin erstellen");

		/*
		entferneTermin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
				Termin_Eingabe.main(null);
			}
		});
		*/
		entferneTermin.setText("Termin l\u00F6schen");
		entferneTermin.setForeground(SWTResourceManager.getColor(64, 0, 64));
		entferneTermin.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		entferneTermin.setBounds(269, 143, 122, 37);

		terminMitarbeiter.setText("Terminliste von Mitarbeiter ausgeben");
		terminMitarbeiter.setForeground(SWTResourceManager.getColor(64, 0, 64));
		terminMitarbeiter.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		terminMitarbeiter.setBounds(143, 186, 248, 37);

		terminKunde.setText("Terminliste von Kunden ausgeben");
		terminKunde.setForeground(SWTResourceManager.getColor(64, 0, 64));
		terminKunde.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		terminKunde.setBounds(143, 229, 248, 37);

		/*
		bearbeiteKunde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
				KundenNr_Eingabe.main(null);
			}
		});
		 */
		bearbeiteKunde.setText("Kundenprofil bearbeiten");
		bearbeiteKunde.setForeground(SWTResourceManager.getColor(64, 0, 64));
		bearbeiteKunde.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		bearbeiteKunde.setBounds(143, 272, 248, 37);

		setzeIP.setText("Setze IP");
		setzeIP.setForeground(SWTResourceManager.getColor(64, 0, 64));
		setzeIP.setFont(SWTResourceManager.getFont("Arial", 8, SWT.BOLD));
		setzeIP.setBounds(269, 115, 123, 25);

		ip.setBounds(143, 115, 123, 25);
	}

	public Shell getShell() {
		return shell;
	}

	public Label getTerminal() {
		return terminal;
	}

	public Button getErstelleTermin() {
		return erstelleTermin;
	}

	public Button getEntferneTermin() {
		return entferneTermin;
	}

	public Button getTerminKunde() {
		return terminKunde;
	}

	public Button getTerminMitarbeiter() {
		return terminMitarbeiter;
	}

	public Button getBearbeiteKunde() {
		return bearbeiteKunde;
	}

	public Button getSetzeIP() { return setzeIP; }

	public Text getIp() { return ip; }

	@Override
	public void close() throws IOException {
		shell.close();
	}

}
