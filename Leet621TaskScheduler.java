package B07_19;

/**
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where
 * different letters represent different tasks.Tasks could be done without original order. Each task
 * could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * 
 * However, there is a non-negative cooling interval n that means between two same tasks, there must
 * be at least n intervals that CPU are doing different tasks or just be idle.
 * 
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * 
 * Example 1:
 * Input: tasks = ['A','A','A','B','B','B'], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 */
import java.util.Arrays;

public class Leet621TaskScheduler {
	/**
	 * append the less frequent characters to the end of each chunk of the first k-1 chunks
	 * sequentially and round and round, then join the chunks and keep their heads' relative
	 * distance from each other to be at least n.
	 * for the last line (c[25] - 1) * (n + 1) + 25 - i:
	 * c[25]-1: we have totally "c[25]" frames,
	 * (n+1): the length of each frame, each of the first c[25]-1 frames must have a length of "n+1"
	 * +25-i: count for the most frequent letters, it is the length of the last frame
	 */
	public int leastInterval(char[] tasks, int n) {
		// (c[25] - 1) * (n + 1) + 25 - i is frame size
		// when inserting chars, the frame might be "burst", then tasks.length takes precedence
		// when 25 - i > n, the frame is already full at construction, the following is still valid.
		int[] c = new int[26];
		for (char t : tasks) {
			c[t - 'A']++;
		}
		Arrays.sort(c);
		int i = 25;
		while (i >= 0 && c[i] == c[25])
			i--;

		return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
	}
}