package com.xylon.swing;

import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import com.xylon.common.Common;

/////信息录入类

public class LuRuDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private Container jContentPane = null;
	private JButton jMenu1 = null;
	private JButton jMenu2 = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JComboBox comboBox = null;
	private JTextArea textArea4= null;
	private ButtonGroup bg = new ButtonGroup();
	DynamicTree tree;
	DefaultTableModel tableModel;

	LuRuDialog(DynamicTree tree, DefaultTableModel tableModel) {
		super();
		this.tree = tree;
		this.tableModel = tableModel;
		this.setTitle("Keyboard Setting");
		this.setModal(true);
		this.setResizable(false);
		// this.setSize(230, 284);
		this.setBounds(300, 0, 300, 400);
		jContentPane = this.getContentPane();
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

	private JButton getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new JButton();
			jMenu1.setBounds(new Rectangle(100, 320, 60, 30));
			jMenu1.setText("确定");
			jMenu1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					DefaultMutableTreeNode now = tree.getCurrentNode();
					tree.addObject(now, jTextField1.getText().trim());
					
					
					String[] temp = new String[4];
					temp[0] = jTextField1.getText().trim();
					temp[1] = jTextField2.getText().trim();
					temp[2] = String.valueOf(comboBox.getSelectedIndex());
					temp[3] = textArea4.getText().trim();
					
					tableModel.addRow(temp);
					
					Common.add(temp);
					
					close();
					
//					System.out.println(jTextField1.getText());
//					System.out.println(jTextField2.getText());
//					System.out.println(comboBox.getSelectedIndex());
//					System.out.println(textArea4.getText());
				}
			});
		}
		return jMenu1;
	}
	private JButton getJMenu2() {
		if (jMenu2 == null) {
			jMenu2 = new JButton();
			jMenu2.setBounds(new Rectangle(170, 320, 60, 30));
			jMenu2.setText("取消");
			jMenu2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					close();
				}
			});
		}
		return jMenu2;
	}
	
	private void close(){
		this.dispose();
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

//	public static void main(String[] args){
//		LuRuDialog luRu = new LuRuDialog();
//		luRu.setVisible(true);
//	}
}

