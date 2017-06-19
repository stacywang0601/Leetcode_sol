/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 */

package B04_17;

public class Leet198HouseRobber {
      /**
       * dp[i][1] means we rob the i-1!!! house and dp[i][0] means we don't,
       */
      public int rob(int[] num) {
            // +1
            int[][] dp = new int[num.length + 1][2];
            // 1---> num.length+1
            for (int i = 1; i < num.length + 1; i++) {
                  dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                  // i-1
                  dp[i][1] = num[i - 1] + dp[i - 1][0];
            }
            return Math.max(dp[num.length][0], dp[num.length][1]);
      }

      /**
       * O(1) space prevYes means we rob the [current!!!] house, preNo means we
       * don't
       */
      public int rob2(int[] num) {
            int prevNo = 0;
            int prevYes = 0;
            for (int n : num) {
                  // tmp!!!
                  int temp = prevNo;
                  prevNo = Math.max(prevNo, prevYes);
                  prevYes = n + temp;
            }
            return Math.max(prevNo, prevYes);
      }

}
