package game.javaman;

import java.util.*;
import game.henry.game.*;
import game.javaman.ginterface.*;
import game.javaman.gobject.*;
import game.javaman.sound.*;

/**
 * @author henry www.riabbs.com
 * 
 * @version 1.0
 */
public class GameModel extends GameLoop implements IModel, IConstant {
	
	boolean pause;
	// -------------------
	private GameObjectBuilder gameObjectBuilder = GameObjectBuilder.getInstance();
	private GameConfigure gameconfig = GameConfigure.getInstance();
	// ----------------------------游戏对像
	private BoardManager bm; // 所有board跳板
	private Sprite background; // 背景
	private Sprite leftboard; // 左边界
	private Sprite rightboard; // 右边界
	private Sprite topboard; // 上针板
	private JMan jman;
	
	//按键移动的距离
	//水平
	private float vXJman;
	//垂直
	private float aYJman;
	// --------------------------接受事件
	private IFloorCountListener floorCountListener;
	private ILifeValueListener lifeValueListener;
	private MusicPlayer musicplayer = MusicPlayer.getInstance();
	private IGameControl gameEventListener; // 游戏开始结束控制接口和通知事件使用了一个接口
	PaintListener paintListener;
	//游戏是否结束
	private boolean gameEnd; // -----------------------------

	public GameModel() {
		init();
	}

	public void setPaintListener(PaintListener paintListener) {
		this.paintListener = paintListener;
	}

	public void init() {
		// 初始化将重建new 游戏对像
		background = gameObjectBuilder.getGameBackGround();
		leftboard = gameObjectBuilder.getLeftBoard();
		rightboard = gameObjectBuilder.getRightBoard();
		topboard = gameObjectBuilder.getTopBoard();
		bm = new BoardManager();
		jman = gameObjectBuilder.getJMan();
		setManOnBoard(bm.getManFirstBoard()); // 一定是boardA 设置人的位置
		vXJman = gameconfig.getVXJman();
		aYJman = gameconfig.getAYJman();
		continueLoop();
	}

	// 设置人的初始位置
	private void setManOnBoard(Board board) {
		jman.setXPos(board.getXPos() + WIDTH_Board / 2);
		jman.setYPos(board.getYPos() - HEIGHT_jMAN - 1);
		jman.setVY(board.getVY());
		jman.setCurrentLocation(board);
	}

	// 模板方法,被超类循环调用
	public void updateModel(long elapsedTime) {
		//背景面板动
		background.update(elapsedTime);
		//左边栏
		leftboard.update(elapsedTime);
		//右边栏
		rightboard.update(elapsedTime);
		//所有board跳板
		bm.update(elapsedTime);
		//小人
		if (!gameEnd) {
			jman.update(elapsedTime);
		}
		//检查
		modelCheck();
		paintListener.updatePaint();
	}
	/**
	 * 此方法描述的是：检查
	 * @version 创建时间：Sep 21, 2010 5:21:52 PM 
	 * void
	 */
	private void modelCheck() {
		Board currentLocation = jman.getCurrentLocation();
		topBoardCheck(currentLocation);
		leftRightCheck();
		nullboardCheck(currentLocation);
		downCheck(currentLocation);
		boardBCCheck(currentLocation);
		gameoverCheck();
	}

	// 上针板检查
	private void topBoardCheck(Board currentLocation) {
		if (jman.getYPos() < HEIGHT_TopBoard) {
			// 触到上针板
			musicplayer.playMusic(musicplayer.SFT);
			jman.setInblood(TIME_Inblood);
			jman.setLife(jman.getLife() - BLOOD_LOSE);
			if (currentLocation != null) {
				// 此处可以重构 使Board拥有unloadman方法
				if (!(currentLocation instanceof BoardE)) {
					currentLocation.setEnableLoadMan(false);
					jman.setCurrentLocation(null);
					jman.setAY(aYJman);
					jman.setVY(0);
					jman.setYPos(HEIGHT_TopBoard);
				}
			} else {
				jman.setVY(0);
				jman.setAY(aYJman);
				jman.setYPos(HEIGHT_TopBoard);
			}
		}
	} // 下落检查

