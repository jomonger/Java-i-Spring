public class Plansza_O_X { // Opis planszy z wewn�trzn� klas� pole. 
	
	protected int rozmiar_planszy;
	protected int ilosc_pol;
	protected Pole_O_X[][] pola;
	private int x, y;
	
	public Plansza_O_X(int roz) {
		rozmiar_planszy = roz;
		ilosc_pol = rozmiar_planszy * rozmiar_planszy;
		if(rozmiar_planszy > 1) {
			pola = new Pole_O_X[rozmiar_planszy][rozmiar_planszy];			
			for (x = 0; x < rozmiar_planszy; x++) {
				for (y = 0; y < rozmiar_planszy; y++) {
					pola[x][y] = new Pole_O_X(x, y);
				}
			}
		}
	} 
	
	public class Pole_O_X {
		char stan = ' '; 
		int poz_x, poz_y;
		
		public Pole_O_X(int pozx, int pozy) {
			poz_y = pozy;
			poz_x = pozx;
		}
	}	
}