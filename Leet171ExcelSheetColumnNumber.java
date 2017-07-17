package B07_17;

/**
 * 171. Excel Sheet Column Number
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class Leet171ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res = s.charAt(i) - 'A' + 1 + res * 26;
		}
		return res;
	}

}
