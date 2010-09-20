package game.javaman.gobject;
import game.henry.game.*;
/**
  * @author henry
  * www.riabbs.com
  *
  * @version 1.0
 */
public class LRBoard extends Sprite {
  public LRBoard() {
  }
  public void update(long elapsedTime) {
    if (getYPos() < -32) {
      setYPos(0);
    }
    super.update(elapsedTime);
  }

}
