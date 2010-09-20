package game.javaman.gswing;
/**
  * @author henry
  * www.riabbs.com
  *
  * @version 1.0
 */
public class LanguageSelect {
  public final static int CHINA = 1;
  public final static int ENGLISH = 2;
  String index[];
  String[] cn = new String[30];
  String[] en = new String[30];
  private static LanguageSelect instance = new LanguageSelect();
  public static synchronized LanguageSelect getInstance() {
    return instance;
  }
  private LanguageSelect() {
    cn[0] = "刘恒立";
    en[0] = "hengli liu";

    cn[1] = "游戏(G)";
    en[1] = "Game";

    cn[2] = "开始新游戏(S)";
    en[2] = "New Game";

    cn[3] = "退出(x)";
    en[3] = "Exit";

    cn[4] = "语言(L)";
    en[4] = "Language";

    cn[5] = "中文";
    en[5] = "China";

    cn[6] = "English";
    en[6] = "英文";

    cn[7] = "选项(O)";
    en[7] = "Option";

    cn[8] = "键盘设置";
    en[8] = "Control";

    cn[9] = "音乐(M)";
    en[9] = "Music";

    cn[10] = "级别";
    en[10] = "Level";

    cn[11] = "帮助(H)";
    en[11] = "Help";

    cn[12] = "关于";
    en[12] = "About";

    cn[13] = "向左走";
    en[13] = "Left";

    cn[14] = "向右走";
    en[14] = "Right";

    cn[15] = "停止游戏";
    en[15] = "Stop";

    cn[16] = "确定";
    en[16] = "Confirm";

    cn[17] = "取消";
    en[17] = "Cancel";

    cn[18] = "默认值";
    en[18] = "default";

    cn[19] = "初级";
    en[19] = "easy";

    cn[20] = "中级";
    en[20] = "middle";

    cn[21] = "高级";
    en[21] = "hard";

    cn[22] = "暂停";
    en[22] = "pause";
    index = cn;
  }

  public void setLanguage(int ConstantLan) {
    switch (ConstantLan) {
      case CHINA:
        index = cn;
        break;
      case ENGLISH:
        index = en;
        break;
      default:
        index = cn;
        break;
    }
  }

  public String getString(int position) {
    return index[position];
  }
}
