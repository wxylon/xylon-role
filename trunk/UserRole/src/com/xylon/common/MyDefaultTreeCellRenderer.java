package com.xylon.common;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.xylon.image.ImageManager;

public class MyDefaultTreeCellRenderer extends DefaultTreeCellRenderer {
	ImageManager imageManager = ImageManager.getInstance();

	public MyDefaultTreeCellRenderer() {
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
////		tree - 要渲染的树。
//		value - 要渲染的节点(为DefaultMutableTreeNode类型)，其getUserObject(),会获取LayersControlNodeData，用户可根据LayersControlNodeData的不同，进行不同的操作。
//		selected - 是否将单元格作为已选择的单元格进行绘制。
//		expanded - 是否扩展当前节点
//		leaf - 该节点是否表示叶节点
//		row - 指定渲染的行数
//		hasFocus - 节点是否拥有焦点 
		if (leaf){
			if(node.getRoot() == node.getParent()){
				if(expanded){
					this.setIcon(imageManager.getLocationImage(1));
				}else{
					this.setIcon(imageManager.getLocationImage(0));
				}
			}else{
				this.setIcon(imageManager.getLocationImage(2));
			}
		}else{
			if(expanded){
				this.setIcon(imageManager.getLocationImage(1));
			}else{
				this.setIcon(imageManager.getLocationImage(0));
			}
		}
		
		return this;
	}
}
