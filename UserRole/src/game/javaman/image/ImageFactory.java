package game.javaman.image;

import javax.swing.ImageIcon;
import java.util.*;
import java.awt.*;

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
