/**
 * 10^n里的所有整数中，无重复数字的整数个数
 * 
 * @author tianning.htn
 *
 */
public class Maths {
	 
	   /**
		* 好吧,找规律就行。
		* 
		*/
	 public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)     return 1;
        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }
	
	/**
	 * 正则遍历匹配，数量那么多，我也没办法。
	 * 
	 */
	public static int countNumbersWithUniqueDigits2(int n) {
		// Pattern pattern = Pattern.compile("^(?!.*(\\d).*\\1).*$");    //匹配无重复的数字
		Pattern pattern = Pattern.compile("(\\d)(?=.*\\1)");    //匹配2个重复的数字
		int count = 0;
		Matcher matcher;
		for (int i = 0; i < Math.pow(10, n); i++) {
			matcher = pattern.matcher(i + "");
			if (matcher.find()) {
				count++;
			}
		}
		return (int) (Math.pow(10, n) - count);

	}

	
	public static void main(String[] args) {
		System.out.println(countNumbersWithUniqueDigits(6);
	}
}
