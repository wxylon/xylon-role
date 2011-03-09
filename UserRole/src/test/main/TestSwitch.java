package test.main;
/*
 * 少了break;所以2以下的case和default都执行了一遍。
 * @author wangx
 */
public class TestSwitch {
	public static void main(String[] args) {
		int i = 2;
		switch (i) {
		case 1:
			System.out.println(1);
		case 2:
			System.out.println(2);
		default:
			System.out.println(4);
		case 3:
			System.out.println(3);
		
		}
	}
}
