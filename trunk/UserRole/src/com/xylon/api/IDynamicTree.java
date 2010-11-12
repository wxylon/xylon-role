package com.xylon.api;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public interface IDynamicTree {
	public TreePath removeCurrentNode();
	public DefaultMutableTreeNode addObject(Object child);
	
}
