import java.awt.Dimension;
import java.util.Random;

public class Panel_Saper extends Panel {
	private static final long serialVersionUID = 1386942754361888367L;
	
	private GUI_Saper gui;
	private Random generator;
	protected Dimension rozdzielczosc;
	protected Buttony_Saper[][] pola;
	private int odstep = 20, bok = 20;
	protected int szerokosc, wysokosc, miny, licznik_zwyciestwa = 0, licznik_flag = 0;
	protected boolean czy_pierwszy;

	Panel_Saper() { 
		this.szerokosc = 86;
		this.wysokosc = 48;
		this.miny = 200;
		generator = new Random();
		gui = new GUI_Saper(this);
		for(short i = 0; i < gui.getElementy().length; i++) add(gui.getElementy()[i]);
		
		gui.poddaj_button.setEnabled(false);
		gui.odkryj_button.setEnabled(false);
		
		setLayout(null);
		setPreferredSize(new Dimension (400,300));
	}
	
	Panel_Saper(int szerokosc, int wysokosc, int miny) {
		this.szerokosc = szerokosc;
		this.wysokosc = wysokosc;
		this.miny = miny;

		generator = new Random();
		gui = new GUI_Saper(this);
		for(short i = 0; i < gui.getElementy().length; i++) add(gui.getElementy()[i]);
		setLayout(null);	
		init();
	}
	
	public void init() {
		czy_pierwszy = true;
		pola = new Buttony_Saper[szerokosc][wysokosc]; 
		for(int i = 0; i < szerokosc; i++) {
			for(int j = 0; j < wysokosc; j++) {
				pola[i][j] = new Buttony_Saper(this);
				pola[i][j].setBounds(100 + odstep + i * bok, odstep + j * bok + bok, bok, bok);
				pola[i][j].x = i;
				pola[i][j].y = j;
				add(pola[i][j]);				
			}
		}
		rozdzielczosc = new Dimension((2 * odstep) + 5 + (bok * szerokosc) + 100, (4 * odstep) + (bok * wysokosc) + 15);		
		if(rozdzielczosc.height < 300) rozdzielczosc.height = 300;
		if(rozdzielczosc.width < 400) rozdzielczosc.width = 400;
		
		setPreferredSize(rozdzielczosc);	
		repaint();
	}
	
	public void stworz_Miny(int x, int y) {
		boolean k;
		int minax, minay;
		pola[x][y].czy_mina = true;
		for(int i = 0 ; i < miny ; i++) {
			k = true; 
			while(k) {	
				minax = generator.nextInt(szerokosc);
				minay = generator.nextInt(wysokosc);
				if(pola[minax][minay].czy_mina == false) {
					pola[minax][minay].czy_mina = true;
					if(minax + 1 < szerokosc && minay + 1 < wysokosc)	
						pola[minax + 1][minay + 1].stan++;
					if(minax + 1 < szerokosc && minay - 1 >= 0		)	
						pola[minax + 1][minay - 1].stan++;
					if(minax - 1 >= 0		 && minay + 1 < wysokosc)	
						pola[minax - 1][minay + 1].stan++;
					if(minax - 1 >= 0		 && minay - 1 >= 0		)	
						pola[minax - 1][minay - 1].stan++;
					
					if(minay + 1 < wysokosc )
						pola[minax][minay + 1].stan++; 
					if(minay - 1 >= 0	    )
						pola[minax][minay - 1].stan++; 
					if(minax + 1 < szerokosc) 
						pola[minax + 1][minay].stan++; 
					if(minax - 1 >= 0		) 
						pola[minax - 1][minay].stan++;
					k = false;
				} 
			}		
		}
		pola[x][y].czy_mina = false;
	}

	public void odkryj(Buttony_Saper pole) {
		pole.sprawdzone = true;
		if(pole.czy_odkryty == false) {
			if(pole.czy_mina) {
				 for(int i = 0; i < szerokosc; i++) {
					 for(int j = 0; j < wysokosc; j++) {
						 pola[i][j].setEnabled(false);
					 }
				 }
				setVisible(true);
				pole.setText("!!!");
			} else {
				if(pole.stan == 0) {
					pole.setText("");
					pole.czy_odkryty = true;
					pole.setEnabled(false);
					if(pole.x + 1 < szerokosc && pole.y + 1 < wysokosc && !pola[pole.x + 1][pole.y + 1].sprawdzone)	
						odkryj(pola[pole.x + 1][pole.y + 1]);
					if(pole.x + 1 < szerokosc && pole.y - 1 >= 0       && !pola[pole.x + 1][pole.y - 1].sprawdzone)	
						odkryj(pola[pole.x + 1][pole.y - 1]);
					if(pole.x -1 >= 0	      && pole.y + 1 < wysokosc && !pola[pole.x - 1][pole.y + 1].sprawdzone)	
						odkryj(pola[pole.x - 1][pole.y + 1]);
					if(pole.x -1 >= 0		  && pole.y - 1 >= 0       && !pola[pole.x - 1][pole.y - 1].sprawdzone)	
						odkryj(pola[pole.x - 1][pole.y - 1]);
					
					if(pole.y + 1 < wysokosc  && !pola[pole.x][pole.y + 1].sprawdzone)
						odkryj(pola[pole.x][pole.y + 1]);
					if(pole.y - 1 >= 0	      && !pola[pole.x][pole.y - 1].sprawdzone)
						odkryj(pola[pole.x][pole.y - 1]);
					if(pole.x + 1 < szerokosc && !pola[pole.x + 1][pole.y].sprawdzone)
						odkryj(pola[pole.x + 1][pole.y]);
					if(pole.x - 1 >= 0		  && !pola[pole.x - 1][pole.y].sprawdzone)
						odkryj(pola[pole.x - 1][pole.y]);
				} else {
					pole.setEnabled(false);
					pole.setText(Integer.toString(pole.stan));
					pole.czy_odkryty = true;
				} 
			}	
		}
	}
	
	
}