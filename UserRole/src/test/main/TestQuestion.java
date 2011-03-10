package test.main;

/**
 * http://www.javaeye.com/topic/932254
 */
import java.util.Iterator;
import java.util.TreeSet;

public class TestQuestion {
	private String[] b = new String[] { "1", "2", "2", "3", "4", "5" };
	private int n = b.length;
	private boolean[] visited = new boolean[n];
	private int[][] a = new int[n][n];
	private String result = "";
	private TreeSet set = new TreeSet();
	String tt = "";

	public static void main(String[] args) {
		new TestQuestion().start();
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
			if (a[startIndex][j] == 1 && visited[j] == false) {
				depthFirstSearch(j);
			} else {
				continue;
			}
		}

		// restore the result value and visited value after listing a node.
		result = result.substring(0, result.length() - 1);
		visited[startIndex] = false;
	}
}