import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.event.*;

public class ControllerTextFields extends JFrame{

	private static final long serialVersionUID = -3773576483006388533L;
	private JTextField fields[];
	private ModelData data;
	private static final int FIELD_WIDTH = 50;

	
	public ControllerTextFields(ModelData modelData) {
		this.setSize(150,  150);
		data = modelData;
		
		// Set the layout (Vertical display of all the text frames)
	    final Container container = this.getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		// Create the change listener for the text fields
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Find which field was activated
				JTextField field = (JTextField) e.getSource();
				
				// Get the index of the field
				int index = 0;
				while(index < fields.length && field != fields[index]) {
					index++;
				}
				
				// Update the appropriate data field
				Double d;
				try{
					d = Double.parseDouble(field.getText());
					data.update(d,  index);
				} catch (Exception err) {
					field.setText(err.getMessage());
				}
				
			}
			
		};
		
		// Populate the initial text with the data in the model
		fields = new JTextField[data.size()];
		for (int i = 0; i < data.size(); i++) {
			fields[i] = new JTextField("" + data.get(i), FIELD_WIDTH);
			fields[i].addActionListener(listener);
			this.add(fields[i]);
		}
		
		// Set the Frame visible
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    pack();
	    setVisible(true);
		
	}
	
	
}
