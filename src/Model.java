import java.util.ArrayList;

/**
 * Model from the MVC pattern
 * @author isabelle Delmas
 *
 */
public class Model {
	ArrayList<String> texts;
	ArrayList<View> views;
	
	/**
	 * default constructor
	 */
	public Model() {
		texts = new ArrayList<String>();
		views = new ArrayList<View>();
	}
	
	/**
	 * add some text to the data
	 * @param newText text to add
	 */
	public void addText(String newText) {
		texts.add(newText);
		notifyChange();
	}
	
	/**
	 * Add a view to display the data
	 * @param newView view to display data
	 */
	public void addView(View newView) {
		views.add(newView);
	}
	
	/**
	 * Notify all the views that a change has been made
	 */
	public void notifyChange() {
		for(View element : views) {
			element.notifyChange();
		}
	}
	
	/**
	 * Get access to the data
	 * @return a reference to the data
	 */
	public ArrayList<String> getData(){
		return this.texts;
	}

}
