package game.javaman.gobject;
/**
  * @author henry
  * www.riabbs.com
  *
  * @version 1.0
 */
import game.henry.game.*;
import game.javaman.ginterface.*;
public class JMan
    extends Sprite {
  Board currentLocation;
  Animation leftAnimation;
  Animation bloodLeftAnimation;

  Animation rightAnimation;
  Animation bloodRightAnimation;

  Animation leftDownAnimation;
  Animation bloodLeftDownAnimation;

  Animation rightDownAnimation;
  Animation bloodRightDownAnimation;

  Animation downAnimation;
  Animation bloodDownAnimation;

  Animation stopAnimation;
  Animation bloodStopAnimation;
  int life=12;
  int inblood;

  ILifeValueListener lifeListener;
  public JMan() {
  }

  public void update(long elapsedTime) {
    if(inblood>0){
      inblood--;
    }
    setVX(getVX() + getAX() * elapsedTime);
    setVY(getVY() + getAY() * elapsedTime);
    setXPos(getXPos() + getVX() * elapsedTime);
    setYPos(getYPos() + getVY() * elapsedTime);
    Animation tempanimation = selectAnimation();
    if (tempanimation != animation) {//通过状态来切换动作
      animation.reset();
    }
    setAnimation(tempanimation);
    animation.update(elapsedTime);
  }

  private Animation selectAnimation() {
    if (getVX() == 0 && getAY() == 0 && inblood == 0) {
      return stopAnimation;
    }
    if (getVX() == 0 && getAY() == 0 && inblood != 0) {
      return bloodStopAnimation;
    }

    if (getVX() == 0 && getAY() != 0 && inblood == 0) {
      return downAnimation;
    }
    if (getVX() == 0 && getAY() != 0 && inblood != 0) {
      return bloodDownAnimation;
    }

    if (getVX() > 0 && getAY() == 0 && inblood == 0) {
      return rightAnimation;
    }
    if (getVX() > 0 && getAY() == 0 && inblood != 0) {
      return bloodRightAnimation;
    }

    if (getVX() > 0 && getAY() != 0 && inblood == 0) {
      return rightDownAnimation;
    }
    if (getVX() > 0 && getAY() != 0 && inblood != 0) {
      return bloodRightDownAnimation;
    }

    if (getVX() < 0 && getAY() == 0 && inblood == 0) {
      return leftAnimation;
    }
    if (getVX() < 0 && getAY() == 0 && inblood != 0) {
      return bloodLeftAnimation;
    }

    if (getVX() < 0 && getAY() != 0 && inblood == 0) {
      return leftDownAnimation;
    }
    if (getVX() < 0 && getAY() != 0 && inblood != 0) {
      return bloodLeftDownAnimation;
    }
    return null;
  }
  public void setBloodDownAnimation(Animation bloodDownAnimation) {
    this.bloodDownAnimation = bloodDownAnimation;
  }
  public void setBloodLeftAnimation(Animation bloodLeftAnimation) {
    this.bloodLeftAnimation = bloodLeftAnimation;
  }
  public void setBloodLeftDownAnimation(Animation bloodLeftDownAnimation) {
    this.bloodLeftDownAnimation = bloodLeftDownAnimation;
  }
  public void setBloodRightAnimation(Animation bloodRightAnimation) {
    this.bloodRightAnimation = bloodRightAnimation;
  }
  public void setBloodRightDownAnimation(Animation bloodRightDownAnimation) {
    this.bloodRightDownAnimation = bloodRightDownAnimation;
  }
  public void setBloodStopAnimation(Animation bloodStopAnimation) {
    this.bloodStopAnimation = bloodStopAnimation;
  }
  public void setDownAnimation(Animation downAnimation) {
    this.downAnimation = downAnimation;
  }
  public void setLeftAnimation(Animation leftAnimation) {
    this.leftAnimation = leftAnimation;
  }
  public void setLeftDownAnimation(Animation leftDownAnimation) {
    this.leftDownAnimation = leftDownAnimation;
  }
  public void setRightAnimation(Animation rightAnimation) {
    this.rightAnimation = rightAnimation;
  }
  public void setRightDownAnimation(Animation rightDownAnimation) {
    this.rightDownAnimation = rightDownAnimation;
  }
  public void setStopAnimation(Animation stopAnimation) {
    this.stopAnimation = stopAnimation;
  }
  public void setCurrentLocation(Board currentLocation) {
    this.currentLocation = currentLocation;
  }
  public Board getCurrentLocation() {
    return currentLocation;
  }
  public void setInblood(int inblood) {
    this.inblood = inblood;
  }
  public int getInblood() {
    return inblood;
  }
  public int getLife() {
    return life;
  }
  public void setLife(int life) {
    if(life>12){
      this.life=12;
    }else
    if(life<0){
      this.life = 0;
    }else{
      this.life = life;
    }
    lifeListener.updatelife(this.life);
  }
    public void setLifeListener(ILifeValueListener lifeListener) {
        this.lifeListener = lifeListener;
    }

}
