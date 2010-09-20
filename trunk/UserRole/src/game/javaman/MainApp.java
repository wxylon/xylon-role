package game.javaman;

import game.javaman.gswing.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author henry www.riabbs.com
 * 
 * @version 1.0
 */
public class MainApp {
	GameModel gamemodel;
	GameView gameview;
	GameKeyListener gameKeyboardControl;

	// 菜单控制器在GameView中包含了
	public MainApp() {
		gamemodel = new GameModel();
		gameview = new GameView(gamemodel);
		gameKeyboardControl = new GameKeyListener();
		// 设定关系--有些关系在模型与视图的关系在GameView中设定了
		gameKeyboardControl.setIModelControl(gamemodel);
		gameview.addKeyListener(gameKeyboardControl);
		// ---------------------------------
		gameview.show();
		gameview.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MainApp.this.gamemodel.exitGame();
			}
		});
		gamemodel.timeloop(); // 第一次开始时,以后将使用startGame
	}

	public static void main(String[] args) {
		// 关闭工具栏
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		MainApp mainapp = new MainApp();
	}
}
