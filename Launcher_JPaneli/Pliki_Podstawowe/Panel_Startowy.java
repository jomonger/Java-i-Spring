import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel_Startowy extends Panel {
	private static final long serialVersionUID = -5332575308092550047L;
	private short ilosc_buttonow = 0;
	protected Dimension rozdzielczosc = new Dimension(200, 300); 
	
	Panel_Startowy() {//Panel uruchamiany jako pierwszy, ekran wyboru gier.
		setPreferredSize(rozdzielczosc);
		setLayout(null);
		
		add(new But_Launcher(Panel_Startowy.class, "Launcher"));
		add(new But_Launcher(Panel_O_X.class, "Kó³ko i Krzy¿yk"));
		add(new But_Launcher(Panel_Saper.class, "Saper"));
		add(new But_Launcher(Panel_Weze.class, "Wê¿e"));	
	}
	private class But_Launcher extends Button implements ActionListener {//Buttony uruchamiaj¹ce poszczególne gry/panele.
		private static final long serialVersionUID = -3271723786741007452L;	
		
		Class<?> klasa;
		But_Launcher(Class<?> klasa, String text) {
			super(text);
			this.klasa = klasa;
			ilosc_buttonow++;
			addActionListener(this);
			this.setBounds(55, 50 + 40 * ilosc_buttonow, 90, 30);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			new Okno((Panel)StworzObiektZeStringa.New(klasa));//Tworzenie nowego obiektu po nazwie klasy; refleksja.
		} 
	}
	@Override //Z klasy Panel.
	protected int getClose() {return 3;} // 3 - exit on close.
	@Override
	protected void paintComponent(Graphics g) {
		g.clearRect(0, 0, rozdzielczosc.width, rozdzielczosc.height);
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, rozdzielczosc.width, rozdzielczosc.height);
		g.setColor(Color.GREEN);
		g.setFont(MAIN.F_MONOSPACED_15);
		g.drawString("Launcher R K", 10, 20);
	}
}