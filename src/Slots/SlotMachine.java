package Slots;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SlotMachine {
	Display display;
	protected Shell shlSlotMachine;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text txtTitle;
	private Text txtCrediti;
	private Text txtBet;
	private Text txtVincita;

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
		display = Display.getDefault();
		createContents();
		shlSlotMachine.open();
		shlSlotMachine.layout();
		while (!shlSlotMachine.isDisposed()) {
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
		
		private int nGirandola;
		
		public ThreadGirandola(int nGirandola){
			this.nGirandola = nGirandola;
		}
		
		public void run() {
			cambiaImmagine(nGirandola,2);
		}
	}

	public void gira() {
		ThreadGirandola t1 = new ThreadGirandola(1);
		ThreadGirandola t2 = new ThreadGirandola(2);
		ThreadGirandola t3 = new ThreadGirandola(3);
		t1.start();
		t2.start();
		t3.start();
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
		for(int i=0;i<10;i++){
			System.out.println("Ciao da girandola numero " + girandola);
			int randSleep = (int)((Math.random() * 50) + 50);
			try {
				Thread.sleep(randSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
		shlSlotMachine = new Shell();
		shlSlotMachine.setSize(500, 500);
		shlSlotMachine.setText("Slot Machine");
		

		Composite compositeTop = new Composite(shlSlotMachine, SWT.NONE);
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

		Composite compositeBottoni = new Composite(shlSlotMachine, SWT.NONE);
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
				gira();
			}
		});
		btnGira.setLocation(389, 10);
		btnGira.setSize(75, 75);
		btnGira.setText("Gira");
		btnGira.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		
		Label lblGirandola1 = new Label(shlSlotMachine, SWT.BORDER | SWT.WRAP | SWT.SHADOW_NONE | SWT.CENTER);
		lblGirandola1.setBounds(10, 75, 150, 150);
		formToolkit.adapt(lblGirandola1, true, true);
		lblGirandola1.setText("Immagine1");
		
		Label lblGirandola2 = new Label(shlSlotMachine, SWT.BORDER | SWT.WRAP | SWT.SHADOW_NONE | SWT.CENTER);
		lblGirandola2.setText("Immagine2");
		lblGirandola2.setBounds(168, 75, 150, 150);
		formToolkit.adapt(lblGirandola2, true, true);
		
		Label lblGirandola3 = new Label(shlSlotMachine, SWT.BORDER | SWT.WRAP | SWT.SHADOW_NONE | SWT.CENTER);
		lblGirandola3.setText("Immagine3");
		lblGirandola3.setBounds(324, 75, 150, 150);
		formToolkit.adapt(lblGirandola3, true, true);
		
		txtCrediti = new Text(shlSlotMachine, SWT.BORDER | SWT.READ_ONLY | SWT.CENTER);
		txtCrediti.setText("Crediti");
		txtCrediti.setBounds(10, 281, 150, 21);
		formToolkit.adapt(txtCrediti, true, true);
		
		Label lblCrediti = new Label(shlSlotMachine, SWT.NONE);
		lblCrediti.setBounds(10, 260, 150, 15);
		formToolkit.adapt(lblCrediti, true, true);
		lblCrediti.setText("Crediti");
		
		txtBet = new Text(shlSlotMachine, SWT.BORDER);
		txtBet.setText("Bet");
		txtBet.setBounds(210, 281, 76, 21);
		formToolkit.adapt(txtBet, true, true);
		
		Label lblBet = new Label(shlSlotMachine, SWT.NONE);
		lblBet.setBounds(210, 260, 76, 15);
		formToolkit.adapt(lblBet, true, true);
		lblBet.setText("Bet");
		
		txtVincita = new Text(shlSlotMachine, SWT.BORDER);
		txtVincita.setText("Vincita");
		txtVincita.setBounds(324, 281, 150, 21);
		formToolkit.adapt(txtVincita, true, true);
		
		Label lblPossibileVincita = new Label(shlSlotMachine, SWT.NONE);
		lblPossibileVincita.setBounds(324, 260, 150, 15);
		formToolkit.adapt(lblPossibileVincita, true, true);
		lblPossibileVincita.setText("Possibile vincita");

	}
}
