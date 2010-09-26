package game.henry.game;

/**
 * @author henry www.riabbs.com
 * 
 * @version 1.0
 */
public class Sprite extends ModelObject implements TimeUpdate {
	protected Animation animation;
	//移动的距离X
	protected float vX;
	//移动的距离Y
	protected float vY;
	protected long starttime;
//	X 系统步长
	protected float aX;
//	Y 系统步长
	protected float aY;

	public Sprite() {
	}

	public void play() {
		animation.play();
	}

	public void update(long elapsedTime) {
		
		vX = vX + aX * elapsedTime;
		vY = vY + aY * elapsedTime;
		setXPos(getXPos() + vX * elapsedTime);
		setYPos(getYPos() + vY * elapsedTime);
		animation.update(elapsedTime);
	}

	public synchronized int getCurrentFrameNum() {
		return animation.getCurrentFrameNum();
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	public void setLocationImage(int num) {

		if (this.animation == null) {
			animation = new Animation();
			animation.addFrame(num);
		}
	}

	public float getAX() {
		return aX;
	}

	public void setAX(float aX) {
		this.aX = aX;
	}

	public float getAY() {
		return aY;
	}

	public void setAY(float aY) {
		this.aY = aY;
	}
	
	public float getVX() {
		return vX;
	}

	public void setVX(float vX) {
		this.vX = vX;
	}

	public float getVY() {
		return vY;
	}

	public void setVY(float vY) {
		this.vY = vY;
	}
}
