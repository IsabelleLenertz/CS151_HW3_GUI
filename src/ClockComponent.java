import java.awt.Graphics;

import javax.swing.JComponent;

public class ClockComponent extends JComponent {

	private static final long serialVersionUID = -2538974427648063255L;
	private ClockIcon clock;
	private int x;
	private int y;
	
	public ClockComponent(int radius, int xPosition, int yPosition) {
		clock = new ClockIcon(radius);
		x = xPosition;
		y = yPosition;
	}
	
	public void pointComponent(Graphics g) {
		super.paintComponent(g);
		clock.paintIcon(this, g, x, y);
	}

}
