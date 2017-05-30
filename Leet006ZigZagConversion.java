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
	/**
	 * StringBuilder[]
	 * vertically down : row = [0, numRows]
	 * vertically down : row = [numRows-2, 1]
	 * copy ss[1]~ss[numRows-1] to ss[0]
	 **/
	public String convert(String s, int numRows) {
		int len = s.length();
		char[] c = s.toCharArray();
		StringBuilder[] ss = new StringBuilder[numRows];

		for (int i = 0; i < ss.length; i++)
			ss[i] = new StringBuilder();

		int i = 0;
		while (i < len) {
			for (int row = 0; row < numRows && i < len; row++) {
				ss[row].append(c[i++]);
			}
			for (int row = numRows - 2; row >= 1 && i < len; row--) {
				ss[row].append(c[i++]);
			}
		}

		for (int row = 1; row < numRows; row++) {
			ss[0].append(ss[row]);
		}
		return ss[0].toString();

	}

}
