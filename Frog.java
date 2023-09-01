import objectdraw.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Image;

public class Frog {
  
  private VisibleImage frogImg;
  private static final double FROG_HEIGHT = 48;

  public Frog(Image i, DrawingCanvas c){
    frogImg = new VisibleImage(i, new Location(10,10), c);
  }
  public boolean overlaps(VisibleImage vehicleImg){
    return frogImg.overlaps(vehicleImg);
  }
  public void hops(String direction){
    if(direction="left"){
      if(frogImg.getX()=10){
        frogImg.move(60,0);
      }
    }
    if(direction="right"){
      
    }
    if(direction="up"){
      
    }
    if(direction="down"){
      
    }
  }
}