import objectdraw.*;
import java.awt.event.*;
import java.awt.Color;


public class Main extends WindowController implements KeyListener {

   // Constants defining the sizes of the background components.
   private static final double HIGHWAY_LENGTH = 700;
   private static final double LANE_WIDTH = 70;
   private static final int NUM_LANES = 4;
   private static final double HIGHWAY_WIDTH = LANE_WIDTH * NUM_LANES;
   private static final double LINE_WIDTH = LANE_WIDTH / 10;
   
   // Constants defining the locations of the background components
   private static final double HIGHWAY_LEFT = 0;
   private static final double HIGHWAY_RIGHT = HIGHWAY_LEFT + HIGHWAY_LENGTH;
   private static final double HIGHWAY_TOP = 70;
   private static final double HIGHWAY_BOTTOM = HIGHWAY_TOP + HIGHWAY_WIDTH;
   
   // Constants describing the lines on the highway
   private static final double LINE_SPACING = LINE_WIDTH / 2;
   private static final double DASH_LENGTH = LANE_WIDTH / 3;
   private static final double DASH_SPACING = DASH_LENGTH / 2;

  //State variables
  private Frog richard; 
  private Vehicle car1;
  private Lilypad lily1;
  private Lilypad lily2;
  private Lilypad lily3;
  private Lilypad lily4;
  private Lilypad lily5;
  private Lilypad lily6;
  private Lilypad lily7;
   // This method currently just draws the highway.  You will have to add
   // instructions to create the frog and the Lane ActiveObjects.
  
   
   public static void main(String[] args) { 
   new Main().startController(700,400); 
	} 
   
   public void begin()
   {
       
    
       canvas.addKeyListener(this);
   	
      // Draw the background
      FilledRect highway = new FilledRect (HIGHWAY_LEFT, HIGHWAY_TOP, 
                                           HIGHWAY_LENGTH, HIGHWAY_WIDTH, canvas);
      
      // Draw the lane dividers
      int whichLine = 1;
      while (whichLine < NUM_LANES) {
        if (whichLine == NUM_LANES / 2) {
           // The middle line is a no passing line
           drawNoPassingLine (HIGHWAY_TOP + (whichLine * LANE_WIDTH) - 
                                                       (LINE_SPACING / 2 + LINE_WIDTH));
        }
        else {
            drawPassingLine (HIGHWAY_TOP + (whichLine * LANE_WIDTH) - (LINE_WIDTH / 2));
        }
        whichLine = whichLine + 1;
      }
      
      // ADD YOUR CODE TO CREATE THE FROG AND THE LANES
     car1 = new Vehicle(getImage("Images/taxi_left.gif"), canvas);
     richard = new Frog(getImage("Images/froggy.gif"), canvas);  
     lily1 = new Lilypad(getImage("Images/lily.jpg"), getImage("Images/lilyFrog.jpg"), canvas, 0, richard);
     lily2 = new Lilypad(getImage("Images/lily.jpg"), getImage("Images/lilyFrog.jpg"), canvas, 100, richard);
     lily3 = new Lilypad(getImage("Images/lily.jpg"), getImage("Images/lilyFrog.jpg"), canvas, 200, richard);
     lily4 = new Lilypad(getImage("Images/lily.jpg"), getImage("Images/lilyFrog.jpg"), canvas, 300, richard);
     lily5 = new Lilypad(getImage("Images/lily.jpg"), getImage("Images/lilyFrog.jpg"), canvas, 400, richard);
     lily6 = new Lilypad(getImage("Images/lily.jpg"), getImage("Images/lilyFrog.jpg"), canvas, 500, richard);
     lily7 = new Lilypad(getImage("Images/lily.jpg"), getImage("Images/lilyFrog.jpg"), canvas, 600, richard);
   }
   
   // Draws a pair of solid yellow lines to represent a no passing divider between lanes
   // Parameter:  y - the top of the top line
   // 
   // YOU SHOULD NOT NEED TO MODIFY THIS METHOD
   //
    private void drawNoPassingLine (double y) {
         // Draw the solid dividing lines
      FilledRect topLine = new FilledRect (HIGHWAY_LEFT, y, 
                                           HIGHWAY_LENGTH, LINE_WIDTH, canvas);
      topLine.setColor (Color.yellow);

      FilledRect bottomLine = new FilledRect (HIGHWAY_LEFT, y + LINE_WIDTH + LINE_SPACING,   
                                              HIGHWAY_LENGTH, LINE_WIDTH, canvas);
      bottomLine.setColor (Color.yellow);
   }

   // Draws a dashed white line to represent a passing line dividing two lanes of traffic
   // Parameters:  y - the top of the line.
   // 
   // YOU SHOULD NOT NEED TO MODIFY THIS METHOD
   //
   private void drawPassingLine (double y) {
      double x = HIGHWAY_LEFT;
      FilledRect dash;
      
      while (x < HIGHWAY_RIGHT) {
            // Draw the next dash.
            dash = new FilledRect (x, y, DASH_LENGTH, LINE_WIDTH, canvas);
            dash.setColor (Color.white);
            x = x + DASH_LENGTH + DASH_SPACING;
      }
      
   }
   
   // Note: Use onMousePress rather than onMouseClick to decide when to move the frog
   public void onMousePress(Location point)
   {
   
   }

  public void	keyPressed(KeyEvent e) {
          int key = e.getKeyCode();

    if (key == KeyEvent.VK_LEFT) {
        richard.hops("left");
        lily1.updateLily(canvas, 0);
        lily2.updateLily(canvas, 100);
        lily3.updateLily(canvas, 200);
        lily4.updateLily(canvas, 300);
        lily5.updateLily(canvas, 400);
        lily6.updateLily(canvas, 500);
        lily7.updateLily(canvas, 600);
    }

    if (key == KeyEvent.VK_RIGHT) {
        richard.hops("right");
        lily1.updateLily(canvas, 0);
        lily2.updateLily(canvas, 100);
        lily3.updateLily(canvas, 200);
        lily4.updateLily(canvas, 300);
        lily5.updateLily(canvas, 400);
        lily6.updateLily(canvas, 500);
        lily7.updateLily(canvas, 600);
    }

    if (key == KeyEvent.VK_UP) {
        richard.hops("up");
        lily1.updateLily(canvas, 0);
        lily2.updateLily(canvas, 100);
        lily3.updateLily(canvas, 200);
        lily4.updateLily(canvas, 300);
        lily5.updateLily(canvas, 400);
        lily6.updateLily(canvas, 500);
        lily7.updateLily(canvas, 600);
    }

    if (key == KeyEvent.VK_DOWN) {
        richard.hops("down");
        lily1.updateLily(canvas, 0);
        lily2.updateLily(canvas, 100);
        lily3.updateLily(canvas, 200);
        lily4.updateLily(canvas, 300);
        lily5.updateLily(canvas, 400);
        lily6.updateLily(canvas, 500);
        lily7.updateLily(canvas, 600);
    }
  }
        
  public void	keyReleased(KeyEvent e) {
          
  }
        
  public void	keyTyped(KeyEvent e) {
          
  }         
}
