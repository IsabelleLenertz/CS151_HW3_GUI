import java.util.ArrayList;

public class Model {
	ArrayList<String> texts;
	ArrayList<View> views;
	
	public Model() {
		texts = new ArrayList<String>();
		views = new ArrayList<View>();
	}
	
	public void addText(String newText) {
		texts.add(newText);
		notifyChange();
	}
	
	public void addView(View newView) {
		views.add(newView);
	}
	
	public void notifyChange() {
		for(View element : views) {
			element.notifyChange();
		}
	}
	
	public ArrayList<String> getData(){
		return this.texts;
	}

}
