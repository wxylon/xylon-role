package com.xylon.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.tree.TreePath;

public class Common {
	public static Map<String, String> grade = new HashMap<String, String>();
	
	public static Map<TreePath, Integer> treepath = new HashMap<TreePath, Integer>();
	
	public final static String[] columnNames = { "姓名", "年级", "平均成绩", "个人简介"}; // 列名
	public static String[][] tableVales = new String[100][4]; // 数据
	public static int index = 0;
	static{
		grade.put("0", "一年级");
		grade.put("1", "二年级");
		grade.put("2", "三年级");
		grade.put("3", "四年级");
		grade.put("4", "五年级");
		grade.put("5", "六年级");
		String[] a = {"小四", "0", "70", "我是个好同学2"};
		String[] b = {"小李", "1", "90", "我是个好同学3"};
		String[] c = {"小黑", "1", "60", "我是个好同学4"};
		String[] d = {"小陈", "2", "90", "我是个好同学5"};
		
		tableVales[0] = a;
		index++;
		tableVales[1] = b;
		index++;
		tableVales[2] = c;
		index++;
		tableVales[3] = d;
		index++;
	}
	
	public static void add(String[] temp, TreePath treePath){
		tableVales[index] = temp;
		treepath.put(treePath, index);
		index++;
	}
	
	public static void delete(int i, TreePath treePath1){
		String[] a = {"", "", "", ""};
		
		if(i != index){
			for(int j = i; j < index; j++){
				tableVales[j] = tableVales[j+1];
			}
		}
		tableVales[i] = a;
		treepath.remove(treePath1);
		
		for(TreePath treePath2 : treepath.keySet()){
			int temp = treepath.get(treePath2);
			System.out.println("--->"+temp);
			if(temp > i){
				temp--;
				treepath.put(treePath2, temp);
			}
			System.out.println(treepath.get(treePath2));
		}
		
		index--;
	}
	
	public static boolean isEmpty(TreePath treePath1){
		if(null != treepath.get(treePath1)){
			return false;
		}
		return true;
	}
	
	public static TreePath getTreePath(int num){
		if(num > -1){
			for(TreePath treePath2 : treepath.keySet()){
				int temp = treepath.get(treePath2);
				if(temp == num){
					return treePath2;
				}
			}
		}
		return null;
	}
	
	
	
	public static String[][] getCurrentArray(){
		String[][] temp = new String[index][4];
		for(int i = 0; i < index; i++){
			temp[i] = tableVales[i];
			temp[i][1] = grade.get(temp[i][1]);
		}
		return temp;
	}
	
	public static void main(String[] args){
		for(int i = 0; i < tableVales.length; i++){
			if(tableVales[i][0] != null && !"".equals(tableVales[i][0])){
				System.out.println("--->1:"+tableVales[i][0]);
			}
		}
		System.out.println(index);
		String[] a = {"小大", "1", "70", "我是个好同学2"};
//		add(a);
//		delete(2);
		for(int i = 0; i < tableVales.length; i++){
			if(tableVales[i][0] != null && !"".equals(tableVales[i][0])){
				System.out.println("--->2:"+tableVales[i][0]);
			}
		}
		System.out.println(index);
		
	}
}
