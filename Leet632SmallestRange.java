package B07_20;

/**
 * You have k lists of sorted integers in ascending order. Find the smallest range that includes at
 * least one number from each of the k lists.
 * 
 * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
 * 
 * Example 1:
 * Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * Output: [20,24]
 * Explanation:
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 */
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Leet632SmallestRange {
	/**
	 * Image you are merging k sorted array using a heap. Then everytime you pop the smallest
	 * element out and add the next element of that array to the heap. By keep doing this, you will
	 * have the smallest range.
	 */
	public int[] smallestRange(List<List<Integer>> nums) {
		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(nums.size(), new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int max = nums.get(0).get(0);
		for (int i = 0; i < nums.size(); i++) {
			minHeap.add(new int[] { nums.get(i).get(0), i, 0 });
			max = Math.max(max, nums.get(i).get(0));
		}

		int minRange = Integer.MAX_VALUE;
		int start = -1;
		while (minHeap.size() == nums.size()) {
			int[] t = minHeap.poll();
			if (max - t[0] < minRange) {
				minRange = max - t[0];
				start = t[0];
			}
			if (t[2] + 1 < nums.get(t[1]).size()) {
				t[0] = nums.get(t[1]).get(t[2] + 1);
				t[2]++;
				minHeap.add(t);
				max = Math.max(max, t[0]);
			}
		}
		return new int[] { start, start + minRange };
	}
}