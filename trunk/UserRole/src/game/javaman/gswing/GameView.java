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

public class GameView extends JFrame implements IGameControl {
	ImageFactory imageFactory = ImageFactory.getInstance();
	private GreenMetalTheme greenmetal = new GreenMetalTheme();

	// 显示部分组成-------------------
	Container container;
	PaintPanel mainPaintPanel;// 主要绘图区
	ImagePanel gameBackground;
	ImagePanel lifewordpanel;
	ImagePanel word1panel;
	ImagePanel word2panel;
	ImagePanel pausepanel;
	ImagePanel gameoverPanel;
	NumberView floorCountpanel;
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
		this.setJMenuBar(menumanager.getMenuBar());
		this.setResizable(false);
		initFeelAndLook();
		this.setSize(gameBackground.getWidth() + 8,
				gameBackground.getHeight() + 60);
	}

	private void initCreate() {
		gameoverPanel = new ImagePanel(imageFactory
				.getImageIcon("images/gameover.gif"));
		pausepanel = new ImagePanel(imageFactory
				.getImageIcon("images/pause.gif"));
		gameBackground = new ImagePanel(imageFactory
				.getImageIcon("images/backgroud.gif"));
		lifewordpanel = new ImagePanel(imageFactory
				.getImageIcon("images/life/lifeword.gif"));
		floorCountpanel = new NumberView(0);
		lifeview = new LifeView(12);
		mainPaintPanel = new GamePaintPanel(gamemodel);
		word1panel = new ImagePanel(imageFactory
				.getImageIcon("images/word1.gif"));
		word2panel = new ImagePanel(imageFactory
				.getImageIcon("images/word2.gif"));

		lifewordpanel.setPosition(90, 18);
		word1panel.setPosition(196, 16);
		word2panel.setPosition(386, 16);
		floorCountpanel.setLocation(268, 20);
		lifeview.setPosition(60, 33);
		mainPaintPanel.setBounds(24, 63, 418, 355);
		pausepanel.setPosition(150, 150);
		gameoverPanel.setPosition(150, 150);
	}

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

}
