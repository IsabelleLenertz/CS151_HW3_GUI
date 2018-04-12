import java.util.ArrayList;

/**
 * Store data and list of observers
 * @author isabelle Delmas
 *
 */
public class ModelData {
	private ArrayList<Double> data;
	private ArrayList<Observer> listeners;
	private double max;
	
	/**
	 * Default constructor
	 */
	public ModelData() {
		data = new ArrayList<Double>();
		listeners = new ArrayList<Observer>();
	}
	
	/**
	 * Get the double stored at a specific index
	 * @param i index
	 * @return value stored at i
	 */
	public Double get(int i){
		return this.data.get(i);
	}
	
	/**
	 * number of double stored
	 * @return size of data structure
	 */
	public int size() {
		return data.size();
	}
	
	/**
	 * Return true is empty
	 * @return true is empty
	 */
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	/**
	 * Add a double to the list
	 * @param d
	 */
	public void addData(double d) {
		if (isEmpty() || d > max ) {
			max = d;
		}
		data.add(d);
		notifyListeners();
	}
	
	/**
	 * Get the max value stored
	 * @return max value
	 */
	public double getMax() {
		return max;
	}
	
	/**
	 * update a value at a specific index
	 * @param d new value
	 * @param index index to modify
	 */
	public void update(double d, int index) {
		data.set(index, d);
		notifyListeners();
	}
	
	/**
	 * remove data at an index
	 * @param i index
	 */
	public void remove(int i) {
		data.remove(i);
		notifyListeners();
	}
	
	/**
	 * Add an observer
	 * @param ob observer
	 */
	public void addObserver(Observer ob) {
		listeners.add(ob);
	}
	
	/**
	 * Notifies all the observers of a change
	 */
	private void notifyListeners() {
		for (Observer element : listeners) {
			element.notifyChange();
		}
	}
	
	/**
	 * return a reference to the arrayList of double
	 * @return list of values
	 */
	public ArrayList<Double> getData(){
		return data;
	}
	
}
