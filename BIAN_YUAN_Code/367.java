/**
 * sqrt的简易实现
 * 
 * @author tianning.htn
 *
 */
public class Maths {
	
	/**
	 * 牛顿迭代法  y=x^2 + a  y' = 2x   y/(x-x0)=2x得出x0的迭代式：x0 = （x^2+a）/2x
	 * 
	 * @param n          a==n    
	 * @return
	 */
	 public boolean isPerfectSquare(int n) {
       float val = n;
		float last;
		do {
			last = val;
			val = (val + n / val) / 2;
		} while (Math.abs(val - last) != 0);
		return val == (int)val;
    }

	
	public static void main(String[] args) {
		System.out.println(65535);
	}
}
