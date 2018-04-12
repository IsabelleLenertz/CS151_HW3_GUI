import java.awt.Button;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Controller extends JPanel{

	private static final long serialVersionUID = 1L;
	private Button addBtn;
	private JTextField text;
	private Model data;

	public Controller(Model model) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Set link to the data
		data = model;
		
		// Create the elements need to control the data
		addBtn = new Button("Add");
		text = new JTextField();
		text.setText("Enter some text");
		text.setEditable(true);
		
		this.add(text);
		this.add(addBtn);
		
		// Create the listener
		addBtn.addActionListener(e -> {
			data.addText(text.getText());
			text.setText("");
		});
		
		
		
	}
}
