package test.main;

/*
	分析： 
	1.我们创建了一个Parent类的实例。变量 p 的数据类型为 Parent 类 但是它仍旧是 Child 类的一个实例。因为Child类覆盖了Parent类的方法say2(),所以p.say2()调用为子类的方法。 
	2.为什么p.say()却是调用父类Parent的方法呢？因为Java中规定“实例方法被覆盖，静态方法被隐藏”. 
	关于Override的一些规则： 
	用子类的静态方法隐藏父类中同样标识的实例方法是不合法的，编译器将会报错； 
	用子类的实例方法覆盖父类中同样标识的静态方法也是不合法的，编译器同样会报错； 
	带关键字 final的方法（静态和实例方法）都不能被覆盖； 
	实例方法能够被覆盖； 
	抽象方法必须在具体类中被覆盖。
 */
public class OverrideTest {
	public static void main(String[] args) {
		Parent Pa = new Parent();
		System.out.println(Pa.say());
		System.out.println(Pa.say2());
		
		Parent p = new Child();
		System.out.println(p.say());
		System.out.println(p.say2());
		
		Child c = new Child();
		System.out.println(c.say());
		System.out.println(c.say2());
	}
}
