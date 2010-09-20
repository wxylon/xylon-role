package game.javaman.gswing;

/**
 * @author henry
 * www.riabbs.com
 *
 * @version 1.0
 */
import game.henry.game.*;
import game.javaman.image.ImageFactory;
import game.javaman.ginterface.*;

/**
 * 此类描述的是：HP 操作最终显示图片的变化，图片 Panel
 * @version 创建时间：Sep 20, 2010 5:46:10 PM
 */
public class LifeView extends ImagePanel implements ILifeValueListener {
	ImageFactory imageFactory = ImageFactory.getInstance();
	int lifevalue;

	public LifeView() {
		updatelife(12);
	}

	public LifeView(int lifevalue) {
		updatelife(lifevalue);
	}

	public void init() {
		updatelife(12);
	}

	public void updatelife(int lifevalue) {
		this.lifevalue = lifevalue;
		if (lifevalue > 12) {
			lifevalue = 12;
		}
		if (lifevalue < 0) {
			lifevalue = 0;
		}
		//数值转换为字符串，对应图片
		String suffix = lifevalue > 9 ? String.valueOf(lifevalue) : 0 + String.valueOf(lifevalue);
		this.setImage(imageFactory.getImageIcon("images/life/life_" + suffix + ".gif"));
	}
}
