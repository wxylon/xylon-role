package com.xylon.swing;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import com.xylon.api.IDynamicTree;
import com.xylon.common.Common;
import com.xylon.common.MyDefaultTreeCellRenderer;

public class DynamicTree extends JPanel implements IDynamicTree, MouseListener{
	
	protected DefaultMutableTreeNode rootNode;
	protected DefaultTreeModel treeModel;
	protected JTree tree;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	JTablePanel tablePanel;

	public DynamicTree() {
		super(new GridLayout(1, 0));

		rootNode = new DefaultMutableTreeNode("学生信息");
		tree = new JTree(rootNode);
		treeModel = (DefaultTreeModel) tree.getModel();
		tree.setCellRenderer(new MyDefaultTreeCellRenderer());
		tree.setEditable(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);
		tree.addMouseListener(this);

		JScrollPane scrollPane = new JScrollPane(tree);
		add(scrollPane);
	}

	/** Remove all nodes except the root node. */
	public void clear() {
		rootNode.removeAllChildren();
		treeModel.reload();
	}
	
	public void removeCurrentNode(TreePath currentSelection) {
		if (currentSelection != null && null != Common.treepath.get(currentSelection)) {
			DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection
					.getLastPathComponent());
			MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
			System.out.println(currentNode.getUserObject());
			
			if (parent != null) {
				treeModel.removeNodeFromParent(currentNode);
			}
		}
		toolkit.beep();
	}
	
	public DefaultMutableTreeNode findUserObject(int i) {
		Object object = Common.grade.get(String.valueOf(i));
		Enumeration e = rootNode.breadthFirstEnumeration();
	    while (e.hasMoreElements()) {
	       DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
//	       System.out.println("---->1:"+object.toString());
//	       System.out.println("---->2:"+node.getUserObject().toString());
	       if (node.getUserObject().equals(object)){
//	    	   System.out.println("---->3:"+new TreePath(node.getPath()).toString());
	    	   return node;
	       }
	    	   
	    }
	    return null;
	}

	/** Remove the currently selected node. */
	public TreePath removeCurrentNode() {
		TreePath currentSelection = tree.getSelectionPath();
		TreePath treePath = null;
		if (currentSelection != null && null != Common.treepath.get(currentSelection)) {
			DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection.getLastPathComponent());
			treePath = new TreePath(currentNode.getPath());
			MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
			System.out.println(currentNode.getUserObject());
			
			if (parent != null) {
				treeModel.removeNodeFromParent(currentNode);
			}
		}

		// Either there was no selection, or the root was selected.
		toolkit.beep();
		return treePath;
	}

	public DefaultMutableTreeNode addObject(Object child) {
		DefaultMutableTreeNode parentNode = null;
		TreePath parentPath = tree.getSelectionPath();

		if (parentPath == null) {
			parentNode = rootNode;
		} else {
			parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
		}

		return addObject(parentNode, child, true);
	}

	public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
			Object child) {
		return addObject(parent, child, false);
	}

	public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent, Object child, boolean shouldBeVisible) {
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);

		if (parent == null) {
			parent = rootNode;
		}

		treeModel.insertNodeInto(childNode, parent, parent.getChildCount());

		if (shouldBeVisible) {
			tree.scrollPathToVisible(new TreePath(childNode.getPath()));
		}
		return childNode;
	}

	public void mouseClicked(MouseEvent e) {
		TreePath parentPath = tree.getSelectionPath();
		if(null != parentPath && null != Common.treepath.get(parentPath)){
			this.tablePanel.selectRow(Common.treepath.get(parentPath));
		}
	}
	
	
	public void selectRow(TreePath path){
		expandTree(tree);
	    tree.addSelectionPath(path);
		tree.expandPath(path);
	}
	
	/**
	 * 展开一棵树
	 * @param tree
	 */
	private void expandTree(JTree tree) {
		// 根节点
		TreeNode node = (TreeNode) tree.getModel().getRoot();
		expandAll(tree, new TreePath(node), false);
	}

	/**
	 * 完全展开一棵树或关闭一棵树
	 * @param tree JTree
	 * @param parent 父节点
	 * @param expand true 表示展开，false 表示关闭
	 */
	private void expandAll(JTree tree, TreePath parent, boolean expand) {
		TreeNode node = (TreeNode) parent.getLastPathComponent();

		if (node.getChildCount() > 0) {
			for (Enumeration e = node.children(); e.hasMoreElements();) {
				TreeNode n = (TreeNode) e.nextElement();
				TreePath path = parent.pathByAddingChild(n);
				expandAll(tree, path, expand);
			}
		}
		if (expand) {
			tree.expandPath(parent);
		} else {
			tree.collapsePath(parent);
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

	public void setTablePanel(JTablePanel tablePanel) {
		this.tablePanel = tablePanel;
	}
}