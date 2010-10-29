package com.xylon.api;

import javax.swing.tree.DefaultMutableTreeNode;

public interface IDynamicTree {
	public void removeCurrentNode();
	public DefaultMutableTreeNode addObject(Object child);
}
