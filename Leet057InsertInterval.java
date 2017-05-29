package B05_29;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if
 * necessary).
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * 
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
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

public class Leet057InsertInterval {
	/**
	 * Method1:
	 * add all the intervals ending before newInterval starts
	 * merge all overlapping intervals to one considering newInterval
	 * add the union of intervals we got
	 * add all the rest
	 * */
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new LinkedList<>();
		int i = 0;
		while (i < intervals.size() && intervals.get(i).end < newInterval.start)
			result.add(intervals.get(i++));
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
			newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
			i++;
		}
		result.add(newInterval);
		while (i < intervals.size())
			result.add(intervals.get(i++));
		return result;
	}

	/**
	 * Method 2:change newInterval to null after merging and adding it
	 * use null as a flag to show if newInterval has been dealt with
	 */

	public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		for (Interval i : intervals) {
			if (newInterval == null || i.end < newInterval.start)
				result.add(i);
			else if (i.start > newInterval.end) {
				result.add(newInterval);
				result.add(i);
				newInterval = null;
			} else {
				newInterval.start = Math.min(newInterval.start, i.start);
				newInterval.end = Math.max(newInterval.end, i.end);
			}
		}
		if (newInterval != null)
			result.add(newInterval);
		return result;
	}
}
