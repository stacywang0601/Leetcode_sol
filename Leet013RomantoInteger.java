package B06_08;

import java.util.HashMap;

/**
 * Given a Roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Leet013RomantoInteger {
	/**
	 * Use a map to store the pair
	 * Scan backward, keep track pre
	 */
	public int romanToInt(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int res = 0;
		int pre = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			int value = map.get(ch);
			if (value < pre)
				res = res - value;// Ⅳ= 5-1 = 4；Ⅸ= 9；
			else
				res = res + value;// VI = 5+1 = 6
			pre = value;// update
		}
		return res;
	}

}
