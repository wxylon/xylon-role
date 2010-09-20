package game.javaman;

import game.henry.game.*;
import game.javaman.gobject.*;
import game.javaman.ginterface.*;

/**
 * @author henry www.riabbs.com
 * 
 * @version 1.0
 */
public class GameObjectBuilder implements IConstant {

	GameConfigure gameconfig = GameConfigure.getInstance();
	private static GameObjectBuilder instance = new GameObjectBuilder();

	private GameObjectBuilder() {
	}

	public static GameObjectBuilder getInstance() {
		return instance;
	}

	public JMan getJMan() {
		JMan jman = new JMan();
		jman.setWidth(WIDTH_Jman);
		jman.setHeight(HEIGHT_jMAN);
		int timeinterval = 40;
		Animation leftAnimation = new Animation();
		leftAnimation.addFrame(33, timeinterval);
		leftAnimation.addFrame(55, timeinterval);
		leftAnimation.addFrame(36, timeinterval);
		leftAnimation.addFrame(55, timeinterval);
		leftAnimation.setLoop(true);
		leftAnimation.play();
		jman.setLeftAnimation(leftAnimation);

		Animation bloodLeftAnimation = new Animation(); // ---------
		bloodLeftAnimation.addFrame(33, timeinterval); // 1
		bloodLeftAnimation.addFrame(34, timeinterval); // b2
		bloodLeftAnimation.addFrame(36, timeinterval); // 3
		bloodLeftAnimation.addFrame(35, timeinterval); // b4
		bloodLeftAnimation.addFrame(32, timeinterval); // b1
		bloodLeftAnimation.addFrame(55, timeinterval); // 2
		bloodLeftAnimation.addFrame(32, timeinterval); // b3
		bloodLeftAnimation.addFrame(55, timeinterval); // 2
		bloodLeftAnimation.setLoop(true);
		bloodLeftAnimation.play();
		jman.setBloodLeftAnimation(bloodLeftAnimation);

		Animation rightAnimation = new Animation();
		rightAnimation.addFrame(44, timeinterval); // 1
		rightAnimation.addFrame(46, timeinterval); // 2
		rightAnimation.addFrame(48, timeinterval); // 3
		rightAnimation.addFrame(46, timeinterval); // 2
		rightAnimation.setLoop(true);
		rightAnimation.play();
		jman.setRightAnimation(rightAnimation);

		Animation bloodRightAnimation = new Animation();
		bloodRightAnimation.addFrame(43, timeinterval); // b1
		bloodRightAnimation.addFrame(46, timeinterval); // 2
		bloodRightAnimation.addFrame(47, timeinterval); // b3
		bloodRightAnimation.addFrame(46, timeinterval); // 2
		bloodRightAnimation.addFrame(44, timeinterval); // 1
		bloodRightAnimation.addFrame(45, timeinterval); // b2
		bloodRightAnimation.addFrame(48, timeinterval); // 3
		bloodRightAnimation.addFrame(45, timeinterval); // b2
		bloodRightAnimation.setLoop(true);
		bloodRightAnimation.play();
		jman.setBloodRightAnimation(bloodRightAnimation);

		Animation leftDownAnimation = new Animation();
		leftDownAnimation.addFrame(38, timeinterval);
		leftDownAnimation.addFrame(40, timeinterval);
		leftDownAnimation.addFrame(42, timeinterval);
		leftDownAnimation.addFrame(40, timeinterval);
		leftDownAnimation.setLoop(true);
		leftDownAnimation.play();
		jman.setLeftDownAnimation(leftDownAnimation);

		Animation bloodLeftDownAnimation = new Animation();
		bloodLeftDownAnimation.addFrame(37, timeinterval); // b1
		bloodLeftDownAnimation.addFrame(40, timeinterval); // 2
		bloodLeftDownAnimation.addFrame(41, timeinterval); // b3
		bloodLeftDownAnimation.addFrame(40, timeinterval); // 2
		bloodLeftDownAnimation.addFrame(38, timeinterval); // 1
		bloodLeftDownAnimation.addFrame(39, timeinterval); // b2
		bloodLeftDownAnimation.addFrame(42, timeinterval); // 3
		bloodLeftDownAnimation.addFrame(39, timeinterval); // b2
		bloodLeftDownAnimation.setLoop(true);
		bloodLeftDownAnimation.play();
		jman.setBloodLeftDownAnimation(bloodLeftDownAnimation);

		Animation rightDownAnimation = new Animation();
		rightDownAnimation.addFrame(50, timeinterval);
		rightDownAnimation.addFrame(52, timeinterval);
		rightDownAnimation.addFrame(54, timeinterval);
		rightDownAnimation.addFrame(52, timeinterval);
		rightDownAnimation.setLoop(true);
		rightDownAnimation.play();
		jman.setRightDownAnimation(rightDownAnimation);

		Animation bloodRightDownAnimation = new Animation();
		bloodRightDownAnimation.addFrame(49, timeinterval); // b1
		bloodRightDownAnimation.addFrame(52, timeinterval); // 2
		bloodRightDownAnimation.addFrame(53, timeinterval); // b3
		bloodRightDownAnimation.addFrame(52, timeinterval); // 2
		bloodRightDownAnimation.addFrame(50, timeinterval); // 1
		bloodRightDownAnimation.addFrame(51, timeinterval); // b2
		bloodRightDownAnimation.addFrame(54, timeinterval); // 3
		bloodRightDownAnimation.addFrame(51, timeinterval); // b2
		bloodRightDownAnimation.setLoop(true);
		bloodRightDownAnimation.play();
		jman.setBloodRightDownAnimation(bloodRightDownAnimation);

		Animation downAnimation = new Animation();
		downAnimation.addFrame(27, timeinterval);
		downAnimation.addFrame(29, timeinterval);
		downAnimation.addFrame(31, timeinterval);
		downAnimation.addFrame(29, timeinterval);
		downAnimation.setLoop(true);
		downAnimation.play();
		jman.setDownAnimation(downAnimation);

		Animation bloodDownAnimation = new Animation();
		bloodDownAnimation.addFrame(26, timeinterval); // b1
		bloodDownAnimation.addFrame(29, timeinterval); // 2
		bloodDownAnimation.addFrame(30, timeinterval); // b3
		bloodDownAnimation.addFrame(29, timeinterval); // 2
		bloodDownAnimation.addFrame(27, timeinterval); // 1
		bloodDownAnimation.addFrame(28, timeinterval); // b2
		bloodDownAnimation.addFrame(31, timeinterval); // 3
		bloodDownAnimation.addFrame(28, timeinterval); // b2
		bloodDownAnimation.setLoop(true);
		bloodDownAnimation.play();
		jman.setBloodDownAnimation(bloodDownAnimation);

		Animation stopAnimation = new Animation();
		stopAnimation.addFrame(56);
		jman.setStopAnimation(stopAnimation);

		Animation bloodStopAnimation = new Animation();
		bloodStopAnimation.addFrame(56, timeinterval);
		bloodStopAnimation.addFrame(57, timeinterval);
		bloodStopAnimation.setLoop(true);
		bloodStopAnimation.play();
		jman.setBloodStopAnimation(bloodStopAnimation);

		jman.setAnimation(stopAnimation);
		jman.setWidth(30);
		jman.setHeight(30);
		return jman;
	}

