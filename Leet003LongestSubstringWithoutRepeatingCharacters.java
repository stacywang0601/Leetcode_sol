package B05_21;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class Leet003LongestSubstringWithoutRepeatingCharacters {
		/**
		 * Hashmap + two pointers
		 * Use hashmap to store the characters in string as keys and their positions as values
		 * move the right pointer to scan through the string , and meanwhile update the hashmap.
		 * If the character is already in the hashmap and !!!after the left pointer!!!
		 * then move the left pointer to the right of the same character last found.
		 */
		public int lengthOfLongestSubstring(String s) {
				if (s.length() == 0)
						return 0;
				HashMap<Character, Integer> map = new HashMap<Character, Integer>();
				int max = 0;
				int start = 0;
        for(int i=0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                //if repeated char is before start, then dont update
                start = Math.max(map.get(s.charAt(i)) + 1, start);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max,i - start + 1);
				}
				return max;
		}
}