	// 下落时检查是否碰到其他东西
	private void downCheck(Board currentLocation) {
		if (currentLocation == null) { // 在空中下落,检查是否和其他board碰撞
			Collection boards = bm.getBoards();
			Iterator it = boards.iterator();
			while (it.hasNext()) {
				Board board = (Board) it.next();
				if (jman.isCollide(board)
						&& board.isEnableLoadMan()
						&& board.getYPos() + HEIGHT_Board > (jman.getYPos() + HEIGHT_jMAN)) {
					board.whenCollideWithMan(jman);
					break;
				}
			}
		}
	}

	// 如果在板上时,检查x方向是不是已经踏空了
	private void nullboardCheck(Board currentLocation) {
		if (currentLocation != null) {
			ModelObject mo = jman.getModelObjectCopy();
			mo.setYPos(mo.getYPos() + 2);
			if (!currentLocation.isCollide(mo)) {
				currentLocation.setEnableLoadMan(false);
				jman.setCurrentLocation(null);
				jman.setAY(aYJman);
			}
		}
	}

	// 左右边界检查
	private void leftRightCheck() {
		if (jman.getXPos() < WIDTH_LR) {
			jman.setXPos(WIDTH_LR + 1);
		}
		if (jman.getXPos() > 370) {
			jman.setXPos(369);
		}
	}

	// 游戏结束条件检查
	private void gameoverCheck() {
		if (jman.getLife() <= 0 || jman.getYPos() > 356) {
			// setPaintting(false);
			musicplayer.playMusic(musicplayer.SDead);
			endGame();
		}
	}

	private void boardBCCheck(Board currentLocation) {
		if (currentLocation instanceof BoardB) {
			jman.setXPos(jman.getXPos() - 1f);
		}
		if (currentLocation instanceof BoardC) {
			jman.setXPos(jman.getXPos() + 1f);
		}
	}

	public boolean isPause() {
		return pause;
	}

	public boolean isGameEnd() {
		return gameEnd;
	}

	public Sprite getBackground() {
		return background;
	}

	public JMan getJman() {
		return jman;
	}

	public Sprite getLeftboard() {
		return leftboard;
	}

	public Sprite getRightboard() {
		return rightboard;
	}

	public Sprite getTopboard() {
		return topboard;
	}

	/**
	 * 左移动
	 */
	public void leftMan() {
		jman.setVX(-vXJman);
	}

	/**
	 * 右移动
	 */
	public void rightMan() {
		jman.setVX(vXJman);
	}

	/**
	 * 停止
	 */
	public void stopMan() {
		jman.setVX(0);
	}

	/**
	 * 结束
	 */
	public void endGame() {
		this.pauseLoop();
		gameEnd = true;
		gameEventListener.endGame();
	}

	/**
	 * 暂停
	 */
	public void pauseGame() {
		pause = true;
		this.pauseLoop();
		gameEventListener.pauseGame();
	}

	/**
	 * 继续
	 */
	public void continueGame() {
		pause = false;
		this.continueLoop();
		gameEventListener.continueGame();
	}

	/**
	 * 开始
	 */
	public void startGame() {
		gameEnd = false;
		musicplayer.playMusic(musicplayer.SStart);
		init();
		gameEventListener.startGame(); // 重新初始化模型视图关系
	}
	/**
	 * 退出
	 */
	public void exitGame() {
		gameconfig.saveConfigure();
		System.exit(0);
	}

	public void setFloorCountListener(IFloorCountListener floorCountListener) {
		this.floorCountListener = floorCountListener;
		bm.setFloorCountListener(this.floorCountListener);
	}

	public void setLifeValueListener(ILifeValueListener lifeValueListener) {
		this.lifeValueListener = lifeValueListener;
		jman.setLifeListener(this.lifeValueListener);
	}

	public void setGameEventListener(IGameControl gameEventListener) {
		this.gameEventListener = gameEventListener;
	}

	public Collection getBoards() {
		return bm.getBoards();
	}
}
