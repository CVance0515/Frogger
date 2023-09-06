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
  //Lilypad constructor
  public Lilypad(Image i, Image lilyFrog, DrawingCanvas c, int x, Frog richard){
    lilyImg = new VisibleImage(i, new Location(x, 10), 100, 60, c);
    int lilyX = x;
    Richard = richard;
    lilyF = lilyFrog;
  }

  public void updateLily(DrawingCanvas c, int x){
    if(lilyImg.overlaps(Richard.getVisibleImage())){
      lilyImg.setImage(lilyF);
    }
    else{
      System.out.println("Not on lily");
    }
  }
}