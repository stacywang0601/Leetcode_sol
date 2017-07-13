package B07_13;

/**
 * You are given several projects. For each project i, it has a pure profit Pi and a minimum capital
 * of Ci is needed to start the corresponding project. Initially, you have W capital. When you
 * finish a project, you will obtain its pure profit and the profit will be added to your total
 * capital.
 * 
 * To sum up, pick a list of at most k distinct projects from given projects to maximize your final
 * capital, and output your final maximized capital.
 * 
 * Example 1:
 * Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].
 * 
 * Output: 4
 * 
 * Explanation: Since your initial capital is 0, you can only start the project indexed 0.
 * After finishing it you will obtain profit 1 and your capital becomes 1.
 * With capital 1, you can either start the project indexed 1 or the project indexed 2.
 * Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the
 * maximum capital.
 * Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
 * Note:
 * You may assume all numbers in the input are non-negative integers.
 * The length of Profits array and Capital array will not exceed 50,000.
 * The answer is guaranteed to fit in a 32-bit signed integer.
 */
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leet502IPO {
	/**
	 * two heaps
	 * profit decreasing
	 * Capital increasing
	 */
	public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		PriorityQueue<int[]> pqCap = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] A, int[] B) {
				return A[1] - B[1];
			}
		});
		PriorityQueue<int[]> pqPro = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] A, int[] B) {
				return B[0] - A[0];
			}
		});
		for (int i = 0; i < Profits.length; i++) {
			pqCap.add(new int[] { Profits[i], Capital[i] });
		}
		while (k > 0) {
			while (!pqCap.isEmpty() && pqCap.peek()[1] <= W) {
				pqPro.add(pqCap.poll());
			}
			if (pqPro.isEmpty())
				return W;
			W += pqPro.poll()[0];
			k--;
		}
		return W;
	}
}