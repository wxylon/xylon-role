package com.xylon.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
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
		//加载皮肤
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "未找到新皮肤，请升级JDK到6.0 update 10");
		}
		try {
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			
//			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
//			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
//			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
//			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
//			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
//			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
//			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
//			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel"); 
			
//			1、Metal风格 (默认) 
//			String lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel"; 
//			UIManager.setLookAndFeel(lookAndFeel); 
//			2、Windows风格 
//			String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"; 
//			UIManager.setLookAndFeel(lookAndFeel); 
////			3、Windows Classic风格 
//			String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel"; 
//			UIManager.setLookAndFeel(lookAndFeel); 
////			4、Motif风格 
//			String lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel"; 
//			UIManager.setLookAndFeel(lookAndFeel); 
////			5、Mac风格 (需要在相关的操作系统上方可实现) 
//			String lookAndFeel = "com.sun.java.swing.plaf.mac.MacLookAndFeel"; 
//			UIManager.setLookAndFeel(lookAndFeel); 
////			6、GTK风格 (需要在相关的操作系统上方可实现) 
//			String lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel"; 
//			UIManager.setLookAndFeel(lookAndFeel); 
////			7、可跨平台的默认风格 
//			String lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName(); 
//			UIManager.setLookAndFeel(lookAndFeel); 
////			8、当前系统的风格 
			String lookAndFeel = UIManager.getSystemLookAndFeelClassName(); 
			UIManager.setLookAndFeel(lookAndFeel); 
		} catch (Exception evt) {
		}
		createAndShowGUI();
		
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				createAndShowGUI();
//			}
//		});
	}
}
