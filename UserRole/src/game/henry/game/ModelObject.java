package game.henry.game;

/**
 * 此类描述的是：  所有游戏运动对像的基类主要出于碰撞检查考虑
 * 所有面板的基类
 * @version 创建时间：Sep 25, 2010 9:34:58 AM
 */
public class ModelObject {
	//高度
	private float height;
	//宽度
	private float width;
	//横坐标
	private float xPos;
	//纵坐标
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

	/**
	 * 此方法描述的是：指定的坐标是否在该面板范围内
	 * @version 创建时间：Sep 25, 2010 9:37:06 AM
	 */
	public boolean isPointContains(float x, float y) {
		return (x > xPos && x < (xPos + width) && y > yPos && y < (yPos + height));
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
