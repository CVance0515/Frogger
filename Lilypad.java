import objectdraw.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Image;

public class Lilypad{
  //state variables
  private VisibleImage lilyImg;
  private int lilyX;
  private Frog Richard;
  private Image lilyF;
  boolean hasFrog;
  //Lilypad constructor
  public Lilypad(Image i, Image lilyFrog, DrawingCanvas c, int x, Frog richard){
    lilyImg = new VisibleImage(i, new Location(x, 10), 100, 60, c);
    int lilyX = x;
    Richard = richard;
    lilyF = lilyFrog;
  }

  public boolean updateLily(DrawingCanvas c, int x){
    hasFrog = false;
    if(lilyImg.overlaps(Richard.getVisibleImage())){
      lilyImg.setImage(lilyF);
      boolean hasFrog = true;
    }
    return hasFrog;
  }
}