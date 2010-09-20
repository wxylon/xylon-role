package game.javaman.gswing;

/**
 * @author henry
 * www.riabbs.com
 *
 * @version 1.0
 */
import javax.swing.plaf.metal.*;
import java.awt.*;
import javax.swing.*;

import game.henry.game.*;
import game.javaman.image.ImageFactory;
import game.javaman.*;
import game.javaman.ginterface.*;

/**
 * 此类描述的是：主窗口  
 * @version 创建时间：Sep 20, 2010 10:59:45 PM
 */
public class GameView extends JFrame implements IGameControl {
	
	ImageFactory imageFactory = ImageFactory.getInstance();
	//字体
	private GreenMetalTheme greenmetal = new GreenMetalTheme();

	// 显示部分组成-------------------
	Container container;
	// 主要绘图区
	PaintPanel mainPaintPanel;
	// 背景
	ImagePanel gameBackground;
	//life图片
	ImagePanel lifewordpanel;
	//文字一
	ImagePanel word1panel;
	//文字二
	ImagePanel word2panel;
	//暂停
	ImagePanel pausepanel;
	//结束图片 
	ImagePanel gameoverPanel;
	//关次对应的图片 需动态变
	NumberView floorCountpanel;
	//小人 HP，对应的图片 需动态变
	LifeView lifeview;
	MenuManager menumanager = new MenuManager();
	// 本模块与其他模块的关系-------------------------------------
	GameModel gamemodel;

	private void initModelViewRelation() {
		gamemodel.setPaintListener(mainPaintPanel);
		gamemodel.setFloorCountListener(floorCountpanel);
		gamemodel.setLifeValueListener(lifeview);
		gamemodel.setGameEventListener(this);
	}

	public GameView(GameModel model) {
		super("JavaMan100");
		// --总的背景
		this.gamemodel = model;
		initCreate();
		initShow();

		initModelViewRelation();
		menumanager.setMainframe(this);
		menumanager.setModel(gamemodel);
	}

	/**
	 * 此方法描述的是：将各panel装入容器，
	 * @version 创建时间：Sep 20, 2010 11:23:52 PM 
	 * void
	 */
	private void initShow() {
		gameBackground.removeAll();
		gameBackground.setLayout(null);
		gameBackground.add(lifeview);
		gameBackground.add(lifewordpanel);
		gameBackground.add(mainPaintPanel);
		gameBackground.add(floorCountpanel);
		gameBackground.add(word1panel);
		gameBackground.add(word2panel);
		container = getContentPane();
		container.setLayout(null);
		container.add(gameBackground);
		//菜单栏
		this.setJMenuBar(menumanager.getMenuBar());
		//不可调整jframe大小
		this.setResizable(false);
		initFeelAndLook();
		//设置jframe大小
		this.setSize(gameBackground.getWidth() + 8,gameBackground.getHeight() + 60);
	}

	/**
	 * 此方法描述的是：初始化各panel 图片，设置panel位置
	 * @version 创建时间：Sep 20, 2010 11:23:09 PM 
	 * void
	 */
	private void initCreate() {
		gameoverPanel = new ImagePanel(imageFactory.getImageIcon("images/gameover.gif"));
		pausepanel = new ImagePanel(imageFactory.getImageIcon("images/pause.gif"));
		gameBackground = new ImagePanel(imageFactory.getImageIcon("images/backgroud.gif"));
		lifewordpanel = new ImagePanel(imageFactory.getImageIcon("images/life/lifeword.gif"));
		floorCountpanel = new NumberView(0);
		lifeview = new LifeView(12);
		mainPaintPanel = new GamePaintPanel(gamemodel);
		word1panel = new ImagePanel(imageFactory.getImageIcon("images/word1.gif"));
		word2panel = new ImagePanel(imageFactory.getImageIcon("images/word2.gif"));
		
		//设置位置
		lifewordpanel.setPosition(90, 18);
		word1panel.setPosition(196, 16);
		word2panel.setPosition(386, 16);
		floorCountpanel.setLocation(268, 20);
		lifeview.setPosition(60, 33);
		mainPaintPanel.setBounds(24, 63, 418, 355);
		pausepanel.setPosition(150, 150);
		gameoverPanel.setPosition(150, 150);
	}

	/**
	 * 此方法描述的是：设置字体
	 * @version 创建时间：Sep 20, 2010 11:27:52 PM 
	 * void
	 */
	private void initFeelAndLook() {
		// this.setFont(new java.awt.Font("SansSerif", 0, 14));
		MetalLookAndFeel.setCurrentTheme(greenmetal);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception ex) {
		}
		SwingUtilities.updateComponentTreeUI(this);
	}

	public PaintPanel getpaintPanel() {
		return mainPaintPanel;
	}

	public void endGame() {
		mainPaintPanel.add(gameoverPanel, 0);
		mainPaintPanel.repaint();
	}

	public void exitGame() {
	}

	public void pauseGame() {
		mainPaintPanel.add(pausepanel, 0);
		mainPaintPanel.repaint();
	}

	public void startGame() {
		mainPaintPanel.removeAll();
		// if (gameoverPanel.getParent() != null) {
		// gameoverPanel.getParent().remove(gameoverPanel);
		// }
		floorCountpanel.initNumber(0);
		lifeview.init();
		initModelViewRelation();
	}

	public void continueGame() {
		mainPaintPanel.remove(pausepanel);
		mainPaintPanel.repaint();
	}
	
	public static void main(String[] args) {
		JFrame frame = new GameView(new GameModel());
		frame.setVisible(true);
	}
}
