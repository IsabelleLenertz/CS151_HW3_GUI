import java.util.ArrayList;

import javax.swing.JTextArea;

/**
 * View from the MVC pattern
 * @author isabelle Delmas
 *
 */
public class View extends JTextArea{
	
	private static final long serialVersionUID = 1L;
	private Model data;
	
	/**
	 * Constructor with a reference to the data
	 * @param newData model to attach to the view
	 */
	public View(Model newData) {
		data = newData;
		notifyChange();
	}

	/**
	 * Create the TextArea to display using the updated data
	 */
	public void notifyChange() {
		ArrayList<String> text = data.getData();
		String output = "";
		
		for (String t : text) {
			output += t + "\n";
		}
		this.setText(output);
		this.setEditable(false);
	}

}
