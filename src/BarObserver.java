import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BarObserver extends JFrame implements Observer {
	
	private static final long serialVersionUID = 5583964979706887960L;
	private static final int ICON_WIDTH = 300;
	private static final int ICON_HEIGHT = 300;
	
	ModelData modelData;
	
	/**
	 * Constructor that attaches a model
	 * @param dataModel data to display
	 */
	public BarObserver(ModelData dataModel) {
		modelData = dataModel;
		
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
				ArrayList<Double> data = modelData.getData();
				
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.BLUE);
				int dataSize = data.size();
				// Create the rectangles needed to graph			
				for (int i = 0; i < dataSize; i++) {
					double xPosition = i*(ICON_WIDTH/(double)dataSize);
					double height = data.get(i)*ICON_HEIGHT/modelData.getMax();
					double yPosition = ICON_HEIGHT - height;
					double width =  ICON_WIDTH/(double)dataSize;					
					Rectangle2D.Double rec = new Rectangle2D.Double(xPosition, yPosition, width ,height);
					g2.fill(rec);
				}
			}
		}; // end of barIcon definition
		
		// Attach the bar icon
		JLabel label = new JLabel(barIcon);
		JPanel panel = new JPanel();
		panel.add(label);
		
		panel.addMouseListener( new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) { // do nothing 
			}
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				int barWidth = ICON_WIDTH/modelData.size();
				int barNumber = x/barWidth;
							
				double height = ICON_HEIGHT - y;
				double yValue = height*modelData.getMax()/ICON_HEIGHT;
				
				modelData.update(yValue, barNumber);
								
			}

			@Override
			public void mouseReleased(MouseEvent e) { // do nothing
				
			}
			@Override
			public void mouseEntered(MouseEvent e){ // do nothing
				
			}
			@Override
			public void mouseExited(MouseEvent e) { // do nothing 
				
			}
			
		});
		
		this.add(panel);
		
		
		// Set the Frame visible
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    pack();
	    setVisible(true);
	}

	/**
	 * Notify all the observers of a change
	 */
	@Override
	public void notifyChange() {
		repaint();
	}

}
