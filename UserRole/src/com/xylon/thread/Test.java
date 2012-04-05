/**
 * Copyright(c) 2000-2012 HC360.COM, All Rights Reserved. 
 * @version v2.1
 */ 
package com.xylon.thread;

public class Test {
	public static void main(String[] args) {
		IBean bean1 = new MyBean2();
		MyThread1 r1 = new MyThread1(bean1);
		MyThread2 r2 = new MyThread2(bean1);
		
		Thread thread1 = new Thread(r1);
		Thread thread2 = new Thread(r2);
		
		thread1.start();
		thread2.start();
	}
}
