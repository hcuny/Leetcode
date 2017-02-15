/**
 * 移动数组0到末尾
 * Created by tianning.htn 2017/2/15
 */
public class MoveZeroes {
    public static String moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;        
        int insertPos = 0;
        /**
         * nums[i] 绝不会出现在i之后，一般再j位置，j <= i
         * 所以把非0重新排序至j，i-j之差就是末尾补0的数量
         */
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }        
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
	
	public static void main(String[] args) {
		System.out.println(moveZeroes( [0, 1, 0, 3, 12]));
	}
	
}
