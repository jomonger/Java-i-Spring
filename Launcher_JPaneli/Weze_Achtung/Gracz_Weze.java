import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gracz_Weze implements KeyListener{// Definicja gracza w grze Wê¿e.
	
	private Color kolor;
	private short ilosc_ptk = 0;
	private float predkosc, pozycjax, pozycjay, grubosc, kat,poz_x_pop, poz_y_pop;
	private boolean lewo = false, prawo = false, czy_zyje = true, kolizja = false;
	protected char lewo_znak , prawo_znak;
	
	Gracz_Weze (Color kolor) {
		this.kolor = kolor;
	}
	
	public void nowaPozycja() { // Obliczenie nowego po³o¿enia œrodka g³owy wê¿a.
		
		//obliczanie nowego k¹ta
		if(this.lewo == true && this.prawo == true)/*pass*/ {
    	} else if (lewo == true) {
    		this.kat += 3;
    	} else if (prawo == true) {
    		this.kat -= 3;
    	}     
		this.kat %=360;
		
		setPozycjax((float) (getPoz_x_pop() + this.predkosc * Math.sin(this.kat * Math.PI/180)));
		setPozycjay((float) (getPoz_y_pop() + this.predkosc * Math.cos(this.kat * Math.PI/180)));		     
	}

	public void setPredkosc(float predkosc) {
		this.predkosc = predkosc;
	}
		
	public void setLewo(boolean lewo) {
		this.lewo = lewo; 
	}
	
	public void setPrawo(boolean prawo) {
		this.prawo = prawo;
	}

	public void setKat(float kat) {
		this.kat = kat;
	}
	
	public void setGrubosc(float grubosc) {
		this.grubosc = grubosc;
	}
	
	public void setIlosc_ptk(short ilosc_ptk) {
		this.ilosc_ptk = ilosc_ptk;
	}
	
	public boolean czyZyje() {
		return czy_zyje;
	}

	public void setCzy_zyje(boolean czy_zyje) {
		this.czy_zyje = czy_zyje;
	}

	public float getKat(){
		return kat;
	}
	
	public float getGrubosc() {
		return grubosc;
	}
	
	public short getIlosc_ptk() {
		return ilosc_ptk;
	}

	@Override
	public void keyTyped(KeyEvent es) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent es) {
		if (es.getKeyChar() == this.lewo_znak ) {
			this.setLewo(true);
		}
		if (es.getKeyChar() == this.prawo_znak ) {
			this.setPrawo(true);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent es) {
		if (es.getKeyChar() == this.lewo_znak ) {
			this.setLewo(false);
		}
		if (es.getKeyChar() == prawo_znak ) {
			this.setPrawo(false);
		}
	}

	public float getPoz_y_pop() {
		return poz_y_pop;
	}

	public void setPoz_y_pop(float poz_y_pop) {
		this.poz_y_pop = poz_y_pop;
	}

	public float getPoz_x_pop() {
		return poz_x_pop;
	}

	public void setPoz_x_pop(float poz_x_pop) {
		this.poz_x_pop = poz_x_pop;
	}

	public Color getKolor() {
		return kolor;
	}

	public float getPozycjax() {
		return pozycjax;
	}

	public void setPozycjax(float pozycjax) {
		this.pozycjax = pozycjax;
	}

	public float getPozycjay() {
		return pozycjay;
	}

	public void setPozycjay(float pozycjay) {
		this.pozycjay = pozycjay;
	}

	public boolean getKolizja() {
		return kolizja ;
	}

	public void setKolizja(boolean b) {
		this.kolizja = b;
	}

}

