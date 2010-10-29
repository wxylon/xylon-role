package com.xylon.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

import com.xylon.common.Common;

public class MainApp extends JPanel{

	private DynamicTree treePanel;

	public MainApp() {
		super(new BorderLayout());

		// Create the components.
		treePanel = new DynamicTree();
		populateTree(treePanel);
		
		// Lay everything out.
		treePanel.setPreferredSize(new Dimension(150, 300));
		add(treePanel, BorderLayout.WEST);

		JPanel panel = new JTablePanel(treePanel);
//		panel.add(addButton);
//		panel.add(removeButton);
//		panel.add(clearButton);
		add(panel, BorderLayout.CENTER);
	}

	public void populateTree(DynamicTree treePanel) {
		DefaultMutableTreeNode p1;
		for(int j = 1; j <= 6; j++){
			p1 = treePanel.addObject(null, Common.grade.get(String.valueOf(j)));
			for(int i = 0; i < Common.index; i++){
				if(String.valueOf(j).equals(Common.tableVales[i][1])){
					treePanel.addObject(p1, Common.tableVales[i][0]);
				}
			}
		}
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("信息管理");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
