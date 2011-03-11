package test.main;

/**
 * http://www.javaeye.com/topic/932254
 */
import java.util.Iterator;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class TestQuestion {
	private String[] b = new String[] { "1", "2", "2", "3", "4", "5" };
	private int n = b.length;
	private boolean[] visited = new boolean[n];
	private int[][] a = new int[n][n];
	private String result = "";
	private TreeSet set = new TreeSet();
	String tt = "";

	public static void main(String[] args) {
//		new TestQuestion().start();
		test();
	}
	
	private static void test(){
		String pattern = "[\u0391-\uFFE5]{1}[\u0391-\uFFE5]{1,7}|[a-zA-Z_]{1}[a-zA-Z0-9]{3,14}[a-zA-Z0-9]{1}|[0-9]{1}[0-9]{0,13}[a-zA-Z]{1,13}[0-9]{0,13}[a-zA-Z0-9]{1}";

		String test = "0s1111";
		System.out.println(Pattern.compile(pattern).matcher(test).matches());
	}

	private void start() {
		// Initial the map a[][]
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					a[i][j] = 0;
				} else {
					a[i][j] = 1;
				}
			}
		}

		// 3 and 5 can not be the neighbor.
		a[3][5] = 0;
		a[5][3] = 0;
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				tt = tt + a[i][j] + "---";
//			}
//			System.out.println(tt);
//			tt = "";
//		}

		// Begin to depth search.
		for (int i = 0; i < n; i++) {
			this.depthFirstSearch(i);
		}

		// Print result treeset.
		Iterator it = set.iterator();
		while (it.hasNext()) {
			String string = (String) it.next();
			// "4" can not be the third position.
			if (string.indexOf("4") != 2) {
//				System.out.println(string);
			}
		}
	}
	
//	0---1---1---1---1---1---
//	1---0---1---1---1---1---
//	1---1---0---1---1---1---
//	1---1---1---0---1---0---
//	1---1---1---1---0---1---
//	1---1---1---0---1---0---

	private void depthFirstSearch(int startIndex) {
		visited[startIndex] = true;
		result = result + b[startIndex];
		if (result.length() == n) {
			// Filt the duplicate value.
			set.add(result);
		}
		for (int j = 0; j < n; j++) {
			show();
			if (a[startIndex][j] == 1 && visited[j] == false) {
				depthFirstSearch(j);
			} else {
				continue;
			}
		}

		// restore the result value and visited value after listing a node.
		show();
		result = result.substring(0, result.length() - 1);
		show();
		visited[startIndex] = false;
		show();
	}
	
	private void show(){
		for(int i = 0; i < visited.length; i++){
			System.out.print(visited[i]+"->");
		}
		System.out.println();
		System.out.println("result:"+result);
	}
}