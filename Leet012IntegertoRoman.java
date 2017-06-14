package B06_08;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Leet012IntegertoRoman {
	/**
	 * Four String arrays for 1000, 100, 10, 1
	 * StingBuilder
	 * */
	public String intToRoman(int num) {
		String M[] = { "", "M", "MM", "MMM" };
		String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		StringBuilder res = new StringBuilder();
		res.append(M[num / 1000]);
		res.append(C[(num % 1000) / 100]);
		res.append(X[(num % 100) / 10]);
		res.append(I[num % 10]);
		return res.toString();
	}

	/**
	 * since 1-3 accumulate normal(add I to right side), 4-5 abnormal, 5-8 normal, 9 abnormal
	 * so put 1,4,5,9 in dict
	 * this method depends on the num, 3888 worst
	 * 3888 = 3(1000) + 1(500) + 3(100) + 1(50) + 3(10) + 1(5) + 3(1) = 15
	 */
	public String intToRoman2(int num) {
		int[] int_dict = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] roman_dict = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int i = 0;
		StringBuilder res = new StringBuilder();

		while (num > 0) {
			if (num >= int_dict[i]) {
				res.append(roman_dict[i]);
				num -= int_dict[i];
			} else {
				i++;
			}
		}
		return res.toString();
	}

	/**
	 * recursive version
	 * */
	public String intToRoman3(int num) {
		int[] int_dict = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] roman_dict = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		for (int i = 0; i < int_dict.length; i++) {
			if (num >= int_dict[i]) {
				return roman_dict[i] + intToRoman(num - int_dict[i]);
			}
		}
		// num< int_dict[len-1]
		return "";
	}
}