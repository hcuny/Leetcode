import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * 最长回文字符串
 * @author tianning.htn
 *
 */
public class LongestPalindrome {
    
	/**
	 * hashset方法
	 * @author 别人
	 *
	 */
	public static int getLongestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return 0;
		StringBuilder sb = new StringBuilder();
		HashSet<Character> hs = new HashSet<Character>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (hs.contains(s.charAt(i))) {
				sb.append(s.charAt(i));
				hs.remove(s.charAt(i));
				count++;
			} else {
				hs.add(s.charAt(i));
			}
		}
		if (!hs.isEmpty())
			return count * 2 + 1;
		return count * 2;
	}
	/**
	 * hasmap方法
	 * @author tianning.htn
	 *
	 */
	public static int getLongestPalindrome2(String s) {
		  char[] charList = s.toCharArray();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < charList.length; i++) {
			if (!map.containsKey(charList[i] + "")) {
				map.put(charList[i] + "", 1);
			} else {
				map.put(charList[i] + "", map.get(charList[i] + "").intValue() + 1);
			}
		}

		Iterator iter = map.entrySet().iterator();
		StringBuilder sb = new StringBuilder();
		String centerChar = "";
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String key = (String) entry.getKey();
			Integer val = (Integer) entry.getValue();
			
			if (val > 1) {
				if (val % 2 == 0) {
					for (int i = 0; i < val / 2; i++) {
						sb.append(key);
					}
				}else{
					for (int i = 0; i < (val - 1) / 2; i++) {
						sb.append(key);
						if (centerChar.isEmpty()) {
							centerChar = key;
						}
					}
				}
			}else{
				if (centerChar.isEmpty()) {
					centerChar = key;
				}
			}

		}
		return (sb.toString() + centerChar + sb.reverse().toString()).length();
	}

	public static void main(String[] args) {
		String s = "abccccdd";
		System.out.println(getLongestPalindrome(s));
		System.out.println(getLongestPalindrome2(s));
		}
}
