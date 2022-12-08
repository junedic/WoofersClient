package frontend.terminErstellen;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class terminBuchungsdetailsStrukturiert {

	/**
	 * @version 2.1
	 */

	private Shell shell;
	private Label buchungsdetailsUeberschrift;
	private Label gebuchteDienstleistungen;
	private Label weitereInfos;
	private Label gebuchteDienstleistungenPlatzhalter;
	private Label preis;
	private Label mitarbeiter;
	private Label hund;
	private Label amDatum;
	private Label umUhrzeit;
	private Label trennlinie;
	private Button buchen;
	private Button zurueck;

	/*
	 * public static void main(String[] args) {
	 * 
	 * terminBuchungsdetailsStrukturiert terminErstellenStrukturiert = new
	 * terminBuchungsdetailsStrukturiert( new Shell());
	 * terminErstellenStrukturiert.open(); }
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

	public terminBuchungsdetailsStrukturiert(Shell shell) {

		this.shell = shell;
		assignElements();
	}

	// @Override
	public void init() {

		initShell();
		initLabels();
		initButtons();
		
	}

	// @Override
	public void assignElements() {

		buchungsdetailsUeberschrift = new Label(shell, SWT.NONE);
		gebuchteDienstleistungen = new Label(shell, SWT.NONE);
		weitereInfos = new Label(shell, SWT.NONE);
		gebuchteDienstleistungenPlatzhalter = new Label(shell, SWT.NONE);
		preis = new Label(shell, SWT.NONE);
		mitarbeiter = new Label(shell, SWT.NONE);
		hund = new Label(shell, SWT.NONE);
		amDatum = new Label(shell, SWT.NONE);
		umUhrzeit = new Label(shell, SWT.NONE);
		trennlinie = new Label(shell, SWT.NONE);
		buchen = new Button(shell, SWT.NONE);
		zurueck = new Button(shell, SWT.NONE);

	}

	// @Override
	public void dispose() {

		buchungsdetailsUeberschrift.dispose();
		gebuchteDienstleistungen.dispose();
		weitereInfos.dispose();
		gebuchteDienstleistungenPlatzhalter.dispose();
		preis.dispose();
		mitarbeiter.dispose();
		hund.dispose();
		amDatum.dispose();
		umUhrzeit.dispose();
		trennlinie.dispose();
		buchen.dispose();
		zurueck.dispose();
		assignElements();
		
	}

	private void initShell() {

		shell.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shell.setSize(422, 660);
		shell.setText("Buchungsdetails");
		shell.setLayout(null);
		
	}

	private void initLabels() {

		// Compile den String zu 'Um : [gewähltesDatum]'
		amDatum.setText("Am");
		amDatum.setForeground(SWTResourceManager.getColor(255, 255, 255));
		amDatum.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		amDatum.setBackground(SWTResourceManager.getColor(64, 0, 64));
		amDatum.setBounds(400, 253, 33, 20);

		// Compile den String zu 'Um : [gewählteUhrzeit]'
		umUhrzeit.setText("Um");
		umUhrzeit.setForeground(SWTResourceManager.getColor(255, 255, 255));
		umUhrzeit.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		umUhrzeit.setBackground(SWTResourceManager.getColor(64, 0, 64));
		umUhrzeit.setBounds(400, 279, 33, 20);

		buchungsdetailsUeberschrift.setText("Buchungsdetails");
		buchungsdetailsUeberschrift.setBackground(SWTResourceManager.getColor(64, 0, 64));
		buchungsdetailsUeberschrift.setForeground(SWTResourceManager.getColor(255, 255, 255));
		buchungsdetailsUeberschrift.setAlignment(SWT.CENTER);
		buchungsdetailsUeberschrift.setFont(SWTResourceManager.getFont("Cascadia Mono", 14, SWT.BOLD));
		buchungsdetailsUeberschrift.setBounds(0, 37, 634, 30);

		gebuchteDienstleistungen.setText("Gebuchte Dienstleistungen");
		gebuchteDienstleistungen.setForeground(SWTResourceManager.getColor(255, 255, 255));
		gebuchteDienstleistungen.setFont(SWTResourceManager.getFont("Cascadia Code", 11, SWT.NORMAL));
		gebuchteDienstleistungen.setBackground(SWTResourceManager.getColor(0, 0, 64));
		gebuchteDienstleistungen.setAlignment(SWT.CENTER);
		gebuchteDienstleistungen.setBounds(47, 86, 251, 20);

		weitereInfos.setText("Weitere Informationen");
		weitereInfos.setForeground(SWTResourceManager.getColor(255, 255, 255));
		weitereInfos.setFont(SWTResourceManager.getFont("Cascadia Code", 11, SWT.NORMAL));
		weitereInfos.setBackground(SWTResourceManager.getColor(0, 0, 64));
		weitereInfos.setAlignment(SWT.CENTER);
		weitereInfos.setBounds(324, 86, 261, 20);

		// Compile den String zu einer Liste gebuchter Dienstleistugnen mit nem '-'
		// davor oder so
		gebuchteDienstleistungenPlatzhalter.setText("[gebuchteDienstleistungen");
		gebuchteDienstleistungenPlatzhalter.setForeground(SWTResourceManager.getColor(255, 255, 255));
		gebuchteDienstleistungenPlatzhalter.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		gebuchteDienstleistungenPlatzhalter.setBackground(SWTResourceManager.getColor(64, 0, 64));
		gebuchteDienstleistungenPlatzhalter.setBounds(83, 136, 139, 20);

		// Compile den String zu 'Preis : [sumPreis]'
		preis.setText("Preis :");
		preis.setForeground(SWTResourceManager.getColor(255, 255, 255));
		preis.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		preis.setBackground(SWTResourceManager.getColor(64, 0, 64));
		preis.setAlignment(SWT.RIGHT);
		preis.setBounds(129, 290, 49, 20);

		// Compile den String zu 'Hund : /n [ausgewählterHund]'
		hund.setText("Für Ihren Hund:");
		hund.setForeground(SWTResourceManager.getColor(255, 255, 255));
		hund.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		hund.setBackground(SWTResourceManager.getColor(64, 0, 64));
		hund.setBounds(384, 127, 112, 20);

		// Compile den String zu 'Bei unserem Mitarbeiter : /n
		// [ausgewählterMitarbeiter]'
		mitarbeiter.setText("Bei unserem Mitarbeiter :");
		mitarbeiter.setForeground(SWTResourceManager.getColor(255, 255, 255));
		mitarbeiter.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		mitarbeiter.setBackground(SWTResourceManager.getColor(64, 0, 64));
		mitarbeiter.setBounds(384, 182, 175, 20);

		trennlinie.setText("_____________________________________________");
		trennlinie.setForeground(SWTResourceManager.getColor(255, 255, 255));
		trennlinie.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		trennlinie.setBackground(SWTResourceManager.getColor(64, 0, 64));
		trennlinie.setBounds(47, 264, 251, 20);
	}

	private void initButtons() {

		zurueck.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		zurueck.setBounds(47, 359, 137, 30);
		zurueck.setText("Angaben anpassen");

		buchen.setForeground(SWTResourceManager.getColor(0, 0, 0));
		buchen.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		buchen.setText("Termin buchen");
		buchen.setBounds(467, 359, 118, 30);

	}

	public Label getBuchungsdetailsUeberschrift() {
		return buchungsdetailsUeberschrift;
	}

	public void setBuchungsdetailsUeberschrift(Label buchungsdetailsUeberschrift) {
		this.buchungsdetailsUeberschrift = buchungsdetailsUeberschrift;
	}

	public Label getGebuchteDienstleistungen() {
		return gebuchteDienstleistungen;
	}

	public void setGebuchteDienstleistungen(Label gebuchteDienstleistungen) {
		this.gebuchteDienstleistungen = gebuchteDienstleistungen;
	}

	public Label getWeitereInfos() {
		return weitereInfos;
	}

	public void setWeitereInfos(Label weitereInfos) {
		this.weitereInfos = weitereInfos;
	}

	public Label getGebuchteDienstleistungenPlatzhalter() {
		return gebuchteDienstleistungenPlatzhalter;
	}

	public void setGebuchteDienstleistungenPlatzhalter(Label gebuchteDienstleistungenPlatzhalter) {
		this.gebuchteDienstleistungenPlatzhalter = gebuchteDienstleistungenPlatzhalter;
	}

	public Label getPreis() {
		return preis;
	}

	public void setPreis(Label preis) {
		this.preis = preis;
	}

	public Label getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(Label mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	public Label getHund() {
		return hund;
	}

	public void setHund(Label hund) {
		this.hund = hund;
	}

	public Label getAmDatum() {
		return amDatum;
	}

	public void setAmDatum(Label amDatum) {
		this.amDatum = amDatum;
	}

	public Label getUmUhrzeit() {
		return umUhrzeit;
	}

	public void setUmUhrzeit(Label umUhrzeit) {
		this.umUhrzeit = umUhrzeit;
	}

	public Label getTrennlinie() {
		return trennlinie;
	}

	public void setTrennlinie(Label trennlinie) {
		this.trennlinie = trennlinie;
	}

	public Button getBuchen() {
		return buchen;
	}

	public void setBuchen(Button buchen) {
		this.buchen = buchen;
	}

	public Button getZurueck() {
		return zurueck;
	}

	public void setZurueck(Button zurueck) {
		this.zurueck = zurueck;
	}

}
