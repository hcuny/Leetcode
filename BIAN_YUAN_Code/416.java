/**
 * 背包问题01
 * 
 * @author tianning.htn
 *
 */
public class Maths {
	
	/**
	 * 看答案的背包问题的解法
	 * 
	 * @param s
	 * @return
	 */
	 public boolean canPartition(int[] nums) {
	    int sum = 0;	    
	    for (int num : nums) {
	        sum += num;
	    }
	    if ((sum & 1) == 1) {
	        return false;
	    }
	    sum /= 2;	    
	    int n = nums.length;
	    boolean[] dp = new boolean[sum+1];
	    Arrays.fill(dp, false);
	    dp[0] = true;
	    
	    for (int num : nums) {
	        for (int i = sum; i > 0; i--) {
	            if (i >= num) {
	                dp[i] = dp[i] || dp[i-num];
	            }
	        }
	    }
	    return dp[sum];
	}
	
	public static void main(String[] args) {
		System.out.println(canPartition(new int[{1,2,3,4,5,6,7,10}]));
	}
}
