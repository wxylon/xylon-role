package game.test;

import game.henry.game.ImagePanel;
import game.javaman.image.ImageFactory;

import javax.swing.JFrame;

public class TestImagePanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		ImageFactory imageFactory = ImageFactory.getInstance();
		frame.setContentPane(new ImagePanel(imageFactory.getImageIcon("images/gameover.gif")));
		frame.setVisible(true);
	}

}
