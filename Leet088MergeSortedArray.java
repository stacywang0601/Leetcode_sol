package B08_09;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note: You may assume that A has enough space (size that is greater or equal
 * to m + n) to hold additional elements from B. The number of elements
 * initialized in A and B are m and n respectively.
 */
public class Leet088MergeSortedArray {
      /**
       * The key to solve this problem is moving element of A and B backwards.
       * If
       * B has some elements left after A is done, also need to handle that
       * case.
       */
      public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;
            int j = n - 1;
            int index = m + n - 1;
            while (i >= 0 && j >= 0) {
                  if (nums1[i] > nums2[j]) {
                        nums1[index--] = nums1[i--];
                  } else {
                        nums1[index--] = nums2[j--];
                  }
            }
            /*
             * 可以不用处理这个，因为nums1还是在nums1里面
             * while (i >= 0) {
             * nums1[index--] = nums1[i--];
             * }
             */
            while (j >= 0) {
                  nums1[index--] = nums2[j--];
            }
      }

      /**
       * Method2--简洁写法
       * 注意：比较的时候先不－－
       **/
      public void merge2(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;
            int j = n - 1;
            int k = m + n - 1;
            while (i >= 0 && j >= 0) {
                  // 比较的时候先不--！！！
                  nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
            }
            while (j >= 0) {
                  nums1[k--] = nums2[j--];
            }

      }

}
