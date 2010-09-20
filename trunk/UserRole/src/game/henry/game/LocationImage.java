package game.henry.game;

/**
 * @author henry
 * www.riabbs.com
 *
 * @version 1.0
 */
import java.awt.*;
import javax.swing.*;

/**
 * 此类描述的是： 游戏区图片
 * @version 创建时间：Sep 20, 2010 11:38:47 PM
 */
public class LocationImage extends ImageIcon implements Cloneable {
	
	private float yPos;
	private float xPos;

	public LocationImage() {
	}

	public LocationImage(Image im) {
		super(im);
		xPos = 0;
		yPos = 0;
	}

	public LocationImage(Image im, float x, float y) {
		// this.image = im;
		super(im);
		xPos = x;
		yPos = y;
	}

	public float getXPos() {
		return xPos;
	}

	public void setXPos(float xPos) {
		this.xPos = xPos;
	}

	public float getYPos() {
		return yPos;
	}

	public void setYPos(float yPos) {
		this.yPos = yPos;
	}

	public Object clone() {
		return new LocationImage(this.getImage(), this.xPos, this.yPos);
	}
}
