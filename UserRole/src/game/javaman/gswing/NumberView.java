package game.javaman.gswing;

/**
 * @author henry
 * www.riabbs.com
 *
 * @version 1.0
 */
import javax.swing.*;
import game.henry.game.*;
import game.javaman.image.ImageFactory;
import game.javaman.ginterface.*;
/**
 * 此类描述的是：关次对应的图片
 * @version 创建时间：Sep 20, 2010 10:57:22 PM
 */
public class NumberView extends JPanel implements IFloorCountListener {
	ImagePanel[] numbers = new ImagePanel[4];

	ImageFactory imageFactory = ImageFactory.getInstance();
	static final int width = 30;
	static final int height = 32;

	public NumberView() {
		init();
		initNumber(0);
	}

	private void init() {
		this.setLayout(null);
		this.setBounds(0, 0, width * 4, height);
		for (int i = 0; i < 4; i++) {
			numbers[i] = new ImagePanel();
			numbers[i].setBounds(i * width, 0, width, height);
			this.add(numbers[i]);
		}
		this.setBounds(0, 0, width * 4, height);
	}

	public NumberView(int number) {
		init();
		updateFloorCount(number);
	}

	public void updateFloorCount(int number) {
		initNumber(number);
	}

	public void initNumber(int number) {
		int n0 = number % 10;
		int n00 = (number % 100) / 10;
		int n000 = (number % 1000) / 100;
		int n0000 = (number % 10000) / 1000;
		numbers[0].setImage(imageFactory.getImageIcon("images/num/number_"
				+ n0000 + ".gif"));
		numbers[1].setImage(imageFactory.getImageIcon("images/num/number_"
				+ n000 + ".gif"));
		numbers[2].setImage(imageFactory.getImageIcon("images/num/number_"
				+ n00 + ".gif"));
		numbers[3].setImage(imageFactory.getImageIcon("images/num/number_" + n0
				+ ".gif"));
	}

}
