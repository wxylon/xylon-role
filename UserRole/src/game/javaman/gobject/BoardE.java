package game.javaman.gobject;

//反弹板
/**
  * @author henry
  * www.riabbs.com
  *
  * @version 1.0
 */
public class BoardE
    extends Board {
  public BoardE() {
  }

  /**
   * whenCollideWithMan
   *
   * @param jman JMan
   */
  public void whenCollideWithMan(JMan jman) {
    if (jman.inblood != 0) {
      jman.inblood = 0;
    }
    jman.setLife(jman.getLife() + 1);
    musicplayer.playMusic(musicplayer.SE);
    jman.setVY(this.getVY() + vYJmanBoardE);
    this.play();
  }
}
