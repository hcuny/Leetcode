/**
 * 背包问题01
 * 
 * @author tianning.htn
 *
 */
public class Maths {
	
	public static boolean canPartition(int[] nums) {
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
	    /**
	     * 逆序遍历的结果： nums[1,2,3,4]    (-):表示数据未变化          (|)：数据经过||运算
	     *            dp[large] = dp[large] || dp[small]
	     *  
	     *           i\j       4       3       2        1       0
	     *            0        F       F       F        F       T        ← init数据
	     *                     ↓       ↓       ↓        ↓       |
	     *            1        T(|) ←  T(|) ←  T(|)  ←  T(|)  ←-|        除了dp[0]，所有数据更新
	     *                                                      |
	     *                     ↓       ↓        ↓               |
	     *            2        F(-)    T(|)    T(|)     ← ------|
	     *            ....
	     *            
	     *            不满足j >= num的数据不做修改，其他数据重新计算，并在原数组上更新。因为递推只需要上一行的 ‘未改动数据+改动更新的数据’，所以上一行数据计算完成后直接在原数组更新
	     *            对递推也不会有影响。
	     * 
	     */
	    for (int num : nums) {
	        for (int j = sum; j > 0; j--) {
	            if (j >= num) {
	                dp[j] = dp[j] || dp[j-num];
	            }
	        }
	    }
	    return dp[sum];
	}
	
	
	
	public boolean canPartitionTwoDimens(int[] nums) {
	    int sum = 0;
	    
	    for (int num : nums) {
	        sum += num;
	    }
	    
	    if ((sum & 1) == 1) {
	        return false;
	    }
	    sum /= 2;

	    int n = nums.length;
	    boolean[][] dp = new boolean[n+1][sum+1];
	    for (int i = 0; i < dp.length; i++) {
	        Arrays.fill(dp[i], false);
	    }
	    
	    dp[0][0] = true;
	    
	    for (int i = 1; i < n+1; i++) {
	        dp[i][0] = true;
	    }
	    for (int j = 1; j < sum+1; j++) {
	        dp[0][j] = false;
	    }
	    /**
	     * 正序遍历的结果：如果j < nums[i-1]，也就是决不能取当前i的元素（一取就超target J）。
	     *           所以在这段不满足条件的（0，j）里， dp[i][j] = dp[i-1][j] 需要拷贝上一行i的结果(逻辑上也是如此)。
	     *           但如果dp设为一维数组，那就找不到能拷贝的‘上一行数据’。导致dp[0,j]的结果都是Null。
	     *           
	     *           而在满足j >= nums[i-1]时，dp[j,max] 依赖 dp[i-1][j-nums[i-1]]，也就是 上一行的 dp[j-nums[i-1],max-nums[i-1]]。
	     *           这里就遇到两个问题：1、首先没有‘上一行’的数据可以拷贝；2、dp[j-nums[i-1],max-nums[i-1]]肯定会存在介于(不满足条件的区域)dp[0,j]的情况，而这块区域值都为Null。
	     *                        无法进行递推。
	     *                        
	     *           以上是正序遍历时，只采用一维数组存数据导致的结果。显示是不可行的，因为它需要上一行的数据来推出当前行的结果。
	     *           而实际正序遍历的过程中，数据存储的二维数组的变化类似：
	     *           
	     *           
	     *           T(|) : 由||函数得出的true    T(c) : 直接copy上一行的True  假设num[1,2,3,4]。 target J ∈[0,4]。
	     *           
	     *           i\j  0        1       2        3       4....
	     *           0    T        F       F	    F       F
	     *           1    T        T(|)    F(c)     F(c)    F(c)        ← 自上而下，自左而右计算结果并存储。
	     *           2    T        T(c)    T(|)     T(|)    F(c)          如果不取：直接拷贝上一行的数据，存一份到当前行   boolean[i][j] = boolean[i-1][j]
	     *           3    T        T(c)    T(c)     T(|)    F(c)          如果取：当前位置  boolean[i][j] = boolean[i-1][j] || boolean[i-1][j-num[i]]
	     *           4    T        T(c)    T(c)     T(c)    T(|)
	     *           ...
	     *           
	     *           
	     *           可以看出，随着i，j的增大，直接copy的结果越来越多。而这些copy的数据只是在||运算时，对递推才有贡献。其他时间只是白白占用内存空间，增加空间复杂度。有待优化。
	     *           
	     *           二维数组，正反序遍历结果一样，因为都是获取‘上一行’数据的两个关联数据，插入到‘当前行’。互不影响。
	     *           一维数组，正反序遍历结果不一样，因为它是获取‘当前行’数据的两个关联数据，插入到‘当前行’。所以要求‘插入新数据的方向’ 和‘取2个关联数据的递推方向’一致。新数据才不会干扰递推。
	     *           如果num[1,....]，结果就是外层遍历到i = 1，i<j=1<sum+1，j++ 恒成立,导致 dp[i] == True.
	     *           
	     *            ←-----------------------------------    逆序遍历数据更新方向
	     *            
	     *       T------------------ j-num[i] ----- i ********************
	     *       ↑       ↑           ↑              ↑          ↑
	     *      init    待遍历的数据              依赖数据                    当前递推关系                已递推出的新数据
	     *      
	     *           
	     */
	    for (int i = 1; i < n+1; i++) {
	        for (int j = 1; j < sum+1; j++) {
	            dp[i][j] = dp[i-1][j];
	            if (j >= nums[i-1]) {
	                dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
	            }
	        }
	    }
	   
	    return dp[n][sum];
	}
	
	public static void main(String[] args) {
		System.out.println(canPartition(new int[{1,2,3,4,5,6,7,10}]));
	}
}
