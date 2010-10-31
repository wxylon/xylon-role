package com.xylon.image;

import javax.swing.ImageIcon;

/**
 * 此类描述的是：游戏区图片管理
 * @version 创建时间：Sep 20, 2010 11:37:24 PM
 */
public class ImageManager {
	ImageFactory images = ImageFactory.getInstance();
	ImageIcon[] locationImages = new ImageIcon[3];
	private static ImageManager instance = new ImageManager();

	public static ImageManager getInstance() {
		return instance;
	}

	private ImageManager() {
		locationImages[0] = new ImageIcon(images.getImage("images/close.gif")); // 闭文件夹
		locationImages[1] = new ImageIcon(images.getImage("images/open.gif")); // 开文件夹
		locationImages[2] = new ImageIcon(images.getImage("images/mac_man.jpg")); // 开文件夹
	}

	public ImageIcon getLocationImage(int num) {
		return locationImages[num]; 
	}
}
