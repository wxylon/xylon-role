package org.role.util;

public class SignUtils {
	public static void main(String[] args) {
		/** 与运算 转换为2进制，相与
		 * 1&1=1， 1&2=0， 1&3=1， 1&0=0
		 */
//		System.out.println(1&3);
//		System.out.println(1&0);
//		System.out.println(1&1);
		
		
//		int capacity = 8;
//		//右移并复制，相当于乘以2的N次方
//		capacity <<= 4;
//		System.out.println(capacity);
//		//左移并复制，相当于除以2的N次方
//		capacity >>= 4;
//		System.out.println(capacity);
		
		/**求非运算*/
//		System.out.println(1^1);	//0
//		System.out.println(1^2);	//3
//		System.out.println(2^1);	//3
//		System.out.println(2^0);	//2
//		System.out.println(0^2);	//2
		
		
		testHash();
	}
	
	static void testHash(){
		int num = Integer.MAX_VALUE;
		System.out.println("   10进 制:" + num);
		System.out.println("    2进 制:" + bu(Integer.toBinaryString(num)));
		System.out.println(hash(num));
		System.out.println(hashcode(num));
	}
	
	static int hash(int h) {
		// This function ensures that hashCodes that differ only by
		// constant multiples at each bit position have a bounded
		// number of collisions (approximately 8 at default load factor).
		int id1 = h >>> 20;
		System.out.println("h >>> 20 :" + bu(Integer.toBinaryString(id1)));
		int id2 = h >>> 12;
		System.out.println("h >>> 12 :" + bu(Integer.toBinaryString(id2)));
		int id3 = id1 ^ id2;
		System.out.println(" id1^id2 :" + bu(Integer.toBinaryString(id3)));
		h ^= id3;
		System.out.println("h ^      :" + bu(Integer.toBinaryString(h)));
		int id4 = h >>> 7;
		System.out.println("h >>> 7  :" + bu(Integer.toBinaryString(id4)));
		int id5 = h >>> 4;
		System.out.println("h >>> 4  :" + bu(Integer.toBinaryString(id5)));
		int id6 = h ^ id4 ^ id5;
		System.out.println("h^id4^id5:" + bu(Integer.toBinaryString(id6)));
		return id6;
	}
	
	static int hashcode(int h) {
		// This function ensures that hashCodes that differ only by
		// constant multiples at each bit position have a bounded
		// number of collisions (approximately 8 at default load factor).
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}
	
	static String bu(String str){
		int length = 32 - str.length();
		if(null == str || str.trim().length() == 0){
			return "";
		}
		for(int i = 0; i < length; i++){
			str = "0" + str;
		}
		return str;
	}
}
