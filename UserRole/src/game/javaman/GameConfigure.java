package game.javaman;

import java.io.*;

/**
 * 此类描述的是：游戏设置
 * @version 创建时间：Sep 21, 2010 9:41:21 AM
 */
public class GameConfigure implements Serializable {
	private static String configurefilename = "jman.conf";
	private boolean musicEnable = false;
	private int level;
	//向左键
	private int leftKeyCode;
	//向右键
	private int rightKeyCode;
	//暂停键
	private int pausekeyCode;
	private int language; // 1 为中文，2为英文
	private GameLevel[] glevel;
	transient private static GameConfigure instance = null;

	public static synchronized GameConfigure getInstance() {
		if (instance == null) {
			File configfile = new File(configurefilename);
			if (configfile.exists()) {
				try {
					ObjectInputStream ois = new ObjectInputStream(
							new FileInputStream(configfile));
					instance = (GameConfigure) ois.readObject();
				} catch (Exception ex) {
					instance = new GameConfigure();
					return instance;
				}
			} else {
				instance = new GameConfigure();
			}
		}
		return instance;
	}

	public void saveConfigure() {
		try {
			ObjectOutputStream objectoutputStream = new ObjectOutputStream(
					new FileOutputStream(configurefilename));
			objectoutputStream.writeObject(instance);
			objectoutputStream.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void defaultKeyOption() {
		leftKeyCode = 37;
		rightKeyCode = 39;
		pausekeyCode = 10;
	}

	private GameConfigure() {
		leftKeyCode = 37;
		rightKeyCode = 39;
		pausekeyCode = 10;
		language = 1;
		level = 0;
		glevel = new GameLevel[3];

		glevel[0] = new GameLevel();
		glevel[0].aYJman = 0.0005f;
		glevel[0].vXJman = 0.2f;
		glevel[0].vYBoard = -0.05f;
		glevel[0].vYBackGround = -0.02f;

		glevel[1] = new GameLevel();
		glevel[1].aYJman = 0.0005f;
		glevel[1].vXJman = 0.2f;
		glevel[1].vYBoard = -0.08f;
		glevel[1].vYBackGround = -0.02f;

		glevel[2] = new GameLevel();
		glevel[2].aYJman = 0.0005f;
		glevel[2].vXJman = 0.2f;
		glevel[2].vYBoard = -0.12f;
		glevel[2].vYBackGround = -0.02f;

	}

	public float getAYJman() {
		return glevel[level].aYJman;
	}

	public float getVXJman() {
		return glevel[level].vXJman;
	}

	public float getVYBoard() {
		return glevel[level].vYBoard;
	}

	public float getVYBackGround() {
		return glevel[level].vYBackGround;
	}

	private void readObject(ObjectInputStream ois)
			throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
	}

	public boolean isMusicEnable() {
		return musicEnable;
	}

	public void setMusicEnable(boolean musicEnable) {
		this.musicEnable = musicEnable;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLeftKeyCode() {
		return leftKeyCode;
	}

	public void setLeftKeyCode(int leftKeyCode) {
		this.leftKeyCode = leftKeyCode;
	}

	public int getRightKeyCode() {
		return rightKeyCode;
	}

	public void setRightKeyCode(int rightKeyCode) {
		this.rightKeyCode = rightKeyCode;
	}

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public int getPausekeyCode() {
		return pausekeyCode;
	}

	public void setPausekeyCode(int pausekeyCode) {
		this.pausekeyCode = pausekeyCode;
	}

	private class GameLevel implements Serializable {
		float vXJman;
		float aYJman;
		float vYBoard;
		float vYBackGround;

		public GameLevel() {

		}

		private void readObject(ObjectInputStream ois)
				throws ClassNotFoundException, IOException {
			ois.defaultReadObject();
		}

		private void writeObject(ObjectOutputStream oos) throws IOException {
			oos.defaultWriteObject();
		}
	}
}
