/**
 * ×Ö·û·´×ª
 * Created by tianning.htn 2017/2/13
 */
public class reverseString {
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		System.out.println(reverseString("hello"));
	}
	
}