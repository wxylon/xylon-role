package test.main;

/**
 * http://www.javaeye.com/topic/943647
	分析：
	1.String.equals()方法比较的是字符串的内容,所以(x + y).equals(z)为true. 
	2.“==”比较的是 String 实例的引用,很明显 a 和z 并不是同一个 String 实例,所以(a == z)为false. 
	3.根据常量池的知识，容易得知(x == "hello")和(a == "hello" + "world")都为true. 
	(常量池指的是在编译期被确定并被保存在已编译的.class 文件中的一些数据。它包含了 
	关于方法、类、接口等，当然还有字符串常量的信息。也就是所谓的持久代。) 
	4.那么(a == (x + y))为什么是false呢？这点暂点有点不大清楚。初步认为是x+y是引用相加，不能放入常量池。 
 */
public class TestEquals {
	public static void test() {
		String x = "hello";
		String y = "world";
		String z = new String("helloworld");
		String a = "helloworld";
		System.out.println("x+y equals z:" + (x + y).equals(z));
		System.out.println("a == z:" + (a == z));
		System.out.println("x == hello:" + (x == "hello"));
		System.out.println("a == helloworld:" + (a == "hello" + "world"));
		System.out.println("a == x+y:" + (a == (x + y)));
		System.out.println("z == x+y:" + (z == (x + y)));
	}
	
	/*
	 * 分析： 
		Java 是强类型的 strongly type,它支持8 种基本数据类型。通过对这些基本数据类型用法的严格检查 Java 编译器
		能够及时地在开发过程中捕捉到许多简单细微的错误。基本数据类型的转换可以隐性地发生,所以转换时会有精度损失。
		由于1/4和3/4发生隐性类型转换，精度损失，不会生成0.25和0.75，所以有分号的数都为0。 
	 */
	public static void testType(){
		 double i = 5.0;   
		 double j = 1 / 4 + 3 / 4 + i + 12 / 6.0 + 3 / 4 + 1 / 4;   
		 System.out.println(1 / 4 + 3 / 4);   

	}
	
	public static void main(String[] args){
//		test();
		testType();
	}
	
}
