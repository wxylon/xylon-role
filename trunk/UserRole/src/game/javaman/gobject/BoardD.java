package game.javaman.gobject;

//翻板
/**
 * @author henry www.riabbs.com
 * 
 * @version 1.0
 */
public class BoardD extends Board {
	public BoardD() {
	}

	public void whenCollideWithMan(JMan jman) {
		if (jman.inblood != 0) {
			jman.inblood = 0;

		}
		jman.setLife(jman.getLife() + 1);
		musicplayer.playMusic(musicplayer.SD);
		jman.setVY(this.getVY());
		jman.setYPos(this.getYPos() - HEIGHT_jMAN - 1);
		this.setEnableLoadMan(false);
		this.play();

	}
}
