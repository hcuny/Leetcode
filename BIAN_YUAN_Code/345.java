package htnTest;

import java.math.BigDecimal;
import java.util.HashSet;
/**
 * 元音反转
 * @author tianning.htn
 *
 */
public class Maths {

	/**
	 * 元音反转
	 * @param s 
	 * @return
	 */
	public static String reverseVowels(String s) {
		String vowel = "aeiouAEIOU";
		char[] chars = s.toCharArray();
		int i = 0;
		int j = s.length() - 1;
		
		while (i < j) {
			/**寻址到元音为止*/
			while (i < j && !vowel.contains(s.charAt(i) + "")) {
				i++;
			}
			while (i < j && !vowel.contains(s.charAt(j) + "")) {
				j--;
			}
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
			i++;
			j--;
		}
		return new String(chars);
	}


	public static void main(String[] args) {
		System.out.println(reverseVowels("asdaidolz"));
	}
}
