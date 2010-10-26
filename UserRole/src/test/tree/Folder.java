package test.tree;

import java.util.ArrayList;
import java.util.List;

public class Folder {
	public Folder(String title) { 
        this.title = title; 
    } 
 
    private String title; 
 
    private List<Folder> children = new ArrayList<Folder>(); 
 
    public void addChild(Folder f) { 
        children.add(f); 
    } 
 public List<Folder> getChildren() { 
        return children; 
    } 
 
    public void setChildren(List<Folder> children) { 
        this.children = children; 
    } 
 
    public String getTitle() { 
        return title; 
    } 
 
    public void setTitle(String title) { 
        this.title = title; 
    } 
 
   public String toString(String lftStr, String append) { 
        StringBuilder b = new StringBuilder(); 
        b.append(append + title); 
        b.append("\n"); 
        if (children.size() > 0) { 
            for (int i = 0; i < children.size() - 1; i++) { 
                b.append(lftStr+children.get(i).toString(lftStr + "│", "├")); 
            } 
            b.append(lftStr + children.get(children.size() - 1).toString( 
                    lftStr + " ", "└")); 
 
        } 
        return b.toString(); 
 
    } 
 
    public static void main(String[] args) { 
        Folder root = new Folder("菜单列表"); 
        Folder f1 = new Folder("开始菜单"); 
        root.addChild(f1); 
        Folder f1_1 = new Folder("程序"); 
        f1.addChild(f1_1); 
        Folder f1_1_1 = new Folder("附件"); 
        f1_1.addChild(f1_1_1); 
        Folder f1_1_1_1 = new Folder("娱乐"); 
        f1_1_1.addChild(f1_1_1_1); 
        Folder f1_1_1_2 = new Folder("娱乐2"); 
        f1_1_1.addChild(f1_1_1_2); 
        Folder f1_2 = new Folder("辅助工具"); 
        f1.addChild(f1_2); 
        Folder f2 = new Folder("My Documents "); 
        root.addChild(f2); 
        Folder f3 = new Folder("My Documents2 "); 
        root.addChild(f3); 
 
        System.out.println(root.toString(" ", "")); 
    } 
}
