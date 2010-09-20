package game.javaman.gobject;

import game.henry.game.*;

/**
 * @author henry www.riabbs.com
 * 
 * @version 1.0
 */
public class GameBackGround extends Sprite {
	public GameBackGround() {
	}

	public void update(long elapsedTime) {
		super.update(elapsedTime);
		if (getYPos() < -184) {
			setYPos(-56);
		}
	}
}
