/**
 * 计算int数组 最长连续1的长度
 * 
 * @author tianning.htn
 *
 */
public class Maths {
	
	/**
	 * 直接遍历，别想什么数组转字符串啊，切割啊，妈的切完还要遍历算长度的啊
	 * 
	 * @param s
	 * @return
	 */
	  public int findMaxConsecutiveOnes(int[] nums) {
	         int max = 0;
			 int current = 0;
			 for (int i : nums) {
				if (i == 1) {
					current++;
				}else if (i == 0) {
					max = Math.max(max, current);
					current = 0;
				}
			}
			max = Math.max(max, current);
			return max;
	    }

	
	public static void main(String[] args) {
		System.out.println(findMaxConsecutiveOnes(new int[{1,0,1,0,0,0,1,1,1,1,1,0,1,1,0}]));
	}
}
