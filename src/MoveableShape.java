/**
 * Author: Cay Horstmann, Object-Oriented Design & Patterns 3rd edition
 */

import java.awt.*;

/**
   A shape that can be moved around.
*/
public interface MoveableShape
{
   /**
      Draws the shape.
      @param g2 the graphics context
   */
   void draw(Graphics2D g2);
   /**
      Moves the shape.
      It is up to the shape to move itself, for example by tracking the time since 
      its last movement, its position, and velocity.
   */
   void move();
   
   /**
    * Get the x position of the upper left corner of the shape
    * @return x position of the shape
    */
   int getX();
   
   /**
    * Define a new X position for the shape
    * @param xPosition new x position of the shape
    */
   void setX(int xPosition);
}