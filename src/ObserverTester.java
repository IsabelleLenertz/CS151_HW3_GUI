
public class ObserverTester {

	public static void main(String[] args) {
		// Create a data model
		ModelData data = new ModelData();
		data.addData(5.2);
		data.addData(5.6);
		data.addData(0);
		
		// Attach it to a controller
		ControllerTextFields textFields = new ControllerTextFields(data);
		
		data.addObserver(new BarObserver(data));
		
		
	}

}
