package com.xylon.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import com.xylon.common.Common;

public class MainApp extends JPanel{

	private DynamicTree treePanel;
	private JTablePanel tablePanel;
	public MainApp() {
		super(new BorderLayout());

		treePanel = new DynamicTree();
		populateTree(treePanel);
		
		treePanel.setPreferredSize(new Dimension(150, 300));
		add(treePanel, BorderLayout.WEST);

		tablePanel = new JTablePanel(treePanel);
		treePanel.setTablePanel(tablePanel);
		add(tablePanel, BorderLayout.CENTER);
	}

	public void populateTree(DynamicTree treePanel) {
		DefaultMutableTreeNode p1, p2;
		for(int j = 0; j < 6; j++){
			p1 = treePanel.addObject(null, Common.grade.get(String.valueOf(j)));
			for(int i = 0; i < Common.index; i++){
				if(String.valueOf(j).equals(Common.tableVales[i][1])){
					p2 = treePanel.addObject(p1, Common.tableVales[i][0]);
					Common.treepath.put(new TreePath(p2.getPath()), i);
				}
			}
		}
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("信息管理");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(300, 150);
		MainApp newContentPane = new MainApp();
		newContentPane.setOpaque(true); 
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
