import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BarObserver extends JFrame implements Observer {
	
	private static final long serialVersionUID = 5583964979706887960L;
	private static final int ICON_WIDTH = 300;
	private static final int ICON_HEIGHT = 300;
	private static final int INTERVAL = 5;
	
	ModelData modelData;
	ArrayList<Double> data;
	
	public BarObserver(ModelData dataModel) {
		modelData = dataModel;
		data = modelData.getData();
		
	    setLocation(0,200);
	    setLayout(new BorderLayout());

		
		// Create an icon representing the bars
		Icon barIcon = new Icon() {

			@Override
			public int getIconHeight() {return ICON_HEIGHT;}

			@Override
			public int getIconWidth() {return ICON_WIDTH;}

			@Override
			public void paintIcon(Component component, Graphics g, int x, int y) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.BLUE);
				int dataSize = data.size();
				// Create the rectangles needed to graph			
				for (int i = 0; i < dataSize; i++) {
					double xPosition = i*(ICON_WIDTH/(double)dataSize + INTERVAL);
					double height = data.get(i)*ICON_HEIGHT/modelData.getMax();
					double yPosition = ICON_HEIGHT - height;
					double width =  ICON_WIDTH/(double)dataSize - INTERVAL;					
					Rectangle2D.Double rec = new Rectangle2D.Double(xPosition, yPosition, width ,height);
					g2.fill(rec);
				}
			}
		}; // end of barIcon definition
		
		// Attach the bar icon
		this.add(new JLabel(barIcon));
		
		// Set the Frame visible
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    pack();
	    setVisible(true);
	}

	@Override
	public void notifyChange() {
		data = modelData.getData();
		repaint();
	}

}
