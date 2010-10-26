package test;

public class TestBuffer {


	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("123");
		buffer.reverse();
		System.out.println(buffer.toString());
	}

}
