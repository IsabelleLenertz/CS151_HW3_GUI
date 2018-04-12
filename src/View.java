import java.util.ArrayList;

import javax.swing.JTextArea;

public class View extends JTextArea{
	
	private static final long serialVersionUID = 1L;
	private Model data;
	
	public View(Model newData) {
		data = newData;
		notifyChange();
	}

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
