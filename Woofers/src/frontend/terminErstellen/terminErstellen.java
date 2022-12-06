package frontend.terminErstellen;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

public class terminErstellen {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			terminErstellen window = new terminErstellen();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(454, 475);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(1, false));
		
		SashForm sashForm = new SashForm(shell, SWT.NONE);
		
		Composite composite_2 = new Composite(sashForm, SWT.NONE);
		composite_2.setLayout(new GridLayout(1, false));
		
		Label lblNewLabel = new Label(composite_2, SWT.NONE);
		lblNewLabel.setText("Buchbare Dienslteistungen");
		
		Label lblDienstleistung_1 = new Label(composite_2, SWT.NONE);
		lblDienstleistung_1.setText("Waschen / Baden");
		
		Label lblDienstleistung_1_1_1_1 = new Label(composite_2, SWT.NONE);
		lblDienstleistung_1_1_1_1.setText("Massage");
		
		Label lblDienstleistung = new Label(composite_2, SWT.NONE);
		lblDienstleistung.setText("Schneiden");
		
		Label lblDienstleistung_1_1_1 = new Label(composite_2, SWT.NONE);
		lblDienstleistung_1_1_1.setText("Entlausen");
		
		Label lblDienstleistung_1_1 = new Label(composite_2, SWT.NONE);
		lblDienstleistung_1_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		lblDienstleistung_1_1.setText("Entfilzen");
		
		Label lblDienstleistung_1_1_1_1_1 = new Label(composite_2, SWT.NONE);
		lblDienstleistung_1_1_1_1_1.setText("Wählens Sie ihren Hund");
		
		Composite composite_3 = new Composite(sashForm, SWT.NONE);
		composite_3.setLayout(new GridLayout(1, false));
		new Label(composite_3, SWT.NONE);
		
		Button button_1 = new Button(composite_3, SWT.CHECK);
		button_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		
		Button button_1_1 = new Button(composite_3, SWT.CHECK);
		button_1_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_1_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		Button button_1_1_1 = new Button(composite_3, SWT.CHECK);
		button_1_1_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		Button button_1_1_1_1 = new Button(composite_3, SWT.CHECK);
		button_1_1_1_1.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, false, 1, 1));
		button_1_1_1_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		
		Button button = new Button(composite_3, SWT.CHECK);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		Combo combo = new Combo(composite_3, SWT.NONE);
		sashForm.setWeights(new int[] {207, 125});
		
		SashForm sashForm_1 = new SashForm(shell, SWT.NONE);
		
		Composite composite = new Composite(sashForm_1, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		DateTime dateTime = new DateTime(composite, SWT.BORDER | SWT.CALENDAR);
		
		Composite composite_1 = new Composite(sashForm_1, SWT.NONE);
		composite_1.setLayout(new GridLayout(1, false));
		
		Button btnNewButton = new Button(composite_1, SWT.NONE);
		btnNewButton.setText("New Button");
		
		Button btnNewButton_1 = new Button(composite_1, SWT.NONE);
		btnNewButton_1.setText("New Button");
		
		Button btnNewButton_1_1 = new Button(composite_1, SWT.NONE);
		btnNewButton_1_1.setText("New Button");
		
		Button btnNewButton_1_1_1 = new Button(composite_1, SWT.NONE);
		btnNewButton_1_1_1.setText("New Button");
		
		Button btnNewButton_1_1_2 = new Button(composite_1, SWT.NONE);
		btnNewButton_1_1_2.setText("New Button");
		
		Button btnNewButton_1_1_3 = new Button(composite_1, SWT.NONE);
		btnNewButton_1_1_3.setText("New Button");
		sashForm_1.setWeights(new int[] {174, 114});
		
		
	}
}
