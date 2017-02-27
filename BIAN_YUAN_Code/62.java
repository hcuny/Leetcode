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
				cur[j] = cur[j - 1] + cur[j];// 因为cur[0] === 1的性质，可以做到，计算一个覆盖一个cur[j]。
			}
		}
		return cur[small - 1];
	}
	
	
	/**
	 * 多了 3* max（m,n）的数组拷贝
	 * @param large
	 * @return
	 * 思路： cur[i] = cur[i - 1] + pre[i];第一行第一列肯定全是1，因为就一种走法，不是连续下就是连续右。
	 * pre[i]记录上一次的结果，第一次肯定是第二行、第二列  开始： cur[i] = cur[i - 1] + 1 ，然后把 cur[i]的数组赋给 pre[i]记录。
	 * 之后进行递归。
	 * 有个可以优化的思路：cur[i]在赋给pre[i]之前，存的是当前递推计算完的结果。接下来马上进行下一行的递推。而且第一个要递推出的是j=1，又cur[0] = 1，cur[1，i]存的是上一行的计算结果
	 * 所以很容易得到cur[1]的结果：cur[1](这是上一行的结果) + 1。然后把最新的这一行的结果的值，覆盖了上一行的结果值cur[1]。
	 * 之后cur[j]依次可以递推出，算出一个覆盖一个cur[j]。所以可以完全不需要缓存pre[]。省下内存空间。
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
