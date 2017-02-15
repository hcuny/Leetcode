/**
 * 判断1个int是否是2的幂指数
 * Created by tianning.htn 2017/2/15
 */
public class PowerOfTwo {
     /**
     * Returns a power of two size for the given target capacity.
     * Geogle：你们对技术一无所知！
     * 摘取自HashMap源码片段
     */
    public static boolean tableSizeFor(int cap) {
        if(cap < 1) return false;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n != 0) ? ((n+1) == cap) : true;
    }
	
	public static void main(String[] args) {
		System.out.println(tableSizeFor(17));
	}
	
}
