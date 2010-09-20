package game.javaman.image;

import game.henry.game.*;
import java.util.*;

public class LImageManager {
  ImageFactory images = ImageFactory.getInstance();
  LocationImage[] locationImages = new LocationImage[60];
  private static LImageManager instance=new LImageManager();
  public static LImageManager getInstance() {
    return instance;
  }
  private LImageManager() {
    locationImages[0] = new LocationImage(images.getImage("images/back2.gif")); //背景
    locationImages[1] = new LocationImage(images.getImage("images/border.gif")); //左右边框
    locationImages[2] = new LocationImage(images.getImage(
        "images/board/board_top.gif")); //上针板
    //------------------------------
    locationImages[3] = new LocationImage(images.getImage(
        "images/board/board_a.gif"));
    locationImages[4] = new LocationImage(images.getImage(
        "images/board/board_b1.gif"));
    locationImages[5] = new LocationImage(images.getImage(
        "images/board/board_b2.gif"));
    locationImages[6] = new LocationImage(images.getImage(
        "images/board/board_b3.gif"));
    locationImages[7] = new LocationImage(images.getImage(
        "images/board/board_b4.gif"));
    locationImages[8] = new LocationImage(images.getImage(
        "images/board/board_c1.gif"));
    locationImages[9] = new LocationImage(images.getImage(
        "images/board/board_c2.gif"));
    locationImages[10] = new LocationImage(images.getImage(
        "images/board/board_c3.gif"));
    locationImages[11] = new LocationImage(images.getImage(
        "images/board/board_c4.gif"));
    //有相对位置需要设置
    locationImages[12] = new LocationImage(images.getImage(
        "images/board/board_d1.gif"));
    locationImages[13] = new LocationImage(images.getImage(
        "images/board/board_d2.gif"), 0, -7);
    locationImages[14] = new LocationImage(images.getImage(
        "images/board/board_d3.gif"), 0, -10);
    locationImages[15] = new LocationImage(images.getImage(
        "images/board/board_d4.gif"), 0, -8);
    locationImages[16] = new LocationImage(images.getImage(
        "images/board/board_d5.gif"), 0, -10);
    locationImages[17] = new LocationImage(images.getImage(
        "images/board/board_d6.gif"), 0, -7);

    locationImages[18] = new LocationImage(images.getImage(
        "images/board/board_e1.gif"), 0, -8);
    locationImages[19] = new LocationImage(images.getImage(
        "images/board/board_e2.gif"), 0, -6);
    locationImages[20] = new LocationImage(images.getImage(
        "images/board/board_e3.gif"), 0, -4);
    locationImages[21] = new LocationImage(images.getImage(
        "images/board/board_e4.gif"), 0, -2);
    locationImages[22] = new LocationImage(images.getImage(
        "images/board/board_e5.gif"), 0, 0);
    locationImages[23] = new LocationImage(images.getImage(
        "images/board/board_e6.gif"), 0, 2);
    locationImages[24] = new LocationImage(images.getImage(
        "images/board/board_e7.gif"), 0, 4);
    //-----------------------------------------------
    locationImages[25] = new LocationImage(images.getImage(
        "images/board/board_f.gif"),0,-16);
    //--------------javaman----------------------
    locationImages[26] = new LocationImage(images.getImage(
        "images/man/javaman_c1_b.gif"), 1, -2);
    locationImages[27] = new LocationImage(images.getImage(
        "images/man/javaman_c1.gif"), 2, 0);

    locationImages[28] = new LocationImage(images.getImage(
        "images/man/javaman_c2_b.gif"), -1, -2);
    locationImages[29] = new LocationImage(images.getImage(
        "images/man/javaman_c2.gif"), 0, 0);

    locationImages[30] = new LocationImage(images.getImage(
        "images/man/javaman_c3_b.gif"), 1, -2);
    locationImages[31] = new LocationImage(images.getImage(
        "images/man/javaman_c3.gif"), 0, 0);
    locationImages[32] = new LocationImage(images.getImage(
        "images/man/javaman_l1_b.gif"), -0.5f, -2);
    locationImages[33] = new LocationImage(images.getImage(
        "images/man/javaman_l1.gif"), 0.5f, 0);

    locationImages[34] = new LocationImage(images.getImage(
        "images/man/javaman_l2_b.gif"), 3.5f, -2);

    locationImages[35] = new LocationImage(images.getImage(
        "images/man/javaman_l3_b.gif"), -1, -2);

    locationImages[36] = new LocationImage(images.getImage(
        "images/man/javaman_l3.gif"), 0, 0);

    locationImages[37] = new LocationImage(images.getImage(
        "images/man/javaman_ld1_b.gif"), 2, -2);
    locationImages[38] = new LocationImage(images.getImage(
        "images/man/javaman_ld1.gif"), 3, 0);

    locationImages[39] = new LocationImage(images.getImage(
        "images/man/javaman_ld2_b.gif"), 2.5f, -2);
    locationImages[40] = new LocationImage(images.getImage(
        "images/man/javaman_ld2.gif"), 2.5f, 0);

    locationImages[41] = new LocationImage(images.getImage(
        "images/man/javaman_ld3_b.gif"), 2.5f, -2);
    locationImages[42] = new LocationImage(images.getImage(
        "images/man/javaman_ld3.gif"), 2.5f, 0);

    locationImages[43] = new LocationImage(images.getImage(
        "images/man/javaman_r1_b.gif"), -1, -2);
    locationImages[44] = new LocationImage(images.getImage(
        "images/man/javaman_r1.gif"), 0.5f, 0);

    locationImages[45] = new LocationImage(images.getImage(
        "images/man/javaman_r2_b.gif"), 3.5f, -2);
    locationImages[46] = new LocationImage(images.getImage(
        "images/man/javaman_r2.gif"), 4.5f, 0);

    locationImages[47] = new LocationImage(images.getImage(
        "images/man/javaman_r3_b.gif"), -1.5f, -2);
    locationImages[48] = new LocationImage(images.getImage(
        "images/man/javaman_r3.gif"), 0, 0);

    locationImages[49] = new LocationImage(images.getImage(
        "images/man/javaman_rd1_b.gif"), 2.5f, -2);
    locationImages[50] = new LocationImage(images.getImage(
        "images/man/javaman_rd1.gif"), 3.5f, 0);
    locationImages[51] = new LocationImage(images.getImage(
        "images/man/javaman_rd2_b.gif"), 2, -2);
    locationImages[52] = new LocationImage(images.getImage(
        "images/man/javaman_rd2.gif"), 3, 0);
    locationImages[53] = new LocationImage(images.getImage(
        "images/man/javaman_rd3_b.gif"), 2.5f, -2);
    locationImages[54] = new LocationImage(images.getImage(
        "images/man/javaman_rd3.gif"), 2.5f, 0);
    locationImages[55] = new LocationImage(images.getImage(
        "images/man/javaman_l2.gif"), 2, 0);
    locationImages[56] = new LocationImage(images.getImage(
        "images/man/javaman_s.gif"), 0, 0); //以此为标准
    locationImages[57] = new LocationImage(images.getImage(
        "images/man/javaman_s_b.gif"), 0, -2);
    //---------------------------------------------------
//    locationImages
  }

  public LocationImage getLocationImage(int num) {
    return locationImages[num]; //(LocationImage) frames.get(new Integer(num));
  }
  public LocationImage getSpriteImage(Sprite sprite) {
    LocationImage li = (LocationImage) (getLocationImage(sprite.
        getCurrentFrameNum()).clone());
    li.setXPos(sprite.getXPos() + li.getXPos());
    li.setYPos(sprite.getYPos() + li.getYPos());
    return li;
  }
}
