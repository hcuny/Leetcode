package htnTest;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 二分查找
 * 
 * @author tianning.htn
 *
 */
public class Maths {

	/**
	 * @param nums
	 * @return
	 */
	public static int longestUpSub(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;
		for (int x : nums) {
			int i = Arrays.binarySearch(dp, 0, len, x);
			if (i < 0)
				i = -(i + 1);
			dp[i] = x;
			if (i == len)
				len++;
		}
		return len;
	}

	public static void main(String[] args) {
		int[] aa = { 3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12 };
		System.out.println(longestUpSub(aa));
	}
}
