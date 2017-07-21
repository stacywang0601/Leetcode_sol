package B07_21;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
import java.util.Arrays;
import java.util.Comparator;

public class Leet179LargestNumber {
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			return "";
		String[] string = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			string[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(string, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1);
			}
		});
		if (string[0].charAt(0) == '0')
			return "0";
		StringBuilder sb = new StringBuilder();
		for (String s : string) {
			sb.append(s);
		}
		return sb.toString();
	}
}