	public Sprite getGameBackGround() {
		// ---------背景-----------------
		GameBackGround background = new GameBackGround();
		Animation backgroundAnimation = new Animation();
		backgroundAnimation.addFrame(0);
		background.setAnimation(backgroundAnimation);
		background.setVY(gameconfig.getVYBackGround());
		background.setXPos(17f);
		return background;
	}

	public Sprite getLeftBoard() {
		// 左边界
		LRBoard leftBoard = new LRBoard();
		leftBoard.setLocationImage(1);
		leftBoard.setVY(gameconfig.getVYBoard());
		leftBoard.setXPos(1f);
		return leftBoard;

	}

	public Sprite getRightBoard() {
		// 右边界
		LRBoard rightBoard = new LRBoard();
		rightBoard.setLocationImage(1);
		rightBoard.setVY(gameconfig.getVYBoard());
		rightBoard.setXPos(401f);
		return rightBoard;
	}

	public Sprite getTopBoard() {
		// 上针板
		Sprite sp = new Sprite();
		sp.setLocationImage(2);
		sp.setXPos(16);
		return sp;
	}

	public Board getBoardA() {
		// 普通平板
		BoardA board = new BoardA();
		board.setWidth(WIDTH_Board);
		board.setHeight(HEIGHT_Board);
		board.setLocationImage(3);
		board.setVY(gameconfig.getVYBoard());
		return board;
	}

