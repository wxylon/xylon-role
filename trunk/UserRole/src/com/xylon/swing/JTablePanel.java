package com.xylon.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.TreePath;

import com.xylon.api.IDynamicTable;
import com.xylon.common.Common;

//维护表格
public class JTablePanel extends JPanel implements IDynamicTable, ActionListener, MouseListener{

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
		table.addMouseListener(this);
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
			LuRuDialog keycontrolDialog = new LuRuDialog(treePanel, this);
			keycontrolDialog.show();
			//treePanel.addObject("New Node " + newNodeSuffix++);
		} else if (REMOVE_COMMAND.equals(command)) {
			TreePath treePath = null;
			int k = -1;
			if(null != (treePath = treePanel.removeCurrentNode())){
				k = Common.treepath.get(treePath);
				int index = removeCurrentColumn(k);
				Common.delete(k,treePath);
			}else if(-1 < (k = removeCurrentColumn())){
				treePath = Common.getTreePath(k);
				treePanel.removeCurrentNode(treePath);
				Common.delete(k,treePath);
			}
			
		} else if (EXIT_COMMAND.equals(command)) {
			// Clear button clicked.
			System.exit(0);
		}
	}
	
	public int removeCurrentColumn() {
		int selectedRow = table.getSelectedRow();// 获得选中行的索引
		System.out.println("sssssss"+selectedRow);
		// 存在选中行
		if (selectedRow != -1) {
			tableModel.removeRow(selectedRow); // 删除行
		}
		return selectedRow;
	}

	public int removeCurrentColumn(int selectedRow) {
		// 存在选中行
		if (selectedRow != -1) {
			tableModel.removeRow(selectedRow); // 删除行
		}
		return selectedRow;
	}
	
	public void addTheColume(String[] temp){
		tableModel.addRow(temp);
		System.out.println(Common.getCurrentArray().length+"----->"+tableModel.getRowCount());
		table.updateUI();
	}
	
	public void selectRow(int index){
//		System.out.println(index);
//		table.addColumnSelectionInterval(index, index);
//		System.out.println("选中："+table.getSelectedColumn());
	}

	public void mouseClicked(MouseEvent e) {
		int selectedRow = table.getSelectedRow();
		if(-1 < selectedRow){
			TreePath path = null;
			if(null != (path = Common.getTreePath(selectedRow))){
				System.out.println(path);
				treePanel.selectRow(path);
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
