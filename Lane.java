import objectdraw.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Image;
import java.util.Random;
import java.util.ArrayList;

public class Lane extends ActiveObject {

  private ArrayList<Vehicle> fleet = new ArrayList<Vehicle>();
  private Image vehicleImg;
  private static final double VEHICLE_HEIGHT = 48;
  private double x;
  private double y;
  private double velo;
  private Frog Richard;
  DrawingCanvas c;
  
  public Lane(Image i, DrawingCanvas c, double xLoc, double yLoc, Frog frogVar) {
    vehicleImg = i;
    this.c = c;
    velo = (Math.random() + 0.2) * -1;
    x = xLoc;
    y = yLoc;
    Richard = frogVar;

    this.start();
  }

  public static void wait(int ms)
  {
      try
      {
          Thread.sleep(ms);
      }
      catch(InterruptedException ex)
      {
          Thread.currentThread().interrupt();
      }
  }
  
  public void run() {
    while(true) {

      fleet.add(new Vehicle(vehicleImg, c, x, y, velo, 650, Richard));
      pause(200);
      //(Image i, DrawingCanvas c, double xLoc, double yLoc, double velocity, int maxDist, Frog frogVar)
      
    }
  }
}
