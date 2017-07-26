package B07_25;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city
 * when viewed from a distance. Now suppose you are given the locations and height of all the
 * buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed
 * by these buildings collectively (Figure B).
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
 * where Li and Ri are the x coordinates of the left and right edge of the ith building,
 * respectively, and Hi is its height. It is guaranteed that 0 ? Li, Ri ? INT_MAX, 0 < Hi ? INT_MAX,
 * and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely
 * flat surface at height 0.
 * 
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15],
 * [5 12 12], [15 20 10], [19 24 8] ] .
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class Leet218TheSkylineProblem {
	/**
	 * heightPairs(x,height)
	 * map(height, frequency)
	 * **/
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> heightPairs = new ArrayList<>();
		for (int[] building : buildings) {
			heightPairs.add(new int[] { building[0], -building[2] });
			heightPairs.add(new int[] { building[1], building[2] });
		}
		Collections.sort(heightPairs, new Comparator<int[]>() {
			public int compare(int[] p1, int[] p2) {
				return p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0];
			}
		});
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(0, 1);
		List<int[]> r = new ArrayList<>();
		int last = -1;
		for (int[] heightPair : heightPairs) {
			int x = heightPair[0];
			int height = heightPair[1];
			if (height < 0) {
				map.put(-height, map.getOrDefault(-height, 0) + 1);
			} else {
				map.put(height, map.get(height) - 1);
				if (map.get(height) == 0)
					map.remove(height);
			}
			int cur = map.lastKey();
			if (cur != last) {
				r.add(new int[] { x, cur });
				last = cur;
			}

		}
		// r.add(new int[]{heightPairs.get(heightPairs.size()-1)[0], 0});
		return r;
	}
}