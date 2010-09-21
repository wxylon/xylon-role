package game.test;

import game.javaman.gswing.MenuManager;

import javax.swing.JFrame;

public class TestMenuManager {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(200, 200, 200, 200);
		MenuManager menumanager = new MenuManager();
		menumanager.setMainframe(frame);
		frame.setJMenuBar(menumanager.getMenuBar());
		frame.setVisible(true);
	}

}
