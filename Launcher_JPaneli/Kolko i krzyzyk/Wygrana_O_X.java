public class Wygrana_O_X {// Klasa przeszukuj¹ca pola w poszukiwaniu zwyciêzcy.
	
	private Panel_O_X panel;
	private int przylegle, rozmiar, warunek = 3;
	private char znak;

	public Wygrana_O_X() {
	}
	
	private void wygrana_Poziom() {
		for(int y = 0; y < rozmiar; y++) {
			przylegle = 0;
			for(int x = 0; x < rozmiar; x++) {
				if (panel.plansza.pola[x][y].stan == znak) {
					przylegle = przylegle + 1;
				}
				else {
					przylegle = 0; 
				}
				if (przylegle >= warunek) {
					panel.zwyciestwo = true;
				}	
			}
		}
	}
	
	private void wygrana_Pion() {
		for(int x = 0; x < panel.plansza.rozmiar_planszy; x++) {
			przylegle = 0;
			for(int y = 0; y <panel.plansza.rozmiar_planszy; y++) {
				if (panel.plansza.pola[x][y].stan == znak) {
					przylegle++;
				} else {
					przylegle = 0; 
				}		
				if (przylegle >= warunek) 
					panel.zwyciestwo = true;			
			}	
		}	
	}
	
	private void wygrana_Skos1() {
		int startx = 0;
		for(int starty = 2;starty < panel.plansza.rozmiar_planszy ;starty++) {
			int maxprz = 0;
			przylegle = 0;
			int x = startx;
			int y = starty;
			while (x < panel.plansza.rozmiar_planszy && y >= 0) {
				if (panel.plansza.pola[x][y].stan == znak) {
					przylegle++;
					if (przylegle > maxprz)
						maxprz = przylegle;  
				} else {
					przylegle = 0;
				}
				y--;
				x++;
			}
			przylegle = 0;
			y =panel.plansza.rozmiar_planszy - starty - 1;
			x =panel.plansza.rozmiar_planszy - 1;

			while(y <panel. plansza.rozmiar_planszy && x >= 0) {
				if (panel.plansza.pola[x][y].stan == znak) {
					przylegle++;
					if (przylegle > maxprz)
						maxprz = przylegle;
				}
				else {
					przylegle = 0;
				}
				y++;
				x--;
			}
            if (maxprz >= warunek)
            	panel.zwyciestwo = true;	
		}
	}
		
		private void wygrana_Skos2() {
			int starty = 0;
			for(int startx = 0; startx < panel.plansza.rozmiar_planszy - 2; startx++) {
				int maxprz = 0;
				przylegle = 0;
				int x = startx;
				int y = starty;
				
				while (x <panel. plansza.rozmiar_planszy && y <panel.plansza.rozmiar_planszy) {
					if (panel.plansza.pola[x][y].stan == znak) {
						przylegle++;
						if (przylegle > maxprz)
							maxprz = przylegle;
					} else {
						przylegle = 0;
					}		
					y++;
					x++;
				}	
				przylegle = 0;
				y = panel. plansza.rozmiar_planszy - 1;
				x = panel. plansza.rozmiar_planszy - 1 - startx;
			
				while(y < panel.plansza.rozmiar_planszy && x >= 0) {
					if (panel.plansza.pola[x][y].stan == znak) {
						przylegle++;
						if (przylegle > maxprz)
							maxprz = przylegle;
					} else {
						przylegle = 0;
					}
					y--;
					x--;		
				}
	            if (maxprz >= warunek)
	            	panel.zwyciestwo = true;
			}
		}
		
	public void czy_Wygrana(Panel_O_X pan) {
		panel = pan;
		warunek = panel.warunek;
		rozmiar = panel.rozmiar_planszy;
		if(panel.tura % 2 == 0) 
			znak = 'o';
		else 
			znak = 'x';
		wygrana_Poziom();
		wygrana_Pion();
		wygrana_Skos1();
		wygrana_Skos2();
	}
}
