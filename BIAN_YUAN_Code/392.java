/**
 * Subsequence
 * @author tianning.htn
 *
 */
public class Maths {

	/**
	 * @param 待搜索的String
	 * @param 目标String
	 * @return
	 */
	public static boolean isSubsequence(String s, String t) {
		int index = -1; 
        for (int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i), index + 1); //feed back as the next offset
            if (index == -1) return false; 
        }
        return true; 
	}
	public static void main(String[] args) {
		System.out.println(isSubsequence("ada","asdaidolz"));
	}
}
