package htnTest;

/**
 * @author tianning.htn
 */
public class Maths {

	/**
	* O（N*LogN）  S(N)
	*/
	public static int numSquares(int n) {
		/**dp[i]指目标值  = i时，能用完美平方组成的最少整数*/
		int[] dp = new int[n + 1];
		dp[0] = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			/**
			 * dp[i] 如果减少一个 完美平方，那么只要满足 i >= j*j , dp[i] = dp[i-j*j] + 1
			 */
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, dp[i - j * j] + 1);
			}
			dp[i] = min;
			min = Integer.MAX_VALUE;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(numSquares(43));
	}
}
