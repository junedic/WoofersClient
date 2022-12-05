package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class Hauptfenster implements View {

	private Shell 	shell;
	private Label 	terminal;
	private Button 	createAppointment;
	private Button 	deleteAppointment;
	private Button 	appointmentCustomer;
	private Button 	appointmentEmployee;
	private Button 	editCustomer;
	
	public Hauptfenster() {
		initShell();
		initTerminal();
		initButtons();
	}

	private void initShell() {
		shell = new Shell();
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
		terminal = new Label(shell, SWT.NONE);
		terminal.setAlignment(SWT.CENTER);
		terminal.setForeground(SWTResourceManager.getColor(255, 255, 255));
		terminal.setFont(SWTResourceManager.getFont("Eras Demi ITC", 22, SWT.NORMAL));
		terminal.setBackground(SWTResourceManager.getColor(64, 0, 128));
		terminal.setBounds(91, 75, 370, 37);
		terminal.setText("wOOfers TERMINAL");
	}

	private void initButtons() {
		createAppointment = new Button(shell, SWT.NONE);
		createAppointment.setForeground(SWTResourceManager.getColor(64, 0, 64));
		createAppointment.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		createAppointment.setBounds(143, 143, 122, 37);
		createAppointment.setText("Termin erstellen");

		deleteAppointment = new Button(shell, SWT.NONE);
		/*
		deleteAppointment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
				Termin_Eingabe.main(null);
			}
		});
		*/
		deleteAppointment.setText("Termin l\u00F6schen");
		deleteAppointment.setForeground(SWTResourceManager.getColor(64, 0, 64));
		deleteAppointment.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		deleteAppointment.setBounds(269, 143, 122, 37);

		appointmentEmployee = new Button(shell, SWT.NONE);
		appointmentEmployee.setText("Terminliste von Mitarbeiter ausgeben");
		appointmentEmployee.setForeground(SWTResourceManager.getColor(64, 0, 64));
		appointmentEmployee.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		appointmentEmployee.setBounds(143, 186, 248, 37);

		appointmentCustomer = new Button(shell, SWT.NONE);
		appointmentCustomer.setText("Terminliste von Kunden ausgeben");
		appointmentCustomer.setForeground(SWTResourceManager.getColor(64, 0, 64));
		appointmentCustomer.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		appointmentCustomer.setBounds(143, 229, 248, 37);

		editCustomer = new Button(shell, SWT.NONE);
		/*
		editCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
				KundenNr_Eingabe.main(null);
			}
		});
		 */
		editCustomer.setText("Kundenprofil bearbeiten");
		editCustomer.setForeground(SWTResourceManager.getColor(64, 0, 64));
		editCustomer.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		editCustomer.setBounds(143, 272, 248, 37);
	}

	public Shell getShell() {
		return shell;
	}

	public Label getTerminal() {
		return terminal;
	}

	public Button getCreateAppointment() {
		return createAppointment;
	}

	public Button getDeleteAppointment() {
		return deleteAppointment;
	}

	public Button getAppointmentCustomer() {
		return appointmentCustomer;
	}

	public Button getAppointmentEmployee() {
		return appointmentEmployee;
	}

	public Button getEditCustomer() {
		return editCustomer;
	}

	public void dispose() {
		terminal.dispose();
		createAppointment.dispose();
		deleteAppointment.dispose();
		appointmentCustomer.dispose();
		appointmentEmployee.dispose();
		editCustomer.dispose();
	}
}
