package test;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.*;
import java.awt.Rectangle;

public class STUManage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenuItem jMenuItem = null;
	private JMenuItem jMenuItem1 = null;
	private JMenuItem jMenuItem2 = null;
	private JMenuItem jMenuItem3 = null;

	/**
	 * This is the default constructor
	 */
	public STUManage() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 263);
		this.setJMenuBar(getJJMenuBar());
		this.setForeground(Color.red);
		this.setContentPane(getJContentPane());
		this.setTitle("");
		this.setVisible(true);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setText("信息录入窗口");
			jLabel.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabel.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel.setName("jLabel");
			jContentPane = new JPanel();
			jContentPane.setLayout(new CardLayout());
			jContentPane.add(jLabel, jLabel.getName());
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setText("系统选项");
			jMenu.setActionCommand("菜单选项");
			jMenu.add(getJMenuItem());
			jMenu.add(getJMenuItem1());
			jMenu.add(getJMenuItem2());
			jMenu.add(getJMenuItem3());
		}
		return jMenu;
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.setText("录入学生基本信息");
			jMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					LuRu lu = new LuRu();
					lu.setVisible(true);
				}
			});
		}
		return jMenuItem;
	}

	/**
	 * This method initializes jMenuItem1
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("修改学生基本信息");
		}
		return jMenuItem1;
	}

	/**
	 * This method initializes jMenuItem2
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setText("查询学生基本信息");
		}
		return jMenuItem2;
	}

	/**
	 * This method initializes jMenuItem3
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem3() {
		if (jMenuItem3 == null) {
			jMenuItem3 = new JMenuItem();
			jMenuItem3.setText("删除学生基本信息");
		}
		return jMenuItem3;
	}

	public static void main(String args[]) {
		new STUManage();
	}

	// ///信息录入类

	class LuRu extends JFrame {

		private static final long serialVersionUID = 1L;
		private JPanel jContentPane = null;
		private JMenu jMenu1 = null;
		private JMenu jMenu2 = null;
		private JLabel jLabel1 = null;
		private JLabel jLabel2 = null;
		private JLabel jLabel3 = null;
		private JLabel jLabel4 = null;
		private JTextField jTextField1 = null;
		private JTextField jTextField2 = null;
		private JComboBox comboBox = null;
		private JTextArea textArea4= null;
		private ButtonGroup bg = new ButtonGroup();

		LuRu() {
			super();
			initialize();
		}
		private void initialize() {
			this.setSize(300, 400);
			this.setContentPane(getJContentPane());
			this.setTitle("");
			this.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					LuRu.this.dispose();
				}
			});
		}

		private JPanel getJContentPane() {
			if (jContentPane == null) {
				
				jLabel1 = new JLabel();
				jLabel1.setBounds(new Rectangle(37, 44, 39, 18));
				jLabel1.setText("姓名");
				jLabel2 = new JLabel();
				jLabel2.setBounds(new Rectangle(37, 106, 39, 18));
				jLabel2.setText("年级");
				jLabel3 = new JLabel();
				jLabel3.setBounds(new Rectangle(26, 137, 60, 18));
				jLabel3.setText("平均成绩");
				jLabel4 = new JLabel();
				jLabel4.setBounds(new Rectangle(26, 168, 60, 18));
				jLabel4.setText("个人简介");
				jContentPane = new JPanel();
				jContentPane.setLayout(null);
				jContentPane.add(jLabel1, null);
				jContentPane.add(jLabel2, null);
				jContentPane.add(jLabel3, null);
				jContentPane.add(jLabel4, null);
				jContentPane.add(getJTextField1(), null);
				jContentPane.add(getJTextField2(), null);
				jContentPane.add(getJComboBox(), null);
				jContentPane.add(getJTextArea4(), null);
				jContentPane.add(getJMenu1(), null);
				jContentPane.add(getJMenu2(), null);
			}
			return jContentPane;
		}


		private JMenu getJMenu1() {
			if (jMenu1 == null) {
				jMenu1 = new JMenu();
				jMenu1.setBounds(new Rectangle(100, 320, 50, 18));
				jMenu1.setText("确定");
			}
			return jMenu1;
		}
		private JMenu getJMenu2() {
			if (jMenu2 == null) {
				jMenu2 = new JMenu();
				jMenu2.setBounds(new Rectangle(170, 320, 50, 18));
				jMenu2.setText("取消");
			}
			return jMenu2;
		}
		private JComboBox getJComboBox() {
			if (comboBox == null) {
			    String planets[] = { "一年级","二年级","三年级","四年级","五年级","六年级"};
			    comboBox = new JComboBox(planets);
			    comboBox.setBounds(new Rectangle(85, 106, 155, 25));
			}
			return comboBox;
		}

		private JTextField getJTextField1() {
			if (jTextField1 == null) {
				jTextField1 = new JTextField();
				jTextField1.setBounds(new Rectangle(85, 44, 155, 18));
			}
			return jTextField1;
		}

		private JTextField getJTextField2() {
			if (jTextField2 == null) {
				jTextField2 = new JTextField();
				jTextField2.setBounds(new Rectangle(85, 137, 155, 18));
			}
			return jTextField2;
		}

		private JTextArea getJTextArea4() {
			if (textArea4 == null) {
				textArea4 = new JTextArea();
				textArea4.setBounds(new Rectangle(85, 168, 155, 100));
			}
			return textArea4;
		}

	}

}
