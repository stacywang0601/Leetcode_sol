package B03_24;

/**
 * H-index
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher
 * has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations
 * respectively. Since the researcher has 3 papers with at least 3 citations
 * each and the remaining two with no more than 3 citations each, his h-index is
 * 3.
 * 
 * Note: If there are several possible values for h, the maximum one is taken as
 * the h-index.
 * Follow up for H-Index: What if the citations array is sorted in ascending
 * order? Could you optimize your algorithm?
 * 
 * Hint:
 * 
 * Expected runtime complexity is in O(log n) and the input is sorted.
 * 
 * eg
 * [0,1,3,5,6] len = 5
 * res = 3
 */
public class Leet275H_IndexII {
	/**
	 * The basic idea of this solution is to use binary search to find the
	 * minimum index such that
	 * citations[index] >= length(citations) - index
	 * 
	 * [0,1,2,3,5,6,7] len = 7
	 * res = 3 which means 5,6,7 citations
	 * citations[index] > length(citations) - index
	 * 5 > 7-4
	 * 
	 * [0,1,2,4,5,6,7] len = 7
	 * res = 4 which means 4,5,6,7 citations
	 * citations[index] = length(citations) - index
	 * 4 = 7-3
	 * 
	 * Complexities:
	 * Time: O(log n)
	 * Space: O(1)
	 */
	public static int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}
		int len = citations.length;
		int l = 0, h = len - 1;
		while (l < h) {
			int m = (l + h) >> 1;
			if (citations[m] >= len - m) {
				h = m;
			} else {
				l = m + 1;
			}
		}
		l = citations[l] >= len - l ? l : len;
		return len - l;

	}

	public static void main(String[] args) {
		int[] num = { 0, 1, 2, 4, 5, 6, 7 };
		int res = hIndex(num);
		System.out.println(res);
	}
}
