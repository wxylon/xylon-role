package com.xylon.common;

import java.util.HashMap;
import java.util.Map;

public class Common {
	public static Map<String, String> grade = new HashMap<String, String>();
	
	public final static String[] columnNames = { "姓名", "年级", "平均成绩", "个人简介"}; // 列名
	public static String[][] tableVales = new String[100][4]; // 数据
	public static int index = 0;
	static{
		grade.put("1", "一年级");
		grade.put("2", "二年级");
		grade.put("3", "三年级");
		grade.put("4", "四年级");
		grade.put("5", "五年级");
		grade.put("6", "六年级");
		String[] a = {"小四", "1", "70", "我是个好同学2"};
		String[] b = {"小李", "2", "90", "我是个好同学3"};
		String[] c = {"小黑", "2", "60", "我是个好同学4"};
		String[] d = {"小陈", "3", "90", "我是个好同学5"};
		
		tableVales[0] = a;
		index++;
		tableVales[1] = b;
		index++;
		tableVales[2] = c;
		index++;
		tableVales[3] = d;
		index++;
	}
	
	public static void add(String[] temp){
		tableVales[index] = temp;
		index++;
	}
	
	public static void delete(int i){
		String[] a = {"", "", "", ""};
		
		if(i != index){
			for(i = i; i < index; i++){
				tableVales[i] = tableVales[i+1];
			}
		}
		tableVales[i] = a;
		index--;
	}
	
	public static int search(String name){
		for(int i = 0; i < index; i++){
			if(tableVales[i][0].equals(name))
				return i;
		}
		return -1;
	}
	
	public static String[][] getCurrentArray(){
		String[][] temp = new String[index][4];
		for(int i = 0; i < index; i++){
			temp[i] = tableVales[i];
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
		add(a);
//		delete(2);
		for(int i = 0; i < tableVales.length; i++){
			if(tableVales[i][0] != null && !"".equals(tableVales[i][0])){
				System.out.println("--->2:"+tableVales[i][0]);
			}
		}
		System.out.println(index);
		
	}
}
