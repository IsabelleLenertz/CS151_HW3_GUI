import java.util.ArrayList;

public class ModelData {
	private ArrayList<Double> data;
	private ArrayList<Observer> listeners;
	private double max;
	
	public ModelData() {
		data = new ArrayList<Double>();
		listeners = new ArrayList<Observer>();
	}
	public Double get(int i){
		return this.data.get(i);
	}
	public int size() {
		return data.size();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	public void addData(double d) {
		if (isEmpty() || d > max ) {
			max = d;
		}
		data.add(d);
		notifyListeners();
	}
	
	public double getMax() {
		return max;
	}
	
	public void update(double d, int index) {
		data.set(index, d);
		notifyListeners();
	}
	
	public void remove(int i) {
		data.remove(i);
		notifyListeners();
	}
	
	public void addObserver(Observer ob) {
		listeners.add(ob);
	}
	
	private void notifyListeners() {
		for (Observer element : listeners) {
			element.notifyChange();
		}
	}
	
	public ArrayList<Double> getData(){
		return data;
	}
	
}
