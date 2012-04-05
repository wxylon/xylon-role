/**
 * Copyright(c) 2000-2012 HC360.COM, All Rights Reserved. 
 * @version v2.1
 */ 
package com.xylon.thread;

public class MyBean1 implements IBean{
	
	private final static Object lock = new Object();
	
	public void syzMethod1(){
		synchronized (lock) {
//			try {
//				Thread.currentThread().sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println("MyBean1--->syzMethod1 拿着 Lock 跑...");
		}
	}
	
	public void syzMethod2() {
		synchronized (lock) {
//			try {
//				Thread.currentThread().sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println("MyBean1--->syzMethod2 拿着 Lock 跑...");
		}
	}
	
	
}
