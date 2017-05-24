package B05_22;

public class binarySearch_final {
	private static int less(int[] num, int k) {
		int l = 0, h = num.length - 1;
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

	private static int lessOrEqual(int[] num, int k) {
		int l = 0, h = num.length - 1;
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

	private static int greater(int[] num, int k) {
		int l = 0, h = num.length - 1;
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

	private static int greaterOrEqual(int[] num, int k) {
		int l = 0, h = num.length - 1;
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

	public static void main(String[] args) {

		int[] A3 = { 5, 7, 7, 8, 8, 10 };
		System.out.println("Test GreaterOrEqual: " + greaterOrEqual(A3, 9));
		System.out.println("Test Greater: " + greater(A3, 9));
		System.out.println("Test GreaterOrEqual: " + greaterOrEqual(A3, 8));
		System.out.println("Test Greater: " + greater(A3, 8));
		System.out.println();

		System.out.println("Test LessOrEqual: " + lessOrEqual(A3, 9));
		System.out.println("Test Less: " + less(A3, 9));
		System.out.println("Test LessOrEqual: " + lessOrEqual(A3, 7));
		System.out.println("Test Less: " + less(A3, 7));

	}

}
