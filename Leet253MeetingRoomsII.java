package B08_13;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * (si < ei), find the minimum number of conference rooms required.
 * 
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 */
public class Leet253MeetingRoomsII {
	/**
	 * Here is my thought. whenever there is a start meeting, we need to add one room. But before
	 * adding rooms, we check to see if any previous meeting ends, which is why we check start with
	 * the first end. When the start is bigger than end, it means at this time one of the previous
	 * meeting ends, and it can take and reuse that room.
	 */
	public int minMeetingRooms(Interval[] intervals) {

		int n = intervals.length;
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int rooms = 0, pre = 0;
		for (int i = 0; i < n; i++) {
			rooms++;
			if (starts[i] >= ends[pre]) {
				rooms--;
				pre++;
			}
		}
		return rooms;
	}
}