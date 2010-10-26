package test.string;

public class TestString {

	public static void test01(){
		String str1 = new String("hello"); 
		String str2 = str1; 
		boolean b1 = str1 == str2;
		System.out.println(str1+"=="+str2+"   "+b1);
		str2 += "java";
		b1 = str1 == str2;
		System.out.println(str1+"=="+str2+"   "+b1);
		str1 += "java";
		b1 = str1 == str2;
		System.out.println(str1+"=="+str2+"   "+b1);
		System.out.println(str1.equals(str2));
	}
	
	public static void testMemry(){
		String str = "";
		long startTime = System.currentTimeMillis() ; 
		long startMem = Runtime.getRuntime().freeMemory(); 
		for (int i=0; i < 1000; i++) {
		      str += "asssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";  
		      }
		long endMem = Runtime.getRuntime().freeMemory();
		System.out.println("1Use memory:    "+ (startMem - endMem)); 
		long endTime = System.currentTimeMillis(); 
		System.out.println("1Use Time:    "+ (endTime - startTime));
	}
	
	public static void testMemry1(){
		StringBuffer str = new StringBuffer();
		long startTime = System.currentTimeMillis() ; 
		long startMem = Runtime.getRuntime().freeMemory(); 
		for (int i=0; i < 1000; i++) {
			str.append("asssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");  
		}
		long endMem = Runtime.getRuntime().freeMemory();
		System.out.println("2Use memory:    "+ (startMem - endMem)); 
		long endTime = System.currentTimeMillis(); 
		System.out.println("2Use Time:    "+ (endTime - startTime));
	}
	public static void testMemry2(){
		StringBuffer str1 = new StringBuffer();
		long startTime = System.currentTimeMillis() ; 
		long startMem = Runtime.getRuntime().freeMemory(); 
		for (int i=0; i < 1000; i++) {
			str1.append("asssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");  
		}
		long endMem = Runtime.getRuntime().freeMemory();
		System.out.println("3Use memory:    "+ (startMem - endMem)); 
		long endTime = System.currentTimeMillis(); 
		System.out.println("3Use Time:    "+ (endTime - startTime));
	}

	public static void main(String[] args) {
//		testMemry();
		testMemry1();
		testMemry2();
	}

}
