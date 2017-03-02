/**
 * 将数组排序成最大整数
 * 
 * @author tianning.htn
 *
 */
public class Maths {
	
	/**
	 * 思路：两两比较，排序就先后两种方式，选其一。然后循环。
	 * O（n）*O(字符串比较)。效率较低
	 */
	public String largestNumber(int[] nums) {
        String[] str_nums = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			str_nums[i] = String.valueOf(nums[i]);
		}
		//重写比较器，String的compareTo方法比较每个char的大小
		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2 + o1).compareTo(o1 + o2);
			}
		};
		Arrays.sort(str_nums, comp);
		//[0,....]情况特殊处理
		if(str_nums[0].charAt(0) == '0')
            return "0";
		StringBuilder sb = new StringBuilder();
		for(String s: str_nums)
	            sb.append(s);
		
		return sb.toString();
    }

	
	public static void main(String[] args) {
		System.out.println(largestNumber(new int[{9999999997,9999999998,9999999999}]));
	}
}
