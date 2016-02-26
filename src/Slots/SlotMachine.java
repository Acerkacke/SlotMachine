package Slots;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class SlotMachine {

	protected Shell shell;
	private Text txtTitle;

	/**
	 * Launch the application.
	 * 
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

	public void giraImmagini() {
		// TODO Fedato - Far cambiare le tre immagini a caso (senza animazione)
		/*
		 * Quello che avevo in mente era tipo
		 * 
		 * int random = 0; random = random(); //Random tra 0 e numero delle
		 * immagini
		 * 
		 */
	}

	public class ThreadGirandola extends Thread {
		public void run() {
			cambiaImmagine(1,3);
			cambiaImmagine(2,3);
			cambiaImmagine(3,3);
		}
	}

	public void gira() {

	}

	/**
	 * @param girandola
	 *            Di quale ruota cambiare l'immagine
	 * @param indexImmagine
	 *            Qual'è la posizione dell'immagine da prendere sulla lista
	 *            delle immagini
	 */
	private void cambiaImmagine(int girandola, int indexImmagine) {
		girandola-=1; //Così possiamo usare girandola 1-2-3 e non 0-1-2
		
		// TODO Fedato - Cambia immagine di una delle tre girandole
		
		  //for(int i=0;i<Numero di rotazioni che deve fare (a caso tipo);i++){
		    //random così sembra uno shuffle casiale 
		    //int random = random();
		  	//OggettoGirandola[girandola].immagine = listaImmagini[random]; 
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  //}
		  //alla fine impostiamo l'immagine quella finale
		  //OggettoGirandola[girandola].immagine = listaImmagini[indexImmagine];
		 
	}

	/**
	 * 
	 * @return Un numero random che rappresenta una immagine (0-numeroImmagini)
	 */
	public static int random() {
		// return (int)(Math.Random() * listaImmagini.Length);
		return 0;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(500, 500);
		shell.setText("SWT Application");

		Composite compositeTop = new Composite(shell, SWT.NONE);
		compositeTop.setBounds(10, 10, 464, 58);

		txtTitle = new Text(compositeTop, SWT.SINGLE | SWT.READ_ONLY | SWT.BORDER | SWT.CENTER);
		;
		txtTitle.setText("\n\nSlot Machine");
		txtTitle.setBounds(0, 0, 464, 58);

		// TODO Wassim - mettere le tre immagini e salvarle
		/*
		 * Spazio per wassim
		 * 
		 * 
		 * 
		 */

		Composite compositeBottoni = new Composite(shell, SWT.NONE);
		compositeBottoni.setBounds(10, 350, 464, 100);

		Button btnReset = new Button(compositeBottoni, SWT.NONE);
		btnReset.setLocation(0, 10);
		btnReset.setSize(75, 75);
		btnReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnReset.setText("Reset");

		Button btnRitira = new Button(compositeBottoni, SWT.CENTER);
		btnRitira.setLocation(90, 10);
		btnRitira.setSize(75, 75);
		btnRitira.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnRitira.setText("Ritira");

		Button btnScommettiUno = new Button(compositeBottoni, SWT.CENTER);
		btnScommettiUno.setLocation(180, 10);
		btnScommettiUno.setSize(75, 75);
		btnScommettiUno.setText("Scommetti");
		btnScommettiUno.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));

		Button btnScommettiMax = new Button(compositeBottoni, SWT.CENTER);
		btnScommettiMax.setLocation(270, 10);
		btnScommettiMax.setSize(75, 75);
		btnScommettiMax.setText("Max");
		btnScommettiMax.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));

		Button btnGira = new Button(compositeBottoni, SWT.CENTER);
		btnGira.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnGira.setLocation(389, 10);
		btnGira.setSize(75, 75);
		btnGira.setText("Gira");
		btnGira.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));

	}

}
