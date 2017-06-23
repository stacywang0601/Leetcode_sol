/**
 * 191. Number of 1 Bits
 * Write a function that takes an unsigned integer and returns the number of ’1'
 * bits it has
 * (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary
 * representation 00000000000000000000000000001011, so the function should
 * return 3.
 **/
package B06_24;

public class Leet191Numberof1Bits {
      public int hammingWeight(int n) {
            int count = 0;

            while (n != 0) {
                  /** Use n=n&(n-1) trick to clear the least bit */
                  n &= (n - 1);
                  count++;
            }
            return count;
      }
}
