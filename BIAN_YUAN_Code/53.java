/**
 * 最大子串查找
 * 
 * @author tianning.htn
 *
 */
public class Maths {

	/** 答案解法：
	 * SubArray(i,j)
	 * 舍去i之前的数据的判断：  无论 0-i 的数据如何截断，带来的都是负收益
	 * 
	 * @param s
	 * @return
	 */
	public static int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
}

	public static void main(String[] args) {
		int[] aa = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(aa));
	}
}
