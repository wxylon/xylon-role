package game.test;

import game.henry.game.ImagePanel;
import game.javaman.gswing.NumberView;
import game.javaman.image.ImageFactory;

import javax.swing.JFrame;

public class TestNumberView {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(200, 200, 200, 200);
		frame.setContentPane(new NumberView(8));
		frame.setVisible(true);
	}

}
