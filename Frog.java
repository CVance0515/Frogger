import objectdraw.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Image;

public class Frog {
  
  private VisibleImage frogImg;
  private static final double FROG_HEIGHT = 48;
  private int lives = 3;
  private boolean alive = true;
  public Frog(Image i, DrawingCanvas c){
    frogImg = new VisibleImage(i, new Location(10,10), c);
  }
  public boolean overlaps(VisibleImage vehicleImg){
    return frogImg.overlaps(vehicleImg);
  }
  public VisibleImage getVisibleImage(){
    return frogImg;
  }
  public void hops(String direction){
    if(alive){
      if(direction.equals("left")){
        if(frogImg.getX() != 10){
          frogImg.move(-100,0);
        }
      }
      if(direction.equals("right")){
        if(frogImg.getX() != 610){
          frogImg.move(100,0);
        }
      }
      if(direction.equals("up")){
        if(frogImg.getY() != 10){
          frogImg.move(0,-70);
        }
      }
      if(direction.equals("down")){
        if(frogImg.getY() != 360){
          frogImg.move(0,70);
        }
      }
    }
    if( !alive && lives > 0){
      lives--;
      alive = true;
    }
    if( !alive && lives == 0){
      
    }
  }
}