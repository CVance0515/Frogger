import objectdraw.*;
import java.awt*;
public class Frog{
  private VisibleImage frogImg;
  private static final double FROG_HEIGHT = 48;

  public Frog(Image i, DrawingCanvas c){
    frogImage = new VisibleImage(i, new Location(10,10), c);
  }
}