import objectdraw.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.*;

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
  private Lane lane1;
  private Lane lane2;
  private Lane lane3;
  private Lane lane4;
  private ArrayList<Lilypad> lilypads = new ArrayList<Lilypad>();
  
  public static void main(String[] args) { 
    new Main().startController(700,470);
	} 
   
  public void begin(){
    canvas.addKeyListener(this);
   	// Draw the background
    FilledRect highway = new FilledRect (HIGHWAY_LEFT, HIGHWAY_TOP, HIGHWAY_LENGTH, HIGHWAY_WIDTH, canvas);
    // Draw the lane dividers
    int whichLine = 1;
    while (whichLine < NUM_LANES) {
      if (whichLine == NUM_LANES / 2) {
        // The middle line is a no passing line
        drawNoPassingLine (HIGHWAY_TOP + (whichLine * LANE_WIDTH) - (LINE_SPACING / 2 + LINE_WIDTH));
      }
      else {
        drawPassingLine (HIGHWAY_TOP + (whichLine * LANE_WIDTH) - (LINE_WIDTH / 2));
      }
      whichLine = whichLine + 1;
    }
    // ADD YOUR CODE TO CREATE THE FROG AND THE LANES
     
    richard = new Frog(getImage("Images/froggy.gif"), canvas); 
    //car1 = new Vehicle(getImage("Images/taxi_left.gif"), canvas, 550.0, 70.0, -1, 650, richard);
    lane1 = new Lane(getImage("Images/taxi_left.gif"), canvas, 550.0, 70.0, richard);
    lane2 = new Lane(getImage("Images/taxi_left.gif"), canvas, 550.0, 140.0, richard);
    lane3 = new Lane(getImage("Images/taxi_left.gif"), canvas, 550.0, 210.0, richard);
    lane4 = new Lane(getImage("Images/taxi_left.gif"), canvas, 550.0, 280.0, richard);
    for(int i = 0; i < 7; i++){
    lilypads.add(new Lilypad(getImage("Images/lily.jpg"), getImage("Images/lilyFrog.jpg"), canvas, i * 100, richard));
  }
}
  // Draws a pair of solid yellow lines to represent a no passing divider between lanes
  // Parameter:  y - the top of the top line
  // 
  // YOU SHOULD NOT NEED TO MODIFY THIS METHOD
  //
  private void drawNoPassingLine (double y) {
    // Draw the solid dividing lines
    FilledRect topLine = new FilledRect (HIGHWAY_LEFT, y, HIGHWAY_LENGTH, LINE_WIDTH, canvas);
    topLine.setColor (Color.yellow);
    FilledRect bottomLine = new FilledRect (HIGHWAY_LEFT, y + LINE_WIDTH + LINE_SPACING,   HIGHWAY_LENGTH, LINE_WIDTH, canvas);
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
  public void onMousePress(Location point){
   
  }
  public void	keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
      richard.hops("left");
    }
    if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
      richard.hops("right");
    }
    if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
      richard.hops("up");
      for(int i = 0; i < 7; i++){
        lilypads.get(i).updateLily(canvas, i*100);
      }
    }
    if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
      richard.hops("down");
    }
    if (key == KeyEvent.VK_Y) {
        richard.die();
    }
  }
        
  public void	keyReleased(KeyEvent e) {
          
  }
        
  public void	keyTyped(KeyEvent e) {
          
  }         
}
