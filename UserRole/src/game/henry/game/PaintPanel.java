package game.henry.game;

import java.awt.*;
import javax.swing.JPanel;
import java.util.*;

/**
 * @author henry www.riabbs.com
 * 
 * @version 1.0
 */
abstract public class PaintPanel extends JPanel implements PaintListener {
	Collection allLocationImages;

	public PaintPanel() {
	}

	public void resetLocationImageS(Collection alllocationimages) {
		this.allLocationImages = alllocationimages;
		repaint();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (allLocationImages != null) {
			for (Iterator iter = allLocationImages.iterator(); iter.hasNext();) {
				LocationImage locationimage = (LocationImage) iter.next();
				g.drawImage(locationimage.getImage(), Math.round(locationimage
						.getXPos()), Math.round(locationimage.getYPos()), this);
			}
		}
		// 优先显示其他组件
		Component[] child = this.getComponents();
		for (int i = 0; i < child.length; i++) {
			child[i].setVisible(true);
		}
	}

	protected abstract Collection getAllLocationImage();

	public void updatePaint() {
		this.allLocationImages = getAllLocationImage();
		repaint();
	}
}
