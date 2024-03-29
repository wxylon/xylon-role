package game.javaman.gswing;

import javax.swing.*;
import java.awt.event.*;
import game.javaman.ginterface.*;
import game.javaman.*;

/**
 * 此类描述的是：菜单栏
 * @version 创建时间：Sep 21, 2010 9:32:48 AM
 */
public class MenuManager {

	private JMenuBar menuBar = new JMenuBar();

	// ---------------------------------
	private JMenu gamemenu = new JMenu();
	private JMenu optionmenu = new JMenu();
	private JMenu language = new JMenu();
	private JMenu helpmenu = new JMenu();

	// ----------------------------------------gamemenu
	private JMenuItem newGameItem = new JMenuItem();
	private JRadioButtonMenuItem easyLevel = new JRadioButtonMenuItem();
	private JRadioButtonMenuItem middelLevel = new JRadioButtonMenuItem();
	private JRadioButtonMenuItem hardLevel = new JRadioButtonMenuItem();
	private ButtonGroup levelButtonGroup = new ButtonGroup();
	private JMenuItem exitGameItem = new JMenuItem();

	// ----------------------------------------optionmenu
	private JCheckBoxMenuItem musicEnableItem = new JCheckBoxMenuItem();
	private JMenuItem keycontrol = new JMenuItem();

	// -----------------------------------------language
	private ButtonGroup languageGroup = new ButtonGroup();
	private JRadioButtonMenuItem chinaRB = new JRadioButtonMenuItem();
	private JRadioButtonMenuItem englishRB = new JRadioButtonMenuItem();

	// --------------------------------------------helpmenu
	private JMenuItem aboutItme = new JMenuItem();

	// -----------------------------------gamemenu 监听
	private ActionListener newGameItemListener;
	private ActionListener easylevelListener;
	private ActionListener middlelevelListener;
	private ActionListener hardlevelListener;
	private ActionListener exitGameItemListener;
	
	// ---------------optionmenu监听
	private ActionListener musicEnableItemListener;
	private ActionListener keyboardControlListener;

	// ----------------language 监听
	private ActionListener englishRBListener;
	private ActionListener chinaRBlistener;

	// -------------helpmenu 监听
	private ActionListener aboutItmeListener;

	// -----------------要控制的模型对像
	LanguageSelect str = LanguageSelect.getInstance();
	private IModel imodel;
	private JFrame mainframe;
	private GameConfigure gameconfigure = GameConfigure.getInstance();

	// ---------------------
	public MenuManager() {
		initMenuText();
		composeMenu();
		initStatus();
	}

	/**
	 * 此方法描述的是：初始化 状态
	 * @version 创建时间：Sep 21, 2010 10:13:14 AM 
	 * void
	 */
	private void initStatus() {
		englishRB.setSelected(gameconfigure.getLanguage() == LanguageSelect.ENGLISH);
		chinaRB.setSelected(gameconfigure.getLanguage() == LanguageSelect.CHINA);
		easyLevel.setSelected(gameconfigure.getLevel() == 0);
		middelLevel.setSelected(gameconfigure.getLevel() == 1);
		hardLevel.setSelected(gameconfigure.getLevel() == 2);
		musicEnableItem.setSelected(gameconfigure.isMusicEnable());
	}

	public void setModel(IModel model) {
		this.imodel = model;
		initAction();
	}

