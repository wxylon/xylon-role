package game.javaman.gobject;
/**
 * @author henry
 * www.riabbs.com
 *
 * @version 1.0
 */
//平板
public class BoardA
    extends Board {
  public BoardA() {
  }
  public void whenCollideWithMan(JMan jman) {
    if(jman.inblood!=0){
      jman.inblood=0;

    }jman.setLife(jman.getLife()+1);
    musicplayer.playMusic(musicplayer.SA);
    jman.setVY(this.getVY());
    jman.setYPos(this.getYPos() - HEIGHT_jMAN - 1);
    jman.setAY(0);
    jman.setCurrentLocation(this);
    this.setEnableLoadMan(false);

  }

}
