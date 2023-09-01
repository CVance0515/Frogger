import objectdraw.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Image;

public class Lilypad{
  //state variables
  private VisibleImage lilyImg;
  private int lilyX;
  //Lilypad constructor
  public Lilypad(Image i, DrawingCanvas c, int x){
    lilyImg = new VisibleImage(i, new Location(x, 10), 100, 60, c);
    int lilyX = x;
  }
}