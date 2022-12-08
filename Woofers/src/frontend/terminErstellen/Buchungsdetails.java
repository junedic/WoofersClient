package frontend.terminErstellen;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import view.View;

public class Buchungsdetails implements View {

	private Shell shell;
	/*
	 * -------------Standardlabels------------------
	 */
	private Label lblBuchungsdetails;
	private Label lblBuchbareDienstleistungen;
	private Label lblPreisbezeichnung;
	private Label lblTrennlinie;
	private Label lblWaehrung;
	private Label lblFuerIhrenHund;
	private Label lblUm;
	private Label lblBeiUnseremMitarbeiter;
	private Label lblAm;
	private Label lblWeitereInfos;
	private Button btnAngabenAnpassen;
	private Button btnTerminBuchen;
	private Composite comp1;
	private Composite comp2;

	/*
	 * -------------Mit korrekten Werten ueberschreiben------------------
	 */
	private Label lblPreis;
	private Label lblDatum;
	private Label lblMitarbeitername;
	private Label lblHundename;
	private Label lblUhrzeit;
	private List list;

	public Buchungsdetails(Shell shell) {
		this.shell = shell;
		assignElements();
	}

	public void open() {
		Display display = Display.getDefault();
		init();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	@Override
	public void init() {
		initShell();
		initComposit();
		initLabel();
		initList();
		initButtons();
	}

	private void initShell() {
		shell.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shell.setSize(642, 459);
		shell.setText("Bestellung \u00FCberpr\u00FCfen");
	}

	private void initLabel() {
		lblBuchungsdetails.setBackground(SWTResourceManager.getColor(64, 0, 64));
		lblBuchungsdetails.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblBuchungsdetails.setAlignment(SWT.CENTER);
		lblBuchungsdetails.setFont(SWTResourceManager.getFont("Cascadia Mono", 14, SWT.BOLD));
		lblBuchungsdetails.setBounds(0, 37, 634, 30);
		lblBuchungsdetails.setText("Buchungsdetails");

		lblBuchbareDienstleistungen.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblBuchbareDienstleistungen.setBackground(SWTResourceManager.getColor(0, 0, 64));
		lblBuchbareDienstleistungen.setAlignment(SWT.CENTER);
		lblBuchbareDienstleistungen.setFont(SWTResourceManager.getFont("Cascadia Code", 11, SWT.NORMAL));
		lblBuchbareDienstleistungen.setText("Gebuchte Dienstleistungen");
		lblBuchbareDienstleistungen.setBounds(0, 0, 251, 20);

		lblTrennlinie.setText("_____________________________________________");
		lblTrennlinie.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblTrennlinie.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		lblTrennlinie.setBackground(SWTResourceManager.getColor(64, 0, 64));
		lblTrennlinie.setBounds(0, 178, 251, 20);

		lblPreisbezeichnung.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblPreisbezeichnung.setBackground(SWTResourceManager.getColor(64, 0, 64));
		lblPreisbezeichnung.setAlignment(SWT.RIGHT);
		lblPreisbezeichnung.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		lblPreisbezeichnung.setText("Preis :");
		lblPreisbezeichnung.setBounds(82, 204, 49, 20);

		lblPreis.setForeground(SWTResourceManager.getColor(255, 128, 128));
		lblPreis.setBackground(SWTResourceManager.getColor(64, 0, 64));
		lblPreis.setAlignment(SWT.CENTER);
		lblPreis.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		lblPreis.setText("10000");
		lblPreis.setBounds(137, 204, 49, 20);

		lblWaehrung.setBackground(SWTResourceManager.getColor(64, 0, 64));
		lblWaehrung.setForeground(SWTResourceManager.getColor(255, 128, 128));
		lblWaehrung.setText("\u20AC");
		lblWaehrung.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		lblWaehrung.setBounds(192, 204, 49, 20);

		lblFuerIhrenHund.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblFuerIhrenHund.setBackground(SWTResourceManager.getColor(64, 0, 64));
		lblFuerIhrenHund.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		lblFuerIhrenHund.setText("F\u00FCr Ihren Hund:");
		lblFuerIhrenHund.setBounds(60, 41, 112, 20);

		lblUm.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblUm.setBackground(SWTResourceManager.getColor(64, 0, 64));
		lblUm.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		lblUm.setText("Um");
		lblUm.setBounds(76, 193, 33, 20);

		lblDatum.setForeground(SWTResourceManager.getColor(255, 128, 128));
		lblDatum.setBackground(SWTResourceManager.getColor(64, 0, 64));
		lblDatum.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		lblDatum.setText("[Datum]");
		lblDatum.setBounds(115, 167, 57, 20);

		lblAm.setBackground(SWTResourceManager.getColor(64, 0, 64));
		lblAm.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblAm.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		lblAm.setText("Am");
		lblAm.setBounds(76, 167, 33, 20);

		lblMitarbeitername.setForeground(SWTResourceManager.getColor(255, 128, 128));
		lblMitarbeitername.setBackground(SWTResourceManager.getColor(64, 0, 64));
		lblMitarbeitername.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		lblMitarbeitername.setText("[Mitarbeitername]");
		lblMitarbeitername.setBounds(76, 123, 132, 20);

		lblBeiUnseremMitarbeiter.setBackground(SWTResourceManager.getColor(64, 0, 64));
		lblBeiUnseremMitarbeiter.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblBeiUnseremMitarbeiter.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		lblBeiUnseremMitarbeiter.setText("Bei unserem Mitarbeiter :");
		lblBeiUnseremMitarbeiter.setBounds(60, 96, 175, 20);

		lblHundename.setForeground(SWTResourceManager.getColor(255, 128, 128));
		lblHundename.setBackground(SWTResourceManager.getColor(64, 0, 64));
		lblHundename.setFont(SWTResourceManager.getFont("Arial", 13, SWT.BOLD));
		lblHundename.setText("BELLO");
		lblHundename.setBounds(76, 67, 70, 20);

		lblUhrzeit.setForeground(SWTResourceManager.getColor(255, 128, 128));
		lblUhrzeit.setBackground(SWTResourceManager.getColor(64, 0, 64));
		lblUhrzeit.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		lblUhrzeit.setText("[UhrzeitZeitslot]");
		lblUhrzeit.setBounds(113, 193, 122, 20);

		lblWeitereInfos.setBackground(SWTResourceManager.getColor(0, 0, 64));
		lblWeitereInfos.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblWeitereInfos.setAlignment(SWT.CENTER);
		lblWeitereInfos.setText("Weitere Informationen");
		lblWeitereInfos.setFont(SWTResourceManager.getFont("Cascadia Code", 11, SWT.NORMAL));
		lblWeitereInfos.setBounds(0, 0, 261, 20);

	}

	private void initList() {
		list.setEnabled(false);
		list.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		list.setForeground(SWTResourceManager.getColor(255, 255, 255));
		list.setBackground(SWTResourceManager.getColor(64, 0, 64));
		list.setBounds(27, 36, 114, 139);
	}

	/**
	 * D
	 * 
	 * @param a
	 */
	public void setItem(String[] a) {
		this.list.setItems(a);
	}

	private void initButtons() {
		// I. Button
		btnAngabenAnpassen.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		btnAngabenAnpassen.setBounds(47, 359, 137, 30);
		btnAngabenAnpassen.setText("Angaben anpassen");

		// II. Button
		btnTerminBuchen.setForeground(SWTResourceManager.getColor(0, 0, 0));
		btnTerminBuchen.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		btnTerminBuchen.setText("Termin buchen");
		btnTerminBuchen.setBounds(467, 359, 118, 30);

	}

	private void initComposit() {
		// I. Composite
		comp1.setBackground(SWTResourceManager.getColor(64, 0, 64));
		comp1.setBounds(47, 86, 251, 252);

		// II. Composite
		comp2.setBackground(SWTResourceManager.getColor(64, 0, 64));
		comp2.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		comp2.setBounds(324, 86, 261, 252);

	}

	@Override
	public void assignElements() {
		lblBuchungsdetails = new Label(shell, SWT.NONE);
		comp1 = new Composite(shell, SWT.NONE);
		comp2 = new Composite(shell, SWT.NONE);
		lblHundename = new Label(comp2, SWT.NONE);
		lblUhrzeit = new Label(comp2, SWT.NONE);
		lblWeitereInfos = new Label(comp2, SWT.NONE);
		btnAngabenAnpassen = new Button(shell, SWT.NONE);
		btnTerminBuchen = new Button(shell, SWT.NONE);
		lblDatum = new Label(comp2, SWT.NONE);
		lblAm = new Label(comp2, SWT.NONE);
		lblMitarbeitername = new Label(comp2, SWT.NONE);
		lblBeiUnseremMitarbeiter = new Label(comp2, SWT.NONE);
		lblBuchbareDienstleistungen = new Label(comp1, SWT.NONE);
		lblFuerIhrenHund = new Label(comp2, SWT.NONE);
		lblPreisbezeichnung = new Label(comp1, SWT.NONE);
		lblPreis = new Label(comp1, SWT.NONE);
		lblTrennlinie = new Label(comp1, SWT.NONE);
		lblWaehrung = new Label(comp1, SWT.NONE);
		lblUm = new Label(comp2, SWT.NONE);
		list = new List(comp1, SWT.NONE);

	}

	@Override
	public void dispose() {
		lblBuchungsdetails.dispose();
		lblBuchbareDienstleistungen.dispose();
		lblPreisbezeichnung.dispose();
		lblTrennlinie.dispose();
		lblWaehrung.dispose();
		lblFuerIhrenHund.dispose();
		lblUm.dispose();
		lblBeiUnseremMitarbeiter.dispose();
		lblAm.dispose();
		lblWeitereInfos.dispose();
		btnAngabenAnpassen.dispose();
		btnTerminBuchen.dispose();
		comp1.dispose();
		comp2.dispose();
		assignElements();

	}

	public Shell getShell() {
		return shell;
	}

	public Label getLblBuchungsdetails() {
		return lblBuchungsdetails;
	}

	public Label getLblBuchbareDienstleistungen() {
		return lblBuchbareDienstleistungen;
	}

	public void setLblBuchbareDienstleistungen(Label lblBuchbareDienstleistungen) {
		this.lblBuchbareDienstleistungen = lblBuchbareDienstleistungen;
	}

	public Label getLblPreisbezeichnung() {
		return lblPreisbezeichnung;
	}

	public Label getLblTrennlinie() {
		return lblTrennlinie;
	}

	public void setLblTrennlinie(Label lblTrennlinie) {
		this.lblTrennlinie = lblTrennlinie;
	}

	public Label getLblWaehrung() {
		return lblWaehrung;
	}

	public void setLblWaehrung(Label lblWaehrung) {
		this.lblWaehrung = lblWaehrung;
	}

	public Label getLblFuerIhrenHund() {
		return lblFuerIhrenHund;
	}

	public void setLblFuerIhrenHund(Label lblFuerIhrenHund) {
		this.lblFuerIhrenHund = lblFuerIhrenHund;
	}

	public Label getLblUm() {
		return lblUm;
	}

	public void setLblUm(Label lblUm) {
		this.lblUm = lblUm;
	}

	public Label getLblBeiUnseremMitarbeiter() {
		return lblBeiUnseremMitarbeiter;
	}

	public void setLblBeiUnseremMitarbeiter(Label lblBeiUnseremMitarbeiter) {
		this.lblBeiUnseremMitarbeiter = lblBeiUnseremMitarbeiter;
	}

	public Label getLblAm() {
		return lblAm;
	}

	public void setLblAm(Label lblAm) {
		this.lblAm = lblAm;
	}

	public Label getLblWeitereInfos() {
		return lblWeitereInfos;
	}

	public void setLblWeitereInfos(Label lblWeitereInfos) {
		this.lblWeitereInfos = lblWeitereInfos;
	}

	public Button getBtnAngabenAnpassen() {
		return btnAngabenAnpassen;
	}

	public void setBtnAngabenAnpassen(Button btnAngabenAnpassen) {
		this.btnAngabenAnpassen = btnAngabenAnpassen;
	}

	public Button getBtnTerminBuchen() {
		return btnTerminBuchen;
	}

	public void setBtnTerminBuchen(Button btnTerminBuchen) {
		this.btnTerminBuchen = btnTerminBuchen;
	}

	public Composite getComp1() {
		return comp1;
	}

	public void setComp1(Composite comp1) {
		this.comp1 = comp1;
	}

	public Composite getComp2() {
		return comp2;
	}

	public void setComp2(Composite comp2) {
		this.comp2 = comp2;
	}

	public Label getLblPreis() {
		return lblPreis;
	}

	public void setLblPreis(Label lblPreis) {
		this.lblPreis = lblPreis;
	}

	public Label getLblDatum() {
		return lblDatum;
	}

	public void setLblDatum(Label lblDatum) {
		this.lblDatum = lblDatum;
	}

	public Label getLblMitarbeitername() {
		return lblMitarbeitername;
	}

	public void setLblMitarbeitername(Label lblMitarbeitername) {
		this.lblMitarbeitername = lblMitarbeitername;
	}

	public Label getLblHundename() {
		return lblHundename;
	}

	public void setLblHundename(Label lblHundename) {
		this.lblHundename = lblHundename;
	}

	public Label getLblUhrzeit() {
		return lblUhrzeit;
	}

	public void setLblUhrzeit(Label lblUhrzeit) {
		this.lblUhrzeit = lblUhrzeit;
	}

	public List getList() {
		return list;
	}

	public void setList(String[] inhalte) {
		this.list.setItems(inhalte);
	}

}
