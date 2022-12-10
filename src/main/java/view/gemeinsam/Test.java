package view.gemeinsam;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class Test {

	protected Shell shell;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Test window = new Test();
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
		shell.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shell.setSize(649, 489);
		shell.setText("SWT Application");
		shell.setLayout(null);

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(112, 135, 55, 15);
		lblNewLabel.setText("New Label");

		ToolBar toolBar = new ToolBar(shell, SWT.FLAT | SWT.RIGHT);
		toolBar.setBounds(185, 205, 92, 31);

		ToolItem tltmDropdownItem = new ToolItem(toolBar, SWT.DROP_DOWN);
		tltmDropdownItem.setText("Edawda");

	}
}
