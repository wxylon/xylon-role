package test.swing;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;


public class KyodaiUI
    extends JFrame
    implements ActionListener {
  public final static int ROW = 8;
  public final static int COLUMN = 8;
  public static Color DarkColor = new Color(55, 77, 118); //��ɫ
  public static Color LightColor = new Color(111, 146, 212); //��ɫ

  Border border = BorderFactory.createBevelBorder(BevelBorder.LOWERED,
                                                  new Color(45, 92, 162),
                                                  new Color(43, 66, 97),
                                                  new Color(45, 92, 162),
                                                  new Color(84, 123, 200));
  JButton about = new JButton("����");

  public KyodaiUI() {
    this.setSize(780, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("ll��"); //���ñ���
    JPanel toolBar = new JPanel();
    toolBar.setBorder(border);
    toolBar.setPreferredSize(new Dimension(780, 48));

    JPanel actionPanel = new JPanel();
    actionPanel.setBorder(border);
    actionPanel.setPreferredSize(new Dimension(160, 380));

    JPanel contentPanel = new JPanel();
    contentPanel.setBorder(border);
    contentPanel.setPreferredSize(new Dimension(620, 380));

    this.getContentPane().add(toolBar, BorderLayout.NORTH);
    this.getContentPane().add(actionPanel, BorderLayout.EAST);
    this.getContentPane().add(contentPanel, BorderLayout.CENTER);

    toolBar.add(about);

    about.addActionListener(this);

    GridLayout gridLayout = new GridLayout(ROW, COLUMN);
    contentPanel.setLayout(gridLayout);

    JButton[] dots = new JButton[ROW * COLUMN];
    for (int i = 0; i < ROW * COLUMN; i++) {
      dots[i] = new JButton("Kyodai");
      dots[i].setActionCommand("" + i);
      contentPanel.add(dots[i]);
      dots[i].addActionListener(this);
    }

    actionPanel.setBackground(LightColor);


    Clock clock = new Clock();
    clock.start();
    actionPanel.add(clock);
  }

  public static void main(String[] args) throws HeadlessException {
    KyodaiUI kyodaiUI = new KyodaiUI();
    kyodaiUI.show();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == about) {
      JOptionPane.showMessageDialog(this, "�ҵĴ���", "����",
                                    JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    if (e.getSource()instanceof JButton) {
      JButton button = (JButton) e.getSource();
      int offset = Integer.parseInt(button.getActionCommand());
      int row, col;
      row = Math.round(offset / COLUMN);
      col = offset - row * COLUMN;
      JOptionPane.showMessageDialog(this, "ROW = " + row + ", COL = " + col,
                                    "��ť",
                                    JOptionPane.INFORMATION_MESSAGE);
    }
  }

}