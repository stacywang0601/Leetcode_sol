package B01_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * Note:
 * Each element in the result should appear as many times as it shows in both
 * arrays.
 * The result can be in any order.
 **/
public class Leet350IntersectionofTwoArraysII {
	/** Method1--HashMap + list **/
	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < nums1.length; i++) {
			if (!map.containsKey(nums1[i])) {
				map.put(nums1[i], 1);
			} else {
				map.put(nums1[i], map.get(nums1[i]) + 1);
			}
		}

		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i])) {
				if (map.get(nums2[i]) > 0) {
					list.add(nums2[i]);
					map.put(nums2[i], map.get(nums2[i]) - 1);
				}
			}
		}

		int[] res = new int[list.size()];
		int j = 0;
		for (Integer num : list) {
			res[j++] = num;
		}
		return res;
	}

	/** Method2--Sort + two pointers */
	public int[] intersect2(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				list.add(nums1[i]);
				i++;
				j++;
			}
		}

		int[] res = new int[list.size()];
		int k = 0;
		for (Integer num : list) {
			res[k++] = num;
		}
		return res;
	}
}
