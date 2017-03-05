/**
 * 给定任意非负整数数组，只能+或者-，给定目标值S，求数组+-元素满足==S的不同顺序组合数
 * 
 * @author tianning.htn
 *
 */
public class Maths {
	
	/**
	 * 思路：分2组，一组P全+，一组N全减。 P - N = S && P + N = SUM  → P = (SUM+S)/2
	 * 问题转化为：从数组里取出任意元素（任一元素可选可不选），使得元素和为 (SUM+S)/2。转化为01背包问题的变种。差别就在01背包是求max，这里是求指定 target。（target <= max）
	 * 
	 */
	public static int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
		for (int n : nums)
			sum += n;
		return sum < s || ((s + sum) & 1) == 1 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }
	/**
	 * 
	 * 变种01背包：没有cost，如果把元素值看做v，变量只有 v 和 V。V倒叙遍历理由和01问题一致。
	 * 如果dp[] 指前i个元素的总和，为什么d[0] = 1 ？
	 * 类似问题NO.416
	 */
    public static int subsetSum(int[] nums, int s) {
		int[] dp = new int[s + 1];
		dp[0] = 1;
		for (int n : nums)
			for (int i = s; i >= n; i--)
				dp[i] += dp[i - n];
		return dp[s];
	}

	
	public static void main(String[] args) {
		System.out.println(findTargetSumWays(new int[{1,2,3,4,5}] , 3));
	}
}
