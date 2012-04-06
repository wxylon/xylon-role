package test.hash;

import java.util.HashSet;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet set = new HashSet();
		for (int i = 0; i <= 3; i++) {
			set.add(new Demo1(i, i));
		}
		System.out.println(set);//[ value = 0,  value = 1,  value = 2,  value = 3]
		set.add(new Demo1(1, 1));
		System.out.println(set);//[ value = 0,  value = 1,  value = 2,  value = 3]
		System.out.println(set.contains(new Demo1(0, 0)));//true，已包含
		System.out.println(set.add(new Demo1(1, 1)));//false，已存在，加不进去
		System.out.println(set.add(new Demo1(4, 4)));//true//不存在，故能加进去
		System.out.println(set);//[ value = 0,  value = 1,  value = 2,  value = 3,  value = 4]
		
		//从上面可以看出set和list的对象输出时，都会调用它存放元素的toString方法，然后首末加上［］和豆号来拼接而成。
	}

	private static class Demo1 {
		private int value;

		private int id;

		public Demo1(int value, int id) {
			this.value = value;
			this.id = id;
		}

		public String toString() {
			return " value = " + value;
		}
		
		//覆盖Object（这个是每个类的默认继承）的equals和hashCode方法，这里只是简单的返回自己定义的值
		public boolean equals(Object o) {
			Demo1 a = (Demo1) o;
			return (a.value == value) ? true : false;
		}
		public int hashCode() {
			return id;
		}
		
	}
}