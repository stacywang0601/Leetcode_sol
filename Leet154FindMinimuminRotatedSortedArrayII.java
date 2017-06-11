package B06_11;

/**
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 */
public class Leet154FindMinimuminRotatedSortedArrayII {
	/**
	 * Methods
	 * since l<=m<h，so if(A[m] > A[h]) the min must be at right side
	 * When A[m] == A[h], we are not sure if the position of minimum is at mid's left or right
	 * so just let upper bound reduce one.
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
			} else if (A[m] < A[h]) {
				h = m;
			} else {
				h--;
			}
		}
		return A[l];
	}
}