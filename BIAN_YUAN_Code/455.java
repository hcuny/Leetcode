import java.util.Arrays;

/**
 * 
 * 
 * @author tianning.htn
 *
 */
public class Maths {
    /**
	 * 快速排序
	 * 
	 */
    public static int assignCookies(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0;
		for (int j = 0; i < g.length && j < s.length; j++) {
			if (g[i] <= s[j])
				i++;
		}
		return i;
	}

	public static void main(String[] args) {
		int[] aa = { 0, 0, 7, 6, 5, 6, 1 };
		int[] aaa = { 0, 0, 6, 5, 6, 1 };
		System.out.println(assignCookies(aaa,aa));
	}
}
