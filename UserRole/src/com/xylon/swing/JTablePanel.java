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

import com.xylon.api.IDynamicTable;
import com.xylon.common.Common;

//维护表格
public class JTablePanel extends JPanel implements IDynamicTable, ActionListener{

	private DefaultTableModel tableModel; // 表格模型对象
	private JTable table;
	private final static String ADD_COMMAND = "add";
	private final static String REMOVE_COMMAND = "remove";
	private final static String EXIT_COMMAND = "exit";
	private DynamicTree treePanel;
	
	public JTablePanel(DynamicTree treePanel) {
		super(new BorderLayout());
		this.treePanel = treePanel;
		setBounds(100, 100, 500, 400);
		tableModel = new DefaultTableModel(Common.getCurrentArray(), Common.columnNames);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table); // 支持滚动
		add(scrollPane, BorderLayout.CENTER);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 单选
		scrollPane.setViewportView(table);
		
		final JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		final JButton addButton = new JButton("添加"); // 添加按钮
		addButton.addActionListener(this);
		addButton.setActionCommand(ADD_COMMAND);
		panel.add(addButton);
		final JButton delButton = new JButton("删除");
		delButton.addActionListener(this);
		delButton.setActionCommand(REMOVE_COMMAND);
		panel.add(delButton);
		final JButton exitButton = new JButton("关闭");
		exitButton.addActionListener(this);
		exitButton.setActionCommand(EXIT_COMMAND);
		panel.add(exitButton);
	}

	public void addCurrentColumn(Object object) {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (ADD_COMMAND.equals(command)) {
			LuRuDialog keycontrolDialog = new LuRuDialog(treePanel, tableModel);
			keycontrolDialog.show();
			//treePanel.addObject("New Node " + newNodeSuffix++);
		} else if (REMOVE_COMMAND.equals(command)) {
			String name = treePanel.removeCurrentNode();
			int k = Common.search(name.trim());
			if(k < 0){
			}else{
				int index = removeCurrentColumn(k);
				Common.delete(k);
			}
		} else if (EXIT_COMMAND.equals(command)) {
			// Clear button clicked.
			System.exit(0);
		}
	}

	public int removeCurrentColumn(int selectedRow) {
//		int selectedRow = table.getSelectedRow();// 获得选中行的索引
		// 存在选中行
		if (selectedRow != -1) {
			tableModel.removeRow(selectedRow); // 删除行
		}
		return selectedRow;
	}
}
