import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Tester for the slider
 * @author Isabelle Delmas
 *
 */
public class SliderTester {

	static final int SIZE_MAX = 150;
	static final int SIZE_MIN = 20;
	static final int SIZE_INIT = 70;
	static final int FRAME_HEIGHT = 200;
	static final int FRAME_WIDTH = 200;
	
	public static void main(String[] args) {
		
		// Create the window
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setSize(FRAME_HEIGHT, FRAME_WIDTH);
		
		
		// Create the car icon
		CarIcon car = new CarIcon(SIZE_MAX);
		final JLabel label = new JLabel(car);
		label.setSize(FRAME_HEIGHT-20, FRAME_WIDTH);
		frame.add(label);
		

		// Create the slider
		JSlider carSize =  new JSlider(JSlider.HORIZONTAL, SIZE_MIN, SIZE_MAX, SIZE_MAX);
		frame.add(carSize);
		carSize.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				// Get a reference to the source of the event
				JSlider source = (JSlider) event.getSource();
				
				// Make sure the user is done moving the slider
				if (!source.getValueIsAdjusting()) {
					car.setWidth((int) source.getValue());
					label.repaint();
				}
				
			}
			
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);

	}

}
