import objectdraw.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Image;

public class Frog {
  
  private static VisibleImage frogImg;
  private static final double FROG_HEIGHT = 48;
  private int lives = 3;
  private boolean alive = true;
  private boolean loser = false;
DrawingCanvas c;
  public Frog(Image i, DrawingCanvas c){
    frogImg = new VisibleImage(i, new Location(310,360), c);
    this.c = c;
  }
  public boolean overlaps(VisibleImage vehicleImg){
    return frogImg.overlaps(vehicleImg);
  }
  public VisibleImage getVisibleImage(){
    return frogImg;
  }
  public static void reset(){
    frogImg.moveTo(310,360);
  }
  public void dead(){
    
  }
  public void die(){
    Frog.reset();
    lives--;
    alive=false;
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
      if(direction.equals("die")){
        alive = false;
      }
      System.out.println(lives);
    }
    if( !alive && lives > 0){
      alive = true;
      
      System.out.println(lives);
    }
    if( !alive && lives == 0){
      c.clear();
      System.out.println(lives);
    }
  }
  

  
}