package B06_27;

/**
 * Suppose we abstract our file system by a string in the following manner:
 * 
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 * 
 * dir
 * subdir1
 * subdir2
 * file.ext
 * The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing
 * a file file.ext.
 * We are interested in finding the longest (number of characters) absolute path to a file within
 * our file system. For example, in the second example above, the longest absolute path is
 * "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).
 * 
 * Given a string representing the file system in the above format, return the length of the longest
 * absolute path to file in the abstracted file system. If there is no file in the system, return 0.
 * 
 * Note:
 * The name of a file contains at least a . and an extension.
 * The name of a directory or sub-directory will not contain a ..
 * Time complexity required: O(n) where n is the size of the input string.
 * 
 * Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path
 * aaaaaaaaaaaaaaaaaaaaa/sth.png.
 */
import java.util.Stack;

public class Leet388LongestAbsoluteFilePath {
	public int lengthLongestPath(String input) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // "dummy" length
		int maxLen = 0;
		for (String s : input.split("\n")) {
			// in String "\n", "\t", "\123" will all be count the length as one
			int lev = s.lastIndexOf("\t") + 1; // number of "\t
			while (stack.size() > lev + 1)
				stack.pop(); // find parent
			int len = stack.peek() + s.length() - lev + 1; // remove "\t", add"/"
			stack.push(len);
			// check if it is file
			if (s.contains("."))
				maxLen = Math.max(maxLen, len - 1);// remove "/"
		}
		return maxLen;
	}
}