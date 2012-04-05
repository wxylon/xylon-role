package org.role.util;

public class SignUtils {
	public static void main(String[] args) {
		/** 与运算 转换为2进制，相与
		 * 1&1=1， 1&2=0， 1&3=1， 1&0=0
		 */
//		System.out.println(1&3);
//		System.out.println(1&0);
//		System.out.println(1&1);
		
		
		int capacity = 8;
		//右移并复制，相当于乘以2的N次方
		capacity <<= 4;
		System.out.println(capacity);
		//左移并复制，相当于除以2的N次方
		capacity >>= 4;
		System.out.println(capacity);
	}
}
