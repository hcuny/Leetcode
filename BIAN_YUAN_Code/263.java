package htnTest;

import java.math.BigDecimal;

/**
 * Ugly Number
 * 
 * @author tianning.htn
 *
 */
public class Maths {

	/**
	 * isUgly
	 * 
	 * @param num
	 * @return 
	 */
	public static boolean isUgly(int num) {
		if (num == 1)
			return true;
		if (num != 0 && num % 2 == 0) {
			num = num / 2;
			return isUgly(num);
		}
		if (num != 0 && num % 3 == 0) {
			num = num / 3;
			return isUgly(num);
		}
		if (num != 0 && num % 5 == 0) {
			num = num / 5;
			return isUgly(num);
		}
		return false;
	}
	/**
	 * 别人也就统一写成了一个循环，其实一样
	 */
	public static boolean isUgly2(int num) {
		for (int i = 2; i < 6 && num > 0; i++)
			while (num % i == 0)
				num /= i;
		return num == 1;
	}

	public static void main(String[] args) {
		System.out.println(isUgly(14));
	}
}
