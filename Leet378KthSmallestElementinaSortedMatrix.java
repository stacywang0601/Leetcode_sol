package B03_31;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the
 * kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * 
 * Example:
 * 
 * matrix = [ [ 1, 5, 9], [10, 11, 13], [12, 13, 15] ], k = 8,
 * 
 * return 13. Note: You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class Leet378KthSmallestElementinaSortedMatrix {
			/**
			 * The reason why we did not use index as "search space" for this problem is the matrix is
			 * sorted in two directions, we can not find a linear way to map the number and its index.
			 * 
			 */
			public int kthSmallest(int[][] matrix, int k) {
						int n = matrix.length;
						int l = matrix[0][0], h = matrix[n - 1][n - 1];
						while (l < h) {
									int m = l + (h - l) / 2;
									int count = 0, j = n - 1;

									for (int i = 0; i < n; i++) {
												// iterate backwards, if greater than m, j--
												while (j >= 0 && matrix[i][j] > m) {
															j--;
												}
												// count less than m
												count += j + 1;
									}
									// compare with k
									if (count >= k) {
												h = m;
									} else {
												l = m + 1;
									}
						}
						return l;
			}
}
