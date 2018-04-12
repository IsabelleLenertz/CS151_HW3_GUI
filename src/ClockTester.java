import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Tester for the clock icon
 * @author isabelle delmas
 *
 */
public class ClockTester {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		ClockIcon icon = new ClockIcon(50);
		
		final JLabel label = new JLabel(icon);
		frame.setLayout(new FlowLayout());
		frame.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	    
	    final int DELAY = 1000;
	    Timer t = new Timer(DELAY, event ->  {
	    	label.repaint();
	    });
	    t.start();
	}

}
