package Slots;

import java.awt.Graphics;


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Canvas;

public class SlotMachine {
	Display display;
	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SlotMachine window = new SlotMachine();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
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
		shell.setSize(450, 560);
		shell.setText("SWT Application");
		
		Label lblNewLabel = formToolkit.createLabel(shell, "New Label", SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg"));
		lblNewLabel.setBounds(10, 50, 414, 154);
		
		Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.setBounds(81, 288, 222, 181);
		formToolkit.adapt(canvas);
		formToolkit.paintBordersFor(canvas);
		
		
		
		final Image image = new Image(display,"Z:\\slot.jpg");
		final int width = image.getBounds().width;
	    final int height = image.getBounds().height;
		
		canvas.addPaintListener(new PaintListener() {
	        public void paintControl(PaintEvent e) {
	         e.gc.drawImage(image,0,0,width,height,0,0,(int)(width*1.0),(int)(height*1.0));
	        }
	    });

	}
}
