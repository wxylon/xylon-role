package game.henry.game;

/**
 * @author henry www.riabbs.com
 * 
 * @version 1.0
 */
// 所有游戏运动对像的基类主要出于碰撞检查考虑
public class ModelObject {
	
	private float height;
	private float width;
	private float xPos;
	private float yPos;

	public ModelObject() {
	}

	public boolean isCollide(ModelObject modelObject) {
		return (this.isContainsAPoint(modelObject) || modelObject
				.isContainsAPoint(this));
	}

	private boolean isContainsAPoint(ModelObject modelObject) {
		// boolean iscollide=false;
		return (modelObject.isPointContains(xPos, yPos)
				|| modelObject.isPointContains(xPos + width, yPos)
				|| modelObject.isPointContains(xPos, yPos + height) || modelObject
				.isPointContains(xPos + width, yPos + height));
	}

	public boolean isPointContains(float x, float y) {
		return (x > xPos && x < (xPos + width) && y > yPos && y < (yPos + width));
	}

	// 并不想使用clone
	public ModelObject getModelObjectCopy() {
		ModelObject mo = new ModelObject();
		mo.setHeight(this.getHeight());
		mo.setWidth(this.getWidth());
		mo.setXPos(this.getXPos());
		mo.setYPos(this.getYPos());
		return mo;
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

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
}
