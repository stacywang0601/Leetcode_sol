package B08_12;

/**
 * Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many
 * times the given sentence can be fitted on the screen.
 * 
 * Note:
 * 
 * A word cannot be split into two lines.
 * The order of words in the sentence must remain unchanged.
 * Two consecutive words in a line must be separated by a single space.
 * Total words in the sentence won't exceed 100.
 * Length of each word is greater than 0 and won't exceed 10.
 * 1 ≤ rows, cols ≤ 20,000.
 * 
 * Input:
 * rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]
 * 
 * Output:
 * 1
 * 
 * Explanation:
 * I-had
 * apple
 * pie-I
 * had--
 * 
 * The character '-' signifies an empty space on the screen.
 */
public class Leet418SentenceScreenFitting {
	/**
	 * Explanation:
	 * 
	 * Say sentence=["abc", "de", "f], rows=4, and cols=6.
	 * The screen should look like
	 * 
	 * "abc de"
	 * "f abc "
	 * "de f  "
	 * "abc de"
	 * Consider the following repeating sentence string, with positions of the start character of
	 * each row on the screen.
	 * 
	 * "abc de f abc de f abc de f ..."
	 *  ^      ^     ^    ^      ^
	 *  0      7     13   18     25
	 *  每次跳到下一行的开头，如果空格可以背上一行省略，所以＋1
	 *  如果是第一个字母，那么刚刚好，不用变，所以0
	 *  如果超过首字母，那么放在上一行的首字母要挪下来，即在上一行末尾补0，所以－1，－2， －3
	 */
	public int wordsTyping(String[] sentence, int rows, int cols) {
		String s = String.join(" ", sentence) + " ";
		int len = s.length(), count = 0;
		int[] map = new int[len];
		for (int i = 1; i < len; ++i) {
			map[i] = s.charAt(i) == ' ' ? 1 : map[i - 1] - 1;
		}
		for (int i = 0; i < rows; ++i) {
			count += cols;
			count += map[count % len];
		}
		return count / len;
	}
}