	public Board getBoardF() {
		// 针板
		BoardF board = new BoardF();
		board.setWidth(WIDTH_Board);
		board.setHeight(HEIGHT_Board);
		board.setLocationImage(25);
		board.setVY(gameconfig.getVYBoard());
		return board;
	}

	public Board getBoardB() {
		// 左加速板
		BoardB board = new BoardB();
		board.setWidth(WIDTH_Board);
		board.setHeight(HEIGHT_Board);
		Animation animation = new Animation();
		int timeinterval = 50;
		animation.addFrame(4, timeinterval);
		animation.addFrame(5, timeinterval);
		animation.addFrame(6, timeinterval);
		animation.addFrame(7, timeinterval);
		animation.play();
		board.setAnimation(animation);
		board.setVY(gameconfig.getVYBoard());
		return board;
	}

	public Board getBoardC() {
		// 右加速板
		BoardC board = new BoardC();
		board.setWidth(WIDTH_Board);
		board.setHeight(HEIGHT_Board);
		Animation animation = new Animation();
		int timeinterval = 50;
		animation.addFrame(8, timeinterval);
		animation.addFrame(9, timeinterval);
		animation.addFrame(10, timeinterval);
		animation.addFrame(11, timeinterval);
		animation.play();
		board.setAnimation(animation);
		board.setVY(gameconfig.getVYBoard());
		return board;
	}

	public Board getBoardD() {
		//
		BoardD board = new BoardD();
		board.setWidth(WIDTH_Board);
		board.setHeight(HEIGHT_Board);
		Animation animation = new Animation();
		int timeinterval = 160;
		animation.addFrame(12, timeinterval);
		animation.addFrame(13, timeinterval);
		animation.addFrame(14, timeinterval);
		animation.addFrame(15, timeinterval);
		animation.addFrame(16, timeinterval);
		animation.addFrame(17, timeinterval);
		animation.addFrame(12, timeinterval);
		animation.setLoop(false);
		board.setAnimation(animation);
		board.setVY(gameconfig.getVYBoard());
		return board;
	}

	public Board getBoardE() {
		BoardE board = new BoardE();
		board.setWidth(WIDTH_Board);
		board.setHeight(HEIGHT_Board);
		Animation animation = new Animation();
		int timeinterval = 20;
		animation.addFrame(22, timeinterval);
		animation.addFrame(23, timeinterval);
		animation.addFrame(24, timeinterval);
		animation.addFrame(23, timeinterval);
		animation.addFrame(22, timeinterval);
		animation.addFrame(21, timeinterval);
		animation.addFrame(20, timeinterval);
		animation.addFrame(19, timeinterval);
		animation.addFrame(18, timeinterval);
		animation.addFrame(19, timeinterval);
		animation.addFrame(20, timeinterval);
		animation.addFrame(21, timeinterval);
		animation.addFrame(22, timeinterval);
		animation.setLoop(false);
		board.setAnimation(animation);
		board.setVY(gameconfig.getVYBoard());
		return board;

	}

}
