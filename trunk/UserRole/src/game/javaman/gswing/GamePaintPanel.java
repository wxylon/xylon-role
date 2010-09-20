package game.javaman.gswing;
/**
  * @author henry
  * www.riabbs.com
  *
  * @version 1.0
 */
import game.henry.game.PaintPanel;
import game.henry.game.LocationImage;
import game.henry.game.Sprite;
import game.javaman.image.*;
import java.util.*;
import game.javaman.GameModel;

public class GamePaintPanel
    extends PaintPanel {
  LImageManager locationImageManager = LImageManager.getInstance();
  GameModel model;
  public GamePaintPanel(GameModel model) {
    this.model = model;
  }

  protected Collection getAllLocationImage() {
    ArrayList al = new ArrayList();
    al.add(locationImageManager.getSpriteImage(model.getBackground()));
    al.add(locationImageManager.getSpriteImage(model.getLeftboard()));
    al.add(locationImageManager.getSpriteImage(model.getRightboard()));

    for (Iterator it = model.getBoards().iterator(); it.hasNext(); ) {
      al.add(locationImageManager.getSpriteImage( ( (Sprite) it.next())));
    }
    al.add(locationImageManager.getSpriteImage(model.getJman()));
    al.add(locationImageManager.getSpriteImage(model.getTopboard()));
    return al;
  }
}
