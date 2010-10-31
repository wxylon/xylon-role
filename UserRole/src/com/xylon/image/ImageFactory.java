package com.xylon.image;

import javax.swing.ImageIcon;
import java.util.*;
import java.awt.*;

/**
 * 此类描述的是：图片工厂类
 * @version 创建时间：Sep 20, 2010 6:04:42 PM
 */
public class ImageFactory {
	HashMap hashmap = new HashMap();
	private static ImageFactory instance = new ImageFactory();

	public static ImageFactory getInstance() {
		return instance;
	}

	public Image getImage(String image) {
		return getImageIcon(image).getImage();
	}

	public ImageIcon getImageIcon(String image) {
		ImageIcon imageicon = (ImageIcon) hashmap.get(image);
		if (imageicon != null) {
			return imageicon;
		}
		String realposition = image;
		imageicon = new ImageIcon(getClass().getResource(realposition));
		hashmap.put(image, imageicon);
		return imageicon;
	}
}
