import java.awt.*;

public class Panel_O_X extends Panel {
	private static final long serialVersionUID = 3718180213956352039L;
	
	private final int pocz_rys_x = 150;
	private final int pocz_rys_y = 150;
	
	private GUI_O_X gui;
	protected Wygrana_O_X wygr;
	protected Plansza_O_X plansza;
	private Dimension	rozdzielczosc;
	protected int bok, odstep;
	protected int  pole, rozmiar_planszy = -1, warunek = 3;
	protected int tura = 0;
	protected boolean zwyciestwo = false;
	
	public Panel_O_X() {		
		setBackground(Color.GRAY);
		ustaw_Zmienne();
	    addMouseListener(new Mysz_O_X(this));
	    
		wygr = new Wygrana_O_X();
		gui = new GUI_O_X(this);
		for(short i = 0 ; i < gui.getElementy().length; i++) add(gui.getElementy()[i]);
		
		rozdzielczosc = new Dimension(800, 800);
		setPreferredSize(rozdzielczosc);	
		setLayout(null);
	}
	
	
	public void ustaw_Zmienne() {
		plansza = new Plansza_O_X(rozmiar_planszy);	
		odstep = (int) 50/(rozmiar_planszy);
		bok = (int) 625/rozmiar_planszy - odstep;
	}
	
	public void init_Gry(Graphics g) {
		if(rozmiar_planszy > 2) {
			g.setColor(Color.WHITE);
			for (int x = 0; x < rozmiar_planszy; x++) {
				for (int y = 0; y < rozmiar_planszy; y++) {
					plansza.pola[x][y].poz_x = (int) pocz_rys_x + 20 + x*(bok+odstep);
					plansza.pola[x][y].poz_y = (int) pocz_rys_y + 20 + y*(bok+odstep);
					g.fillRect(plansza.pola[x][y].poz_x, plansza.pola[x][y].poz_y, bok, bok);
					
				}
			}
		}
	}
	
	public void rys_X_O(Graphics g) {	
		if(rozmiar_planszy > 2) {
			g.setColor(Color.BLACK); 
			for (int x = 0; x < rozmiar_planszy; x++) {
				for (int y = 0; y < rozmiar_planszy; y++) {
					if (plansza.pola[x][y].stan == 'x') {
						g.drawLine(plansza.pola[x][y].poz_x, plansza.pola[x][y].poz_y, plansza.pola[x][y].poz_x + bok, plansza.pola[x][y].poz_y + bok);
						g.drawLine(plansza.pola[x][y].poz_x, plansza.pola[x][y].poz_y + bok, plansza.pola[x][y].poz_x + bok, plansza.pola[x][y].poz_y);
					}
					if (plansza.pola[x][y].stan == 'o') {
						g.drawOval(plansza.pola[x][y].poz_x, plansza.pola[x][y].poz_y, bok, bok);
					}
				}
			}
		}
		if(zwyciestwo == true) {
			g.setColor(Color.RED);
	        g.setFont(new Font("Monospaced", Font.PLAIN, 12));
	        g.drawString(("ZWYCIESTWO GRACZA " + ((tura - 1) % 2 + 1)), 10, 200);
		}
		g.setColor(Color.BLUE);
        g.setFont(new Font("Monospaced", Font.PLAIN, 12));	
	}
	
    public void paintComponent(Graphics g) {
    	g.clearRect(0, 0, rozdzielczosc.width, rozdzielczosc.height);
    	g.setColor(Color.LIGHT_GRAY);
    	g.fillRect(0, 0, rozdzielczosc.width, rozdzielczosc.height);  
    	if(zwyciestwo == true) {
    		gui.sta_but.setEnabled(true);
    		gui.res_but.setEnabled(false);
    	}	 
    	init_Gry(g);
    	rys_X_O(g);
  }
}

