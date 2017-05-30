package B05_29;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P A H N
 * A P L S I I G
 * Y I R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 **/
public class Leet006ZigZagConversion {
	/** 首行和尾行是＋step，中间行有两个step交替进行，画图找规律 */
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		int step = 2 * numRows - 2;
		StringBuilder ss = new StringBuilder();

		for (int i = 0; i < numRows; i++) {
			/** first and last row **/
			if (i == 0 || i == numRows - 1) {
				for (int j = i; j < s.length(); j += step) {
					ss.append(s.charAt(j));
				}
			} else {
				/** middle rows */
				int j = i;
				// 负责交替
				boolean flag = true;
				int step1 = 2 * (numRows - i - 1);
				int step2 = step - step1;
				while (j < s.length()) {
					// 写在前面，因为第一个j也要进入
					ss.append(s.charAt(j));
					if (flag) {
						j += step1;
					} else {
						j += step2;
					}
					flag = !flag;
				}
			}
		}
		return ss.toString();
	}

}
