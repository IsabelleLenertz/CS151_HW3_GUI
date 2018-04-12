import javax.swing.JPanel;

public class ViewComponent extends JPanel{

	private static final long serialVersionUID = 1L;
	private View view;
	
	public ViewComponent(View newView) {
		view = newView;
		this.add(view);
	}
}
