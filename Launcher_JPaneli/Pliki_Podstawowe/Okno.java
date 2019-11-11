import java.awt.Container;
import javax.swing.JFrame;

public class Okno extends JFrame{
	private static final long serialVersionUID = 1242363695078327910L;
	
	protected Okno(Panel panel) {
				setResizable(true);
				getContentPane();
				Container cp = getContentPane();
				cp.add(panel);
				pack();
				setDefaultCloseOperation(panel.getClose());//2 - JFrame.DISPOSE_ON_CLOSE, 3 - JFrame.EXIT_ON_CLOSE
				setVisible(true);
	}
}
 