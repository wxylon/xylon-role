package game.javaman.gobject;

import game.henry.game.*;

/**
 * @author henry www.riabbs.com
 * 
 * @version 1.0
 */
// 左加速板
public class BoardB extends Board {

	public BoardB() {
	}

	public void whenCollideWithMan(JMan jman) {
		if (jman.inblood != 0) {
			jman.inblood = 0;

		}
		jman.setLife(jman.getLife() + 1);
		musicplayer.playMusic(musicplayer.SBC);
		jman.setVY(this.getVY());
		jman.setYPos(this.getYPos() - HEIGHT_jMAN - 1);
		jman.setAY(0);
		jman.setCurrentLocation(this);
		this.setEnableLoadMan(false);

	}
}