	private void initAction() {
		newGameItemListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imodel.startGame();
			}
		};
		newGameItem.addActionListener(newGameItemListener);

		easylevelListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameconfigure.setLevel(0);
				imodel.startGame();
			}
		};
		easyLevel.addActionListener(easylevelListener);

		middlelevelListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameconfigure.setLevel(1);
				imodel.startGame();
			}
		};
		middelLevel.addActionListener(middlelevelListener);

		hardlevelListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameconfigure.setLevel(2);
				imodel.startGame();
			}
		};
		hardLevel.addActionListener(hardlevelListener);

		exitGameItemListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imodel.exitGame();
			}
		};
		exitGameItem.addActionListener(exitGameItemListener);

		// ---------------

		musicEnableItemListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameconfigure.setMusicEnable(!gameconfigure.isMusicEnable());
			}
		};
		musicEnableItem.addActionListener(musicEnableItemListener);

		keyboardControlListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyOptionDialog keycontrolDialog = new KeyOptionDialog(
						mainframe);
				keycontrolDialog.show();

			}
		};
		keycontrol.addActionListener(keyboardControlListener);

		// ----------------

		englishRBListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameconfigure.setLanguage(LanguageSelect.ENGLISH);
				initMenuText();
			}
		};
		englishRB.addActionListener(englishRBListener);

		chinaRBlistener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameconfigure.setLanguage(LanguageSelect.CHINA);
				initMenuText();
			}
		};
		chinaRB.addActionListener(chinaRBlistener);
		// -------------
		aboutItmeListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutDialog ad = new AboutDialog(mainframe);
				ad.show();
			}
		};
		aboutItme.addActionListener(aboutItmeListener);

	}

	/**
	 * 此方法描述的是：初始化 menu
	 * @version 创建时间：Sep 21, 2010 10:10:05 AM 
	 * void
	 */
	private void initMenuText() {
		// --------------总菜单
		str.setLanguage(gameconfigure.getLanguage());
		gamemenu.setText(str.getString(1)); // 游戏
		gamemenu.setMnemonic('G');
		optionmenu.setText(str.getString(7)); // 选项
		optionmenu.setMnemonic('O');
		language.setText(str.getString(4)); // 语言
		language.setMnemonic('L');
		helpmenu.setText(str.getString(11)); // 帮助
		helpmenu.setMnemonic('H');
		// ----------------------游戏 子菜单
		newGameItem.setText(str.getString(2)); // 新游戏
		newGameItem.setMnemonic('N');

		easyLevel.setText(str.getString(19));
		easyLevel.setMnemonic('E');

		middelLevel.setText(str.getString(20));
		middelLevel.setMnemonic('M');

		hardLevel.setText(str.getString(21));
		hardLevel.setMnemonic('H');
		exitGameItem.setText(str.getString(3)); // 退出
		exitGameItem.setMnemonic('X');
		// ----------------------选项 子菜单
		musicEnableItem.setText(str.getString(9)); // music
		musicEnableItem.setMnemonic('M');
		keycontrol.setText(str.getString(8));
		// ----------------------语言子菜单
		englishRB.setText(str.getString(6));
		chinaRB.setText(str.getString(5));

		// --------------关于
		aboutItme.setText(str.getString(12));
	}

	/**
	 * 此方法描述的是：布局初始化 menu
	 * @version 创建时间：Sep 21, 2010 10:10:36 AM 
	 * void
	 */
	private void composeMenu() {
		menuBar.add(gamemenu);
		menuBar.add(optionmenu);
		menuBar.add(language);
		menuBar.add(helpmenu);
		// -----------
		gamemenu.add(newGameItem);
		gamemenu.addSeparator();
		levelButtonGroup.add(easyLevel);
		levelButtonGroup.add(middelLevel);
		levelButtonGroup.add(hardLevel);
		gamemenu.add(easyLevel);
		gamemenu.add(middelLevel);
		gamemenu.add(hardLevel);

		gamemenu.addSeparator();
		gamemenu.add(exitGameItem);
		// -----------
		optionmenu.add(musicEnableItem);
		optionmenu.addSeparator();
		optionmenu.add(keycontrol);
		// --------------
		languageGroup.add(chinaRB);
		languageGroup.add(englishRB);
		language.add(chinaRB);
		language.add(englishRB);
		// --------------
		helpmenu.add(aboutItme);
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMainframe(JFrame mainframe) {
		this.mainframe = mainframe;
	}

}
