package game.javaman;

import java.util.*;
import game.javaman.gobject.Board;
import game.javaman.ginterface.IFloorCountListener;

/**
 * 此类描述的是：跳板管理  
 * @version 创建时间：Sep 21, 2010 10:44:59 AM
 */
public class BoardManager {
	// A---平板 B--左移 c--右移 d--翻板 e--上弹板 f--针板 共生成9个

	int width = 289; // 384-95;
	int height = 342;
	int hSpacing = 50;
	Random boardshapeRandom = new Random();
	Random boardXlocationRandom = new Random();
	LinkedList boards = new LinkedList();
	GameConfigure gameconfigure = GameConfigure.getInstance();
	GameObjectBuilder gameObjectBuilder = GameObjectBuilder.getInstance();
	IFloorCountListener floorCountListener;
	//当前关次
	int currentFloor = 0;
	//当前跳板
	int currentBoard = 0;

	public BoardManager() {
		boards.clear();
		currentFloor = 0;
		currentBoard = 0;
		for (int i = 0; i < 9; i++) {
			if (i == 6) {
				boards.add(getBoardA());
				continue;
			}
			boards.add(generateBoard());
		}
	}

	public Collection getBoards() {
		return boards;
	}

	public void update(long elapsedTime) {
		Iterator iterator = boards.iterator();
		while (iterator.hasNext()) {
			Board t = (Board) iterator.next();
			t.update(elapsedTime);
		}
		Board board = (Board) boards.getFirst();
		if (board.getYPos() < -16) {
			Board tempboard = generateBoard(); // ---------
			// 计算board 8个为一层
			checkUpdata();
			boards.addLast(tempboard);
			boards.removeFirst();
		}
	}

	private void checkUpdata() {
		currentBoard++;
		int tempFloor = currentBoard / 8;
		if (tempFloor != currentFloor) {
			currentFloor++;
			if (floorCountListener != null) {
				floorCountListener.updateFloorCount(currentFloor);
			}
		}
	}

	private Board generateBoard() {
		switch (gameconfigure.getLevel()) {
		case 0:
			return getlevel0();
		case 1:
			return getlevel1();
		case 2:
			return getlevel2();
		}
		return null;
	}

	private Board getBoardA() {
		float boardXlocation = boardXlocationRandom.nextInt(289) + 16;
		float boardYlocation = ((Board) boards.getLast()).getYPos() + hSpacing;
		Board tempBoard = gameObjectBuilder.getBoardA();
		tempBoard.setXPos(boardXlocation);
		tempBoard.setYPos(boardYlocation);
		return tempBoard;

	}

	private Board getlevel0() {
		int boardShape = boardshapeRandom.nextInt(90);
		float boardXlocation = boardXlocationRandom.nextInt(289) + 16;
		float boardYlocation = 0;
		if (boards.size() == 0) {
			boardYlocation = 0;
		} else {
			boardYlocation = ((Board) boards.getLast()).getYPos() + hSpacing;
		}
		// int boardYlocation
		Board tempBoard = null;
		if (boardShape < 30) {
			tempBoard = gameObjectBuilder.getBoardA();
		} else if (30 <= boardShape && boardShape < 40) {
			tempBoard = gameObjectBuilder.getBoardB();
		} else if (40 <= boardShape && boardShape < 50) {
			tempBoard = gameObjectBuilder.getBoardC();
		} else if (50 <= boardShape && boardShape < 60) {
			tempBoard = gameObjectBuilder.getBoardD(); // ----------------
		} else if (60 <= boardShape && boardShape < 70) {
			tempBoard = gameObjectBuilder.getBoardE();
		} else if (70 <= boardShape && boardShape < 90) {
			tempBoard = gameObjectBuilder.getBoardF();
		}

		tempBoard.setXPos(boardXlocation);
		tempBoard.setYPos(boardYlocation);
		return tempBoard;
	}

	private Board getlevel1() {
		int boardShape = boardshapeRandom.nextInt(90);
		float boardXlocation = boardXlocationRandom.nextInt(289) + 16;
		float boardYlocation = 0;
		if (boards.size() == 0) {
			boardYlocation = 0;
		} else {
			boardYlocation = ((Board) boards.getLast()).getYPos() + hSpacing;
		}
		// int boardYlocation
		Board tempBoard = null;
		if (boardShape < 20) {
			tempBoard = gameObjectBuilder.getBoardA();
		} else if (20 <= boardShape && boardShape < 30) {
			tempBoard = gameObjectBuilder.getBoardB();
		} else if (30 <= boardShape && boardShape < 40) {
			tempBoard = gameObjectBuilder.getBoardC();
		} else if (40 <= boardShape && boardShape < 60) {
			tempBoard = gameObjectBuilder.getBoardD(); // ----------------
		} else if (60 <= boardShape && boardShape < 70) {
			tempBoard = gameObjectBuilder.getBoardE();
		} else if (70 <= boardShape && boardShape < 90) {
			tempBoard = gameObjectBuilder.getBoardF();
		}

		tempBoard.setXPos(boardXlocation);
		tempBoard.setYPos(boardYlocation);
		return tempBoard;
	}

	private Board getlevel2() {
		int boardShape = boardshapeRandom.nextInt(90);
		float boardXlocation = boardXlocationRandom.nextInt(289) + 16;
		float boardYlocation = 0;
		if (boards.size() == 0) {
			boardYlocation = 0;
		} else {
			boardYlocation = ((Board) boards.getLast()).getYPos() + hSpacing;
		}
		// int boardYlocation
		Board tempBoard = null;
		if (boardShape < 10) {
			tempBoard = gameObjectBuilder.getBoardA();
		} else if (10 <= boardShape && boardShape < 20) {
			tempBoard = gameObjectBuilder.getBoardB();
		} else if (20 <= boardShape && boardShape < 30) {
			tempBoard = gameObjectBuilder.getBoardC();
		} else if (30 <= boardShape && boardShape < 60) {
			tempBoard = gameObjectBuilder.getBoardD(); // ----------------
		} else if (60 <= boardShape && boardShape < 70) {
			tempBoard = gameObjectBuilder.getBoardE();
		} else if (70 <= boardShape && boardShape < 90) {
			tempBoard = gameObjectBuilder.getBoardF();
		}

		tempBoard.setXPos(boardXlocation);
		tempBoard.setYPos(boardYlocation);
		return tempBoard;
	}

	public Board getManFirstBoard() {
		return (Board) boards.get(6); // 第六个在初始化时生成的为boarda平板
	}

	public void setFloorCountListener(IFloorCountListener floorCountListener) {
		this.floorCountListener = floorCountListener;
	}

}
