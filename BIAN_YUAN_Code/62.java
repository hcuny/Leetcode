package htnTest;

import java.math.BigDecimal;

/**
 * 蜂巢问题
 * 
 * @author tianning.htn
 *
 */
public class Maths {

	/**
	 *  cur[0] === 1
	 *  1 1 1 1 1 1 1 1 1
	 *  1 c c
	 *  1 c c
	 *  1 c c
	 *  1 c c
	 *  1 c c
	 *  1 c c
	 *  1 c c
	 * 
	 * 
	 * @param small
	 * @param large
	 * @return
	 */
	public static int uniquePaths(int small, int large) {
		int[] cur = new int[small];
		for (int i = 0; i < cur.length; i++) {
			cur[i] = 1;
		}
		for (int i = 1; i < large; i++) {
			for (int j = 1; j < small; j++) {
				cur[j] = cur[j - 1] + cur[j];
			}
		}
		return cur[small - 1];
	}
	
	
	/**
	 * 多了 3* max（m,n）的数组拷贝
	 * @param large
	 * @return
	 */
	public static int uniquePaths2(int small, int large) {
		int[] pre = new int[small];
		int[] cur = new int[small];
		int[] temp = new int[small];
		for (int i = 0; i < pre.length; i++) {
			pre[i] = 1;
			cur[i] = 1;
		}
		for (int i = 1; i < large; i++) {
			for (int j = 1; j < small; j++) {
				cur[j] = cur[j - 1] + pre[j];
			}
				temp = pre;
				pre = cur;
				cur = temp;
		}
		return pre[small - 1];
	}

	public static void main(String[] args) {
		System.out.println(uniquePaths(2, 5));
	}
}
