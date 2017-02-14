package htnTest;

import java.math.BigDecimal;
import java.util.HashSet;
/**
 * n步诗
 * @author tianning.htn
 *
 */
public class CountAndSay {
	
	/**
	 * 直接递归，但是最终结果返回会有n层 return，虽然没做任何处理，但是感觉不太好
	 * @param s  初始值
	 * @param n  次数
	 * @return   最终结果
	 */
	public static String countAndSay(String s, int n) {
		while (n > 0) {
			n--;
			StringBuilder sb = new StringBuilder();
			char temp = s.charAt(0);
			int count = 1;
			if (s.length() == 1) {
			    sb.append(String.valueOf(count) + temp).toString();
				return countAndSay(sb.toString() , n);
			}
			for (int i = 1; i < s.length(); i++) {
				if (temp == s.charAt(i)) {
					count++;
					continue;
				}
				sb.append(String.valueOf(count) + temp);
				temp = s.charAt(i);
				count = 1;
			}
			sb.append(String.valueOf(count) + temp);
			return countAndSay(sb.toString() , n);
		}
		return s;
	}
	
	/**
	 * 单步操作
	 * @param s 
	 * @return
	 */
	public static String countAndSayOneStep(String s) {
		StringBuilder sb = new StringBuilder();
		char temp = s.charAt(0);
		int count = 1;
		if (s.length() == 1) {
			return sb.append(String.valueOf(count) + temp).toString();
		}
		for (int i = 1; i < s.length(); i++) {
			if (temp == s.charAt(i)) {
				count++;
				continue;
			}
			sb.append(String.valueOf(count) + temp);
			temp = s.charAt(i);
			count = 1;
		}
		sb.append(String.valueOf(count) + temp);
		return sb.toString();
	}

	/**
	 * 循环代替递归
	 * @param n
	 * @return
	 */
	public static String countAndSay2(int n) {
		String result = "1";
		int i = 0;
		while (i < n) {
			result = countAndSayOneStep(result);
			i++;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(countAndSay("1"  ,10));
		System.out.println(countAndSay2(10));
	}
}
