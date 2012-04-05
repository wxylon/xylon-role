/**
 * Copyright(c) 2000-2012 HC360.COM, All Rights Reserved. 
 * @version v2.1
 */ 
package com.xylon.thread;

public class MyThread2 implements Runnable{

	private IBean bean;
	
	public MyThread2(IBean bean){
		this.bean = bean;
	}
	
	public void run() {
		for(;;){
			bean.syzMethod2();
		}
	}
}
