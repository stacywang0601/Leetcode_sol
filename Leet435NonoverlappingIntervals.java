package B08_14;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make
 * the rest of the intervals non-overlapping.
 * 
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 */

class Interval {
	int	start;
	int	end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class Leet435NonoverlappingIntervals {
	class myComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
	}

	public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, new myComparator());
		int end = intervals[0].end, prev = 0, count = 0;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[prev].end > intervals[i].start) {
				if (intervals[prev].end > intervals[i].end) {
					prev = i;
				}
				count++;
			} else {
				prev = i;
			}
		}
		return count;
	}
}