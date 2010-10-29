package com.xylon.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

//维护表格
public class JTableDefaultTableModelTest extends JFrame {

	private DefaultTableModel tableModel; // 表格模型对象
	private JTable table;

	public JTableDefaultTableModelTest() {
		super();
		setTitle("表格");
		setBounds(100, 100, 500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[] columnNames = { "姓名", "性别", "平均成绩", "个人简介"}; // 列名
		String[][] tableVales = { { "小三", "男", "80", "我是个好同学1"}, {"小四", "男", "70", "我是个好同学2"},
				{ "小李", "男", "90", "我是个好同学3" }, {"小黑", "男", "60", "我是个好同学4" }, { "小陈", "男", "90", "我是个好同学5"} }; // 数据
		tableModel = new DefaultTableModel(tableVales, columnNames);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table); // 支持滚动
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		// 排序:
		// table.setRowSorter(new TableRowSorter(tableModel));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 单选
		table.addMouseListener(new MouseAdapter() { // 鼠标事件
					public void mouseClicked(MouseEvent e) {
//						int selectedRow = table.getSelectedRow(); // 获得选中行索引
//						Object oa = tableModel.getValueAt(selectedRow, 0);
//						Object ob = tableModel.getValueAt(selectedRow, 1);
//						aTextField.setText(oa.toString()); // 给文本框赋值
//						bTextField.setText(ob.toString());
					}
				});
		scrollPane.setViewportView(table);
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		final JButton addButton = new JButton("添加"); // 添加按钮
		addButton.addActionListener(new ActionListener() {// 添加事件
					public void actionPerformed(ActionEvent e) {
//						String[] rowValues = { aTextField.getText(),
//								bTextField.getText() };
//						tableModel.addRow(rowValues); // 添加一行
//						int rowCount = table.getRowCount() + 1; // 行数加上1
//						aTextField.setText("A" + rowCount);
//						bTextField.setText("B" + rowCount);
					}
				});
		panel.add(addButton);

		final JButton delButton = new JButton("删除");
		delButton.addActionListener(new ActionListener() {// 添加事件
					public void actionPerformed(ActionEvent e) {
						int selectedRow = table.getSelectedRow();// 获得选中行的索引
						if (selectedRow != -1) // 存在选中行
						{
							tableModel.removeRow(selectedRow); // 删除行
						}
					}
				});
		panel.add(delButton);
		
		final JButton exitButton = new JButton("关闭");
		exitButton.addActionListener(new ActionListener() {// 关闭事件
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(exitButton);
	}

	public static void main(String[] args) {
		JTableDefaultTableModelTest jTableDefaultTableModelTest = new JTableDefaultTableModelTest();
		jTableDefaultTableModelTest.setVisible(true);
	}

}
