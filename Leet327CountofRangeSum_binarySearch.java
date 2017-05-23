public class Leet327CountofRangeSum_binarySearch{
    
   
public  int countRangeSum(int[] nums, int lower, int upper) {
		int n = nums.length;
		ArrayList<Long> helper = new ArrayList<>();
		long sum = 0;
		helper.add(0, (long) 0);
		int res = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			int left = less(helper, 0, helper.size() - 1, sum - upper);
			//target with lessOrEqual ----> target + 1 with less
			int right = less(helper, 0, helper.size() - 1, sum - lower + 1);
			res += right - left;
			int index = greater(helper, 0, helper.size() - 1, sum);
			helper.add(index, sum);
		}
		return res;

	}
	/*find the max index that less than the target**/
	private  int less(ArrayList<Long> helper, int l, int h, long k) {
		while (l < h) {
			int m = (l + h + 1) / 2;
			if (helper.get(m) >= k) {
				h = m - 1;
			} else {
				l = m;
			}
		}
		if (helper.get(l) < k) {
			return l;
		}
		return -1;
	}
   
	/*find the min index that greater than the target**/
	private  int greater(ArrayList<Long> helper, int l, int h, long k) {
		while (l <= h) {
			int m = (l + h) / 2;
			if (helper.get(m) <= k) {
				l = m + 1;
			} else {
				h = m - 1;
			}
		}
		return l;
	}


}