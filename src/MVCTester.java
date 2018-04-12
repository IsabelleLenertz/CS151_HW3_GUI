import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MVCTester {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(200, 300);
		
		// Panel to set up the display with a layout
		frame.setLayout(new BorderLayout());
		
		// Create the model that is holding the data (sequence of Strings entered by the user)
		Model data = new Model();
		
		// Create the view, ie the object that displays the data stored in the model
		View view = new View(data);
		data.addView(view);

		// Create the controller, ie the part of the program that gets data from the user and updates the model
		Controller controller = new Controller(data);
		
		
		// Put all the elements together
		//ViewComponent viewC = new ViewComponent(view);
		frame.add(controller, BorderLayout.NORTH);
		frame.add(view, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		

	}

}
