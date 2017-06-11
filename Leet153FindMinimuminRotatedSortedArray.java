package B05_25;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume [no duplicate] exists in the array.
 */
public class Leet153FindMinimuminRotatedSortedArray {
	/**
	 * Methods
	 * since l<=m<h，so if(A[m] > A[h]) the min must be at right side
	 **/
	public int findMin(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int l = 0;
		int h = A.length - 1;
		int m = 0;

		while (l < h) {
			m = l + (h - l) / 2;
			if (A[m] > A[h]) {
				l = m + 1;
			} else {
				h = m;
			}
		}
		return A[l];
	}

}
