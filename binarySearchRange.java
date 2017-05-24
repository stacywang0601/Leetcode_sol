package B05_22;

public class binarySearchRange {

	public static void main(String[] args) {

		int[] A = { 5, 7, 7, 8, 8, 10 };
		int lower = 4;
		int upper = 9;

		int left = less(A, 0, A.length - 1, lower);
		int right = less(A, 0, A.length - 1, upper + 1);
		System.out.println("Less		left: " + left + ", right: " + right + ", length :"
		            + (right - left));

		left = lessOrEqual(A, 0, A.length - 1, lower - 1);
		right = lessOrEqual(A, 0, A.length - 1, upper);
		System.out.println("LessOrEqual	left: " + left + ", right: " + right + ", length :"
		            + (right - left));

		left = greater(A, 0, A.length - 1, lower - 1);
		right = greater(A, 0, A.length - 1, upper);
		System.out.println("Greater		left: " + left + ", right: " + right + ", length :"
		            + (right - left));

		left = greaterOrEqual(A, 0, A.length - 1, lower);
		right = greaterOrEqual(A, 0, A.length - 1, upper + 1);
		System.out.println("GreaterOrEqual	left: " + left + ", right: " + right + ", length :"
		            + (right - left));
	}

	private static int less(int[] num, int l, int h, int k) {
		while (l < h) {
			int m = (l + h + 1) / 2;
			if (num[m] < k) {
				l = m;
			} else {
				h = m - 1;
			}
		}
		return num[l] < k ? l : -1;
	}

	private static int lessOrEqual(int[] num, int l, int h, int k) {
		while (l < h) {
			int m = (l + h + 1) / 2;
			if (num[m] <= k) {
				l = m;
			} else {
				h = m - 1;
			}
		}
		return num[l] <= k ? l : -1;
	}

	private static int greater(int[] num, int l, int h, int k) {
		while (l < h) {
			int m = (l + h) / 2;
			if (num[m] > k) {
				h = m;
			} else {
				l = m + 1;
			}
		}
		return num[l] > k ? l : num.length;
	}

	private static int greaterOrEqual(int[] num, int l, int h, int k) {
		while (l < h) {
			int m = (l + h) / 2;
			if (num[m] >= k) {
				h = m;
			} else {
				l = m + 1;
			}
		}
		return num[l] >= k ? l : num.length;
	}
}
