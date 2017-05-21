package B05_21;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1: nums1 = [1, 3] nums2 = [2]
 * 
 * The median is 2.0 Example 2: nums1 = [1, 2] nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 */
public class Leet004MedianofTwoSortedArrays {
			/**
			 * Thus approach like binary search could be employed. Based on the fact that the 2 arrays are
			 * sorted seperatedly, we could try to get the submedian of the 2 arrays in each round. Than
			 * compare them. And the basic idea is that the left half of the array with a smaller
			 * submedian can never contains the common median.
			 */
			public double findMedianSortedArrays(int[] nums1, int[] nums2) {

						int m = nums1.length;
						int n = nums2.length;
						int l = (m + n + 1) / 2;// left half of the combined median
						int r = (m + n + 2) / 2;// right half of the combined median
						// If the nums1.length + nums2.length is odd, the 2 function will return the same number
						// Iff it is even, the 2 function will return the left number and right number
						return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0,
						                  r)) / 2.0;

			}

			// This function finds the Kth element in nums1 + nums2
			private double getKth(int[] nums1, int startA, int[] nums2, int startB,
			                  int k) {
						// If nums1 is exhausted, return kth number in nums2
						if (startA > nums1.length - 1)
									return nums2[startB + k - 1];
						// If nums2 is exhausted, return kth number in nums1
						if (startB > nums2.length - 1)
									return nums1[startA + k - 1];
						// If k == 1, return the first number
						if (k == 1)
									return Math.min(nums1[startA], nums2[startB]);
						int mid1 = Integer.MAX_VALUE;
						int mid2 = Integer.MAX_VALUE;
						// nums1[startA + k/2 - 1] is the k/2 th number in nums1
						if (startA + k / 2 - 1 < nums1.length) {
									mid1 = nums1[startA + k / 2 - 1];
						}
						if (startB + k / 2 - 1 < nums2.length) {
									mid2 = nums2[startB + k / 2 - 1];
						}
						// Throw away half of the array from nums1 or nums2. And cut k in half
						if (mid1 < mid2) {
									return getKth(nums1, startA + k / 2, nums2, startB, k - k / 2);
						} else {
									return getKth(nums1, startA, nums2, startB + k / 2, k - k / 2);
						}

			}

}
