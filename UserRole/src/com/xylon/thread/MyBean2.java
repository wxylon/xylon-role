/**
 * Copyright(c) 2000-2012 HC360.COM, All Rights Reserved. 
 * @version v2.1
 */ 
package com.xylon.thread;

public class MyBean2 implements IBean{
	
	private Object lock = new Object();
	
	public synchronized void syzMethod1(){
//		synchronized (lock) {
			System.out.println("MyBean2--->syzMethod1 拿着 Lock 跑...");
//		}
	}
	
	public synchronized void syzMethod2() {
//		synchronized (lock) {
			
			System.out.println("MyBean2--->syzMethod2 拿着 Lock 跑...");
//		}
	}
}
