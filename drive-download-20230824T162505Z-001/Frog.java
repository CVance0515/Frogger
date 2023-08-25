import objectdraw.*;
import java.awt*;
public class Frog{
  private VisibleImage frogImg;
  private static final double FROG_HEIGHT = 48;

  public Frog(Image i, DrawingCanvas c){
    frogImg = new VisibleImage(i, new Location(10,10), c);
  }
  public boolean overlaps(VisibleImg vehicleImg){
    return frogImg.overlapsWith(vehicleImg);
  }
}