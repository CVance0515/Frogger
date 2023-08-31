import objectdraw.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Image;

public class Vehicle {
  
  private VisibleImage vehicleImg;
  private static final double VEHICLE_HEIGHT = 48;

  public Vehicle(Image i, DrawingCanvas c){
    vehicleImg = new VisibleImage(i, new Location(550,100), c);
  }
  /*
  public boolean overlaps(VisibleImage vehicleImg){
    return vehicleImg.overlaps(vehicleImg);
  }
  */
}