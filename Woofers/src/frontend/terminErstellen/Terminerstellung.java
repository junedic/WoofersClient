package frontend.terminErstellen;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class Terminerstellung {

	/**
	 * @version 2.1
	 */

	private Shell shell;
	private Button zeitslot1;
	private Button zeitslot2;
	private Button zeitslot3;
	private Button zeitslot4;
	private Button zeitslot5;
	private Button massageCheck;
	private Button schneidenCheck;
	private Button entfilzenCheck;
	private Button entlausenCheck;
	private Button waschenBadenCheck;
	private Button bestellUebersicht;
	private Button zurueck;
	private Label terminErstellenUeberschrift;
	private Label entlausen;
	private Label entfilzen;
	private Label schneiden;
	private Label massage;
	private Label waschenBaden;
	private Label waehleHund;
	private Label waeleMitarbeiter;
	private Label buchbareDienstleistungen;
	private Label preisPlatzhalter;
	private Label preis;
	private Label verfuegbareZeitslots;
	private Combo hundeAuswahl;
	private Combo mitarbeiterAuswahl;
	private DateTime datumsAuswahl;

	/*
	 * public static void main(String[] args) {
	 * 
	 * terminErstellenStrukturiert terminErstellenStrukturiert = new
	 * terminErstellenStrukturiert(new Shell()); terminErstellenStrukturiert.open();
	 * }
	 */

	public void open() {
		Display display = Display.getDefault();
		init();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public Terminerstellung(Shell shell) {
		this.shell = shell;
		assignElements();
	}

	// @Override
	public void init() {
		initShell();
		initLabels();
		initButtons();
		initCombos();
		initDatePicker();
	}

	// @Override
	public void assignElements() {

		terminErstellenUeberschrift = new Label(shell, SWT.NONE);
		entlausen = new Label(shell, SWT.NONE);
		entfilzen = new Label(shell, SWT.NONE);
		schneiden = new Label(shell, SWT.NONE);
		massage = new Label(shell, SWT.NONE);
		waschenBaden = new Label(shell, SWT.NONE);
		waehleHund = new Label(shell, SWT.NONE);
		waeleMitarbeiter = new Label(shell, SWT.NONE);
		buchbareDienstleistungen = new Label(shell, SWT.NONE);
		preisPlatzhalter = new Label(shell, SWT.NONE);
		preis = new Label(shell, SWT.NONE);
		verfuegbareZeitslots = new Label(shell, SWT.NONE);
		zeitslot1 = new Button(shell, SWT.NONE);
		zeitslot2 = new Button(shell, SWT.NONE);
		zeitslot3 = new Button(shell, SWT.NONE);
		zeitslot4 = new Button(shell, SWT.NONE);
		zeitslot5 = new Button(shell, SWT.NONE);
		massageCheck = new Button(shell, SWT.BORDER | SWT.CHECK);
		schneidenCheck = new Button(shell, SWT.BORDER | SWT.CHECK);
		entfilzenCheck = new Button(shell, SWT.BORDER | SWT.CHECK);
		entlausenCheck = new Button(shell, SWT.BORDER | SWT.CHECK);
		waschenBadenCheck = new Button(shell, SWT.BORDER | SWT.CHECK);
		bestellUebersicht = new Button(shell, SWT.NONE);
		zurueck = new Button(shell, SWT.NONE);
		hundeAuswahl = new Combo(shell, SWT.NONE);
		mitarbeiterAuswahl = new Combo(shell, SWT.NONE);
		datumsAuswahl = new DateTime(shell, SWT.BORDER | SWT.CALENDAR);

	}

	// @Override
	public void dispose() {

		terminErstellenUeberschrift.dispose();
		entlausen.dispose();
		entfilzen.dispose();
		schneiden.dispose();
		massage.dispose();
		waschenBaden.dispose();
		waehleHund.dispose();
		buchbareDienstleistungen.dispose();
		preisPlatzhalter.dispose();
		preis.dispose();
		verfuegbareZeitslots.dispose();
		zeitslot1.dispose();
		zeitslot2.dispose();
		zeitslot3.dispose();
		zeitslot4.dispose();
		zeitslot5.dispose();
		bestellUebersicht.dispose();
		zurueck.dispose();
		hundeAuswahl.dispose();
		mitarbeiterAuswahl.dispose();
		assignElements();

	}

	private void initShell() {

		shell.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shell.setSize(422, 660);
		shell.setText("Termin erstellen");
		shell.setLayout(null);

	}

	private void initLabels() {

		verfuegbareZeitslots.setText("Zeitslots");
		verfuegbareZeitslots.setForeground(SWTResourceManager.getColor(255, 128, 128));
		verfuegbareZeitslots.setFont(SWTResourceManager.getFont("Lucida Handwriting", 11, SWT.NORMAL));
		verfuegbareZeitslots.setBackground(SWTResourceManager.getColor(64, 0, 128));
		verfuegbareZeitslots.setAlignment(SWT.CENTER);
		verfuegbareZeitslots.setBounds(230, 330, 148, 20);

		preis.setText("Preis :");
		preis.setForeground(SWTResourceManager.getColor(255, 255, 255));
		preis.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		preis.setBackground(SWTResourceManager.getColor(64, 0, 128));
		preis.setBounds(53, 285, 70, 20);

		waehleHund.setText("W\u00e4hlen Sie ihren Hund");
		waehleHund.setForeground(SWTResourceManager.getColor(255, 255, 255));
		waehleHund.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		waehleHund.setBackground(SWTResourceManager.getColor(64, 0, 128));
		waehleHund.setAlignment(SWT.RIGHT);
		waehleHund.setBounds(25, 225, 156, 20);

		entfilzen.setText("Entfilzen");
		entfilzen.setForeground(SWTResourceManager.getColor(255, 255, 255));
		entfilzen.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		entfilzen.setBackground(SWTResourceManager.getColor(64, 0, 128));
		entfilzen.setBounds(55, 191, 57, 20);

		entlausen.setText("Entlausen");
		entlausen.setForeground(SWTResourceManager.getColor(255, 255, 255));
		entlausen.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		entlausen.setBackground(SWTResourceManager.getColor(64, 0, 128));
		entlausen.setBounds(55, 166, 63, 20);

		schneiden.setText("Schneiden");
		schneiden.setForeground(SWTResourceManager.getColor(255, 255, 255));
		schneiden.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		schneiden.setBackground(SWTResourceManager.getColor(64, 0, 128));
		schneiden.setBounds(55, 141, 68, 20);

		massage.setText("Massage");
		massage.setForeground(SWTResourceManager.getColor(255, 255, 255));
		massage.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		massage.setBackground(SWTResourceManager.getColor(64, 0, 128));
		massage.setBounds(55, 116, 58, 20);

		waschenBaden.setText("Waschen / Baden");
		waschenBaden.setForeground(SWTResourceManager.getColor(255, 255, 255));
		waschenBaden.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		waschenBaden.setBackground(SWTResourceManager.getColor(64, 0, 128));
		waschenBaden.setBounds(55, 91, 114, 20);

		waeleMitarbeiter.setText("W\u00e4hlen Sie den Mitarbeiter");
		waeleMitarbeiter.setForeground(SWTResourceManager.getColor(255, 255, 255));
		waeleMitarbeiter.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		waeleMitarbeiter.setBackground(SWTResourceManager.getColor(64, 0, 128));
		waeleMitarbeiter.setAlignment(SWT.RIGHT);
		waeleMitarbeiter.setBounds(15, 255, 186, 20);

		// Preis hier anpassen
		preisPlatzhalter.setBounds(230, 283, 132, 20);
		preisPlatzhalter.setText("[Preis]");

		terminErstellenUeberschrift.setText("Terminerstellung");
		terminErstellenUeberschrift.setForeground(SWTResourceManager.getColor(255, 128, 0));
		terminErstellenUeberschrift.setFont(SWTResourceManager.getFont("Lucida Handwriting", 16, SWT.BOLD));
		terminErstellenUeberschrift.setBackground(SWTResourceManager.getColor(64, 0, 128));
		terminErstellenUeberschrift.setBounds(100, 23, 239, 30);

		buchbareDienstleistungen.setBounds(115, 59, 200, 20);
		buchbareDienstleistungen.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		buchbareDienstleistungen.setForeground(SWTResourceManager.getColor(255, 255, 255));
		buchbareDienstleistungen.setBackground(SWTResourceManager.getColor(64, 0, 128));
		buchbareDienstleistungen.setText("Buchbare Dienstleistungen");

	}

	private void initButtons() {

		zeitslot1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		// Eventhandler wenn Button 'Zeitslot 1' gewählt wurde
		// Je nachdem ob der Zeitslot bereits gebucht wurde muss dieser Button
		// ausgegraut / selektierbar sein
		zeitslot1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		zeitslot1.setBounds(260, 355, 90, 30);
		zeitslot1.setText("08:00 - 09:30");

		// Eventhandler wenn Button 'Zeitslot 2' gewählt wurde
		// Je nachdem ob der Zeitslot bereits gebucht wurde muss dieser Button
		// ausgegraut / selektierbar sein
		zeitslot2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		zeitslot2.setBounds(260, 390, 90, 30);
		zeitslot2.setText("09:45 - 11:15");

		// Eventhandler wenn Button 'Zeitslot 3' gewählt wurde
		// Je nachdem ob der Zeitslot bereits gebucht wurde muss dieser Button
		// ausgegraut / selektierbar sein
		zeitslot3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		zeitslot3.setBounds(260, 425, 90, 30);
		zeitslot3.setText("12:00 - 13:30");

		// Eventhandler wenn Button 'Zeitslot 4' gewählt wurde
		// Je nachdem ob der Zeitslot bereits gebucht wurde muss dieser Button
		// ausgegraut / selektierbar sein
		zeitslot4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		zeitslot4.setBounds(260, 460, 90, 30);
		zeitslot4.setText("13:40 - 15:10");

		// Eventhandler wenn Button 'Zeitslot 5' gewählt wurde
		// Je nachdem ob der Zeitslot bereits gebucht wurde muss dieser Button
		// ausgegraut / selektierbar sein
		zeitslot5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		zeitslot5.setBounds(260, 495, 90, 30);
		zeitslot5.setText("15:20 - 16:50");

		massageCheck.setBounds(230, 116, 16, 20);
		// Eventhandler wenn Checklist 'Massage' gecheked wurde
		massageCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});

		schneidenCheck.setBounds(230, 142, 16, 20);
		// Eventhandler wenn Checklist 'Waschen / Baden' gecheked wurde
		schneidenCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});

		entlausenCheck.setBounds(230, 168, 16, 20);
		// Eventhandler wenn Checklist 'Waschen / Baden' gecheked wurde
		entlausenCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});

		entfilzenCheck.setBounds(230, 194, 16, 20);
		// Eventhandler wenn Checklist 'Waschen / Baden' gecheked wurde
		entfilzenCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});

		waschenBadenCheck.setBounds(230, 91, 16, 19);
		// Eventhandler wenn Checklist 'Waschen / Baden' gecheked wurde
		waschenBadenCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});

		bestellUebersicht.setBounds(232, 560, 151, 30);
		bestellUebersicht.setText("Bestell\u00fcbersicht");
		bestellUebersicht.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});

		// Warum ist das das einzige mit location lul
		zurueck.setLocation(33, 560);
		zurueck.setSize(151, 30);
		zurueck.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		zurueck.setText("Zur\u00fcck");

	}

	private void initCombos() {

		hundeAuswahl.setBounds(230, 220, 132, 28);

		mitarbeiterAuswahl.setBounds(230, 250, 132, 28);

	}

	private void initDatePicker() {

		datumsAuswahl.setLocation(25, 349);
		datumsAuswahl.setSize(193, 178);

	}

	public Button getZeitslot1() {
		return zeitslot1;
	}

	public void setZeitslot1(Button zeitslot1) {
		this.zeitslot1 = zeitslot1;
	}

	public Button getZeitslot2() {
		return zeitslot2;
	}

	public void setZeitslot2(Button zeitslot2) {
		this.zeitslot2 = zeitslot2;
	}

	public Button getZeitslot3() {
		return zeitslot3;
	}

	public void setZeitslot3(Button zeitslot3) {
		this.zeitslot3 = zeitslot3;
	}

	public Button getZeitslot4() {
		return zeitslot4;
	}

	public void setZeitslot4(Button zeitslot4) {
		this.zeitslot4 = zeitslot4;
	}

	public Button getZeitslot5() {
		return zeitslot5;
	}

	public void setZeitslot5(Button zeitslot5) {
		this.zeitslot5 = zeitslot5;
	}

	public Button getMassageCheck() {
		return massageCheck;
	}

	public void setMassageCheck(Button massageCheck) {
		this.massageCheck = massageCheck;
	}

	public Button getSchneidenCheck() {
		return schneidenCheck;
	}

	public void setSchneidenCheck(Button schneidenCheck) {
		this.schneidenCheck = schneidenCheck;
	}

	public Button getEntfilzenCheck() {
		return entfilzenCheck;
	}

	public void setEntfilzenCheck(Button entfilzenCheck) {
		this.entfilzenCheck = entfilzenCheck;
	}

	public Button getEntlausenCheck() {
		return entlausenCheck;
	}

	public void setEntlausenCheck(Button entlausenCheck) {
		this.entlausenCheck = entlausenCheck;
	}

	public Button getWaschenBadenCheck() {
		return waschenBadenCheck;
	}

	public void setWaschenBadenCheck(Button waschenBadenCheck) {
		this.waschenBadenCheck = waschenBadenCheck;
	}

	public Button getBestellUebersicht() {
		return bestellUebersicht;
	}

	public void setBestellUebersicht(Button bestellUebersicht) {
		this.bestellUebersicht = bestellUebersicht;
	}

	public Button getZurueck() {
		return zurueck;
	}

	public void setZurueck(Button zurueck) {
		this.zurueck = zurueck;
	}

	public Label getTerminErstellenUeberschrift() {
		return terminErstellenUeberschrift;
	}

	public void setTerminErstellenUeberschrift(Label terminErstellenUeberschrift) {
		this.terminErstellenUeberschrift = terminErstellenUeberschrift;
	}

	public Label getEntlausen() {
		return entlausen;
	}

	public void setEntlausen(Label entlausen) {
		this.entlausen = entlausen;
	}

	public Label getEntfilzen() {
		return entfilzen;
	}

	public void setEntfilzen(Label entfilzen) {
		this.entfilzen = entfilzen;
	}

	public Label getSchneiden() {
		return schneiden;
	}

	public void setSchneiden(Label schneiden) {
		this.schneiden = schneiden;
	}

	public Label getMassage() {
		return massage;
	}

	public void setMassage(Label massage) {
		this.massage = massage;
	}

	public Label getWaschenBaden() {
		return waschenBaden;
	}

	public void setWaschenBaden(Label waschenBaden) {
		this.waschenBaden = waschenBaden;
	}

	public Label getWaeleHund() {
		return waehleHund;
	}

	public void setWaeleHund(Label waeleHund) {
		this.waehleHund = waeleHund;
	}

	public Label getWaeleMitarbeiter() {
		return waeleMitarbeiter;
	}

	public void setWaeleMitarbeiter(Label waeleMitarbeiter) {
		this.waeleMitarbeiter = waeleMitarbeiter;
	}

	public Label getBuchbareDienstleistungen() {
		return buchbareDienstleistungen;
	}

	public void setBuchbareDienstleistungen(Label buchbareDienstleistungen) {
		this.buchbareDienstleistungen = buchbareDienstleistungen;
	}

	public Label getPreisPlatzhalter() {
		return preisPlatzhalter;
	}

	public void setPreisPlatzhalter(Label preisPlatzhalter) {
		this.preisPlatzhalter = preisPlatzhalter;
	}

	public Label getPreis() {
		return preis;
	}

	public void setPreis(Label preis) {
		this.preis = preis;
	}

	public Label getVerfuegbareZeitslots() {
		return verfuegbareZeitslots;
	}

	public void setVerfuegbareZeitslots(Label verfuegbareZeitslots) {
		this.verfuegbareZeitslots = verfuegbareZeitslots;
	}

	public Combo getHundeAuswahl() {
		return hundeAuswahl;
	}

	public void setHundeAuswahl(Combo hundeAuswahl) {
		this.hundeAuswahl = hundeAuswahl;
	}

	public Combo getMitarbeiterAuswahl() {
		return mitarbeiterAuswahl;
	}

	public void setMitarbeiterAuswahl(Combo mitarbeiterAuswahl) {
		this.mitarbeiterAuswahl = mitarbeiterAuswahl;
	}

	public DateTime getDatumsAuswahl() {
		return datumsAuswahl;
	}

	public void setDatumsAuswahl(DateTime datumsAuswahl) {
		this.datumsAuswahl = datumsAuswahl;
	}

}
