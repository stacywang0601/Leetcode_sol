/**
 * 342. Power of Four
 * Given an integer (signed 32 bits), write a function to check whether it is a
 * power of 4.
 * 
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * 
 * Follow up: Could you solve it without loops/recursion?
 */
package B07_11;

public class Leet342PowerofFour {
      /**
       * Method1
       * (num & (num - 1)) if it is power of 2
       * 0x55555555 is to get rid of those power of 2 but not power of 4
       * so that the single 1 bit always appears at the odd position
       */
      public boolean isPowerOfFour(int num) {
            return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
      }

      /** Mehod2--loop */
      public boolean isPowerOfFour2(int num) {
            if (num <= 0) {
                  return false;
            }
            // 条件!!!余数0
            while (num % 4 == 0) {
                  num /= 4;
            }
            return num == 1;
      }
}
