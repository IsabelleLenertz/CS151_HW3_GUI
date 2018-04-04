import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import javax.swing.Icon;

public class ClockIcon implements Icon {
	
	private int radius;
	private int centerx;
	private int centery;
	
	private int DEGREES = 360;
	private int MINUTES_IN_HOUR = 60;
	private int HOURS_IN_HALF_DAY = 12;
	private int SECONDS_IN_MINUTE = 60;
	
	public ClockIcon(int theRadius, int x, int y) {
		this.radius = theRadius;
		this.centerx = x;
		this.centery = y;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// Convert g to 2d graphics
		Graphics2D g2 = (Graphics2D) g;
		
		// Get the current time
		GregorianCalendar time = (GregorianCalendar) getTodayCalifornianCalendar();
		int hours = time.get(Calendar.HOUR);
		int minutes = time.get(Calendar.MINUTE);
		int seconds = time.get(Calendar.SECOND);

		// Draw a circle representing the clock
		Ellipse2D.Double frame = new Ellipse2D.Double(centerx - radius, centery-radius, radius*2, radius*2);
		g2.draw(frame);
		
		// Draw the hour hand
		double hourAngle = (hours*MINUTES_IN_HOUR + minutes)*DEGREES/(HOURS_IN_HALF_DAY*MINUTES_IN_HOUR);
		Line2D.Double hoursHand = new Line2D.Double(x, y, x+Math.cos(Math.toRadians(hourAngle))*radius, y+Math.sin(Math.toRadians(hourAngle))*radius);
		g2.draw(hoursHand);
		
		// Draw the minutes hand
		double minuteAngle = minutes*DEGREES/MINUTES_IN_HOUR;
		Line2D.Double minutesHand = new Line2D.Double(x, y, x + Math.cos(Math.toRadians(minuteAngle))*radius, y + Math.sin(Math.toRadians(minuteAngle))*radius);
		g2.draw(minutesHand);
		
		// Draw the second hand
		double secondAngle = seconds*DEGREES/SECONDS_IN_MINUTE;
		Line2D.Double secondHand = new Line2D.Double(x, y, x + Math.cos(Math.toRadians(secondAngle))*radius, y + Math.sin(Math.toRadians(secondAngle))*radius);
		g2.draw(secondHand);
		

	}
	
	/**
	 * Get a Gregorian calendar setup with the pacific time zone and the daylight saving time
	 * the day is today and the time is the time of the run
	 * Helper function for main()
	 * @return today's calendar
	 */
	private Calendar getTodayCalifornianCalendar() {
		 // Get local time zone for California (Pacific Standard Time)
		 String[] timeZoneId = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);
		 // if no timeZone was returned, exit program.
		 if (timeZoneId.length == 0) {
		     System.out.println("Could not initiate the time zone, exiting program");
			 System.exit(0);
		 }
		 SimpleTimeZone pacificTimeZone = new SimpleTimeZone(-8 * 60 * 60 * 1000, timeZoneId[0]);
		
		 // Set up rules for Daylight Saving Time
		 pacificTimeZone.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
		 pacificTimeZone.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
		
		 // create a GregorianCalendar with the Pacific Daylight time zone and the current date and time
		 Calendar calendar = new GregorianCalendar(pacificTimeZone);
		 Date runTime = new Date();
		 calendar.setTime(runTime);
		 
		 return calendar;
	}

	@Override
	public int getIconWidth() {
		return this.radius*2;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return this.radius*2;
	}

}
