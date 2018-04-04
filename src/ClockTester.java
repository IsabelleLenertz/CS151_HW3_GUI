import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClockTester {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
	    frame.setTitle("JLabel Test");
	    frame.setLayout(new FlowLayout());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    ClockIcon clock = new ClockIcon(50, 100, 100);
	    JLabel label = new JLabel(clock);

	    frame.add(label);
	    frame.pack();
	    frame.setVisible(true);

	}

}
