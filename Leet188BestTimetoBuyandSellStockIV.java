package B06_06;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before
 * you buy again).
 **/
public class Leet188BestTimetoBuyandSellStockIV {
	/**
	 * buy[j]- the balance with at most j transactions with item 0 to i
	 * sell[j] - the profit with at most j transactions with item 0 to i
	 */
	public int maxProfit(int k, int[] prices) {
		int len = prices.length;
		if (k >= len / 2)
			return quickSolve(prices);
		int[] buy = new int[k + 1];
		int[] sell = new int[k + 1];

		// initialize!!!
		for (int i = 0; i < buy.length; i++) {
			buy[i] = Integer.MIN_VALUE;
		}

		for (int i = 0; i < len; i++) {
			for (int j = 1; j <= k; j++) {
				buy[j] = Math.max(sell[j - 1] - prices[i], buy[j]); // whether to buy at prices[i]
				sell[j] = Math.max(buy[j] + prices[i], sell[j]); // whether to sell at prices[i]
			}
		}
		return sell[k];
	}

	private int quickSolve(int[] prices) {
		int len = prices.length, profit = 0;
		for (int i = 1; i < len; i++)
			// as long as there is a price gap, we gain a profit.
			if (prices[i] > prices[i - 1])
				profit += prices[i] - prices[i - 1];
		return profit;
	}
}