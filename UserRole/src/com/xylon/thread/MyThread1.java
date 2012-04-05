/**
 * Copyright(c) 2000-2012 HC360.COM, All Rights Reserved. 
 * @version v2.1
 */ 
package com.xylon.thread;

public class MyThread1 implements Runnable{

	private IBean bean;
	
	public MyThread1(IBean bean){
		this.bean = bean;
	}
	
	public void run() {
		for(;;){
			bean.syzMethod1();
		}
	}
}
