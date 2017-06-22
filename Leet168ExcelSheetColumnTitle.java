package B03_07;

/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 **/
public class Leet168ExcelSheetColumnTitle {
      /**
       * StringBuilder
       * 先n--
       * 从个位向前，不断往StringBuilder前面insert
       * (char)
       */
      public String convertToTitle(int n) {
            StringBuilder res = new StringBuilder();
            while (n > 0) {
                  n--;
                  res.insert(0, (char) ('A' + n % 26));
                  n /= 26;
            }
            return res.toString();

      }

}
