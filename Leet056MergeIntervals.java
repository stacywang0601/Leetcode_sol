package B02_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 **/
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

public class Leet056MergeIntervals {
	/**
	 * Method1:
	 * sort by starting points.
	 * compare first end with the next intervals starts.
	 * overlap: update the end if needed
	 * non-overlap: add，update start and end
	 */
	public List<Interval> merge(List<Interval> intervals) {
		// check can not compare if only one
		if (intervals.size() <= 1) {
			return intervals;
		}
		List<Interval> res = new ArrayList<Interval>();
		// collections override compare function, sort using start
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start > b.start ? 1 : (a.start == b.start ? 0 : -1);
			}
		});

		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		for (Interval interval : intervals) {
			// overlap
			if (interval.start <= end) {
				end = Math.max(end, interval.end);
			} else {
				// non-overlap
				res.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		// Add last one
		res.add(new Interval(start, end));
		return res;
	}

	/**
	 * Method2--for the result distinct Interval,
	 * the latter one's start must > previous one's end.
	 */
	public List<Interval> merge2(List<Interval> intervals) {
		int n = intervals.size();
		int[] starts = new int[n];
		int[] ends = new int[n];
		int k = 0;
		for (Interval interval : intervals) {
			starts[k] = interval.start;
			ends[k] = interval.end;
			k++;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		List<Interval> res = new ArrayList<Interval>();

		for (int i = 0, j = 0; i < n; i++) {
			/** distinct add, else i++ check next */
			if (i == n - 1 || starts[i + 1] > ends[i]) {
				// new Interval
				res.add(new Interval(starts[j], ends[i]));
				// update start
				j = i + 1;
			}
		}
		return res;
	}
}
