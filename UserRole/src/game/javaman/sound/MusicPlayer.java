package game.javaman.sound;

import java.applet.*;
import game.javaman.GameConfigure;
/**
  * @author henry
  * www.riabbs.com
  *
  * @version 1.0
 */
public class MusicPlayer {
  private AudioClip sA;
  private AudioClip sBC;
  private AudioClip sD;
  private AudioClip sE;
  private AudioClip sFT;
  private AudioClip sDead;
  private AudioClip sStart;
  private static MusicPlayer instance;
  private GameConfigure gameconfigure = GameConfigure.getInstance();
  public final static int SA = 1;
  public final static int SBC = 2;
  public final static int SD = 3;
  public final static int SE = 4;
  public final static int SFT = 5;
  public final static int SDead = 6;
  public final static int SStart = 7;
  private MusicPlayer() {
    sA = Applet.newAudioClip(this.getClass().getResource("sounds/a.wav"));
    sBC = Applet.newAudioClip(this.getClass().getResource("sounds/bc.wav"));
    sD = Applet.newAudioClip(this.getClass().getResource("sounds/d.wav"));
    sE = Applet.newAudioClip(this.getClass().getResource("sounds/e.wav"));
    sFT = Applet.newAudioClip(this.getClass().getResource("sounds/ft.wav"));
    sDead = Applet.newAudioClip(this.getClass().getResource("sounds/dead.wav"));
    sStart = Applet.newAudioClip(this.getClass().getResource("sounds/start.wav"));
  }

  public synchronized static MusicPlayer getInstance() {
    if (instance != null) {
      return instance;
    }
    instance = new MusicPlayer();
    return instance;
  }

  public void playMusic(int MUSIC_CONSTANT) {
    if (gameconfigure.isMusicEnable()) {
      switch (MUSIC_CONSTANT) {
        case SA:
          sA.play();
          break;
        case SBC:
          sBC.play();
          break;
        case SD:
          sD.play();
          break;
        case SE:
          sE.play();
          break;
        case SFT:
          sFT.play();
          break;
        case SDead:
          sDead.play();
          break;
        case SStart:
          sStart.play();

      }
    }

  }

}
