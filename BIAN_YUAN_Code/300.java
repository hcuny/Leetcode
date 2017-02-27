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
			//二分查找，需要在排序好的数组里查找，这里我们是[0,0,0,0,0,0,0,0,......]
			//取（0，len-1）的midindex的数组值，和x比较，如果x大，则mid右移一位，取（mid+1 , len-1）的中间值，如此循环比较
			//如果x小，则mid左移一位，取（0 ， mid-1）的中间值，如此循环比较
			int i = Arrays.binarySearch(dp, 0, len, x);
			if (i < 0)
				i = -(i + 1);
			dp[i] = x;
			if (i == len)//如果（0，i）位置都被填满，那么数组长度 len = i+1。只有当已排序的数组里的任意元素都小于x时，len才会+1，在数组里给出一个允许放更大数的位置
				len++;
		}
		return len;
	}

	public static void main(String[] args) {
		int[] aa = { 3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12 };
		System.out.println(longestUpSub(aa));
	}
}
