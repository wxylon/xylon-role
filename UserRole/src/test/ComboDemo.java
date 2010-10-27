package test;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.Container;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class ComboDemo extends JFrame implements ActionListener {
    JComboBox combo;
    String planets[] = { "Mercury","Venus","Earth","Mars",
        "Jupiter","Saturn","Uranus","Neptune","Pluto" };
    public static void main(String arg[]) {
        new ComboDemo();
    }
    public ComboDemo() {
        int height;
        int width;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        } );
        setLocation(250,150);
        Container pane = getContentPane();
        pane.setLayout(null);
        Insets insets = pane.getInsets();

        combo = new JComboBox(planets);//创建下拉列表的同时把内容也填进去了。
        combo.setSelectedIndex(2);//设置默认索引为2
        combo.addActionListener(this);
        Dimension dim = combo.getPreferredSize();
        int x = insets.left + 20;
        int y = insets.top + 20;
        combo.setBounds(x,y,dim.width,dim.height);
        pane.add(combo);

        width = x + dim.width + 20 + insets.left;
        height = y + dim.height + 40 + insets.bottom;

        setSize(width,height);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String str = (String)combo.getSelectedItem();//获取所选的内容
        System.out.println(str);
        int index = combo.getSelectedIndex();
        System.out.println("index=" + index);//获取所选的索引
    }
}
