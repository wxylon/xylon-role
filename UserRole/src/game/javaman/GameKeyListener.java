package game.javaman;

import java.awt.event.*;

/**
 * @author henry www.riabbs.com
 * 
 * @version 1.0
 */
public class GameKeyListener implements KeyListener {
	
	GameConfigure gameconfigure = GameConfigure.getInstance();
	GameModel gamemodel;
	boolean leftpress = false;
	boolean rightpress = false;

	public GameKeyListener() {
	}

	public void setIModelControl(GameModel gamemodel) {
		this.gamemodel = gamemodel;
	}

	public void keyPressed(KeyEvent e) {
		if (gamemodel != null) {
			if (!gamemodel.isGameEnd()) {
				if (gameconfigure.getLeftKeyCode() == e.getKeyCode()) {
					leftpress = true;
					gamemodel.leftMan();
				}
				if (gameconfigure.getRightKeyCode() == e.getKeyCode()) {
					rightpress = true;
					gamemodel.rightMan();
				}
				if (gameconfigure.getPausekeyCode() == e.getKeyCode()) {
					// 游戏没有结束允许使用暂停
					if (gamemodel.isPause()) {
						gamemodel.continueGame();
					} else {
						gamemodel.pauseGame();
					}
				}
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == gameconfigure.getLeftKeyCode()) {
			leftpress = false;
		}
		if (e.getKeyCode() == gameconfigure.getRightKeyCode()) {
			rightpress = false;
		}
		if (gamemodel != null && !leftpress && !rightpress) {
			gamemodel.stopMan();
		}
	}

	public void keyTyped(KeyEvent e) {
	}

}
