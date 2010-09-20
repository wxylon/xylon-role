package game.javaman.gobject;

/**
 * @author henry www.riabbs.com
 * 
 * @version 1.0
 */
// 针板
public class BoardF extends Board {
	public BoardF() {
	}

	/**
	 * whenCollideWithMan
	 * 
	 * @param jman
	 *            JMan
	 */
	public void whenCollideWithMan(JMan jman) {

		jman.setLife(jman.getLife() - BLOOD_LOSE);
		jman.inblood = TIME_Inblood;
		musicplayer.playMusic(musicplayer.SFT);
		jman.setVY(this.getVY());
		jman.setYPos(this.getYPos() - HEIGHT_jMAN - 1);
		jman.setAY(0);
		jman.setCurrentLocation(this);
		this.setEnableLoadMan(false);

	}
}
