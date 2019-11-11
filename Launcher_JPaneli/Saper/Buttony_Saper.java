import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

class Buttony_Saper extends JButton {
		private static final long serialVersionUID = 7469882051996330098L;
		
		private int flaga;
		protected boolean czy_odkryty = false,  czy_mina,  sprawdzone = false; 
		protected int stan, x, y;
		protected Panel_Saper panel;
		
		public Buttony_Saper(Panel_Saper panel) {
			this.setFont(new Font("Arial", Font.BOLD, 20));
			this.setMargin(new Insets(0,0,0,0));
			this.setText("");	
			flaga = 0;
			stan = 0;
			this.panel = panel;

			this.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					if (SwingUtilities.isLeftMouseButton(e)) {
						if(panel.czy_pierwszy == true) {
							panel.stworz_Miny(x, y);
							panel.czy_pierwszy = false;
						} 
						if(flaga == 0) { 
							panel.setVisible(false);
							panel.odkryj(panel.pola[x][y]);
							panel.setVisible(true);
						}	
					}

                    if (SwingUtilities.isRightMouseButton(e)) {
                    	if(czy_odkryty == false) {  
	                        if (flaga == 0) {
	                        	setText("F");
	                        	panel.licznik_flag++;
	                        	if(czy_mina) {
	                        		panel.licznik_zwyciestwa++;
	                        		if(panel.licznik_zwyciestwa == panel.miny && panel.licznik_zwyciestwa == panel.licznik_flag) 
	                        			JOptionPane.showMessageDialog(null, "wygrana!");
	                        	}
	                        	flaga = 1;
	                        } else if (flaga == 1) {
	                        	setText("?");
	                        	
	                        	if(czy_mina) {
	                        		panel.licznik_zwyciestwa--;
	                        	}
	                        	flaga = 2;
	                        } else if (flaga == 2) {   	
	                        	panel.licznik_flag--;
	                        	setText("");
	                        	if(panel.licznik_zwyciestwa == panel.miny && panel.licznik_zwyciestwa == panel.licznik_flag) 
	                        		JOptionPane.showMessageDialog(null, "wygrana!");
	                        	flaga = 0;
	                        }
                    	}
                    }
                }
			});
		}
		
	}