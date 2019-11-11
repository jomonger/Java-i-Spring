import java.awt.Window;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public abstract class Panel extends JPanel {
	private static final long serialVersionUID = 813471686919109241L;
	
	protected int getClose() {return JFrame.DISPOSE_ON_CLOSE;} 
	public void zamknijOkno() {
		JComponent comp = (JComponent) this;
		Window win = SwingUtilities.getWindowAncestor(comp);
		win.dispose();
	}
}
	
	
	

