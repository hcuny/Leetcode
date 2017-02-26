import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * 
 * @author tianning.htn
 *
 */
public class Maths {

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	/**
	 * 适应性归并排序(Adaptive Mergesort)
	 * 
	 */
	static class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }

	public static int nonOverlappingIntervals(Interval[] intervals) {
		int count = 0;
		if (intervals.length == 0) {
			return 0 ;
		}
		Arrays.sort(intervals , new myComparator());
		Interval current = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			if (current.end <= intervals[i].start) {
				current = intervals[i];
			}else{
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(nonOverlappingIntervals(new Interval[]{ new Interval(1,2) , new Interval(1,4),new Interval(2,3),new Interval(2,4)}));
	}
}
