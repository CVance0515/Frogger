import objectdraw.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Image;

public class Vehicle extends ActiveObject{
  
  private VisibleImage vehicleImg;
  private static final double VEHICLE_HEIGHT = 48;
  private double firstTime;
  private double finalTime;
  private double velo;
  private Frog Richard;
  

  public Vehicle(Image i, DrawingCanvas c, double xLoc, double yLoc, double velocity, int maxDist, Frog frogVar) {
    vehicleImg = new VisibleImage(i, new Location(550,70), c);

    velo = velocity;
    Richard = frogVar;
    
    
    this.start();
  }

  public boolean overlaps(VisibleImage frogImg){
    return vehicleImg.overlaps(frogImg);
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
    while(vehicleImg.getX() > -150 && vehicleImg.getX() < 800) {
      firstTime = System.currentTimeMillis();
      wait(30);
      finalTime = System.currentTimeMillis() - firstTime;
     
      double distance = finalTime * velo / 3;
      //System.out.println(distance);
      vehicleImg.move(distance,0);
      // vehicleImg.move(-5,0);
      if(vehicleImg.overlaps(Richard.getVisibleImage())) {
        Richard.die();
        wait(1000);
        
      }
    }
  }
}
