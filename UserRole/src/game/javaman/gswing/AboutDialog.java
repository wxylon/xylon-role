package game.javaman.gswing;

/**
 * @author henry
 * www.riabbs.com
 *
 * @version 1.0
 */
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import game.javaman.image.*;

/**
 * 此类描述的是：关于界面  
 * @version 创建时间：Sep 21, 2010 10:23:58 AM
 */
public class AboutDialog extends JDialog {
	JPanel panel1 = new JPanel();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JTextArea jTextArea1 = new JTextArea();
	JButton jButton1 = new JButton();

	public AboutDialog(Frame frame) {
		super(frame, "关于", true);
		init();
		this.setSize(300, 270);
		this.setBounds((int) frame.getX() + 20, (int) frame.getY() + 75, 300,270);
	}

	private void init() {
		panel1.setLayout(null);
		jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
		jLabel1.setToolTipText("");
		jLabel1.setText("JavaMan100  v1.0");
		jLabel1.setBounds(new Rectangle(67, 12, 172, 26));
		ImageFactory imagefactory = ImageFactory.getInstance();
		jLabel2.setIcon(imagefactory.getImageIcon("images/JavaCup32.png"));
		jLabel2.setBounds(new Rectangle(16, 12, 36, 58));
		jTextArea1.setBackground(UIManager.getColor("CheckBox.background"));
		jTextArea1
				.setText("作者：Henry\nMSN:henryevol@hotmail.com\nQQ:39024198\n网站:www.riabbs.com\n\n版权所有(c) 2008");
		jTextArea1.setBounds(new Rectangle(66, 44, 204, 130));
		jTextArea1.setEditable(false);
		this.setName("dialog0");
		this.setResizable(false);
		jButton1.setBounds(new Rectangle(176, 190, 60, 24));
		jButton1.setText("确定");
		jButton1.addActionListener(new AboutDialog_jButton1_actionAdapter(this));
		getContentPane().add(panel1);
		panel1.add(jLabel2, null);
		panel1.add(jLabel1, null);
		panel1.add(jTextArea1, null);
		panel1.add(jButton1, null);
	}

	void jButton1_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultLookAndFeelDecorated(true);
		AboutDialog dialog = new AboutDialog(frame);
		dialog.show();
	}
}

class AboutDialog_jButton1_actionAdapter implements
		java.awt.event.ActionListener {

	AboutDialog adaptee;

	AboutDialog_jButton1_actionAdapter(AboutDialog adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionPerformed(e);
	}
	
}

