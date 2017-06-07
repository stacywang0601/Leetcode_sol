package B06_06;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (ie, buy one and sell one
 * share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie,
 * you must sell the stock before you buy again).
 */
public class Leet122BestTimetoBuyandSellStockII {
	/**
	 * Method1:Accumulate you daily gains
	 * It doesn't actually sell the stock, if you buy at i, and i+1, i+2 is increasing,
	 * 
	 * the profit so far = (prices[i+1] - prices[i]) + (prices[i+2] - prices[i+1])
	 * = prices[i+2] - prices[i]
	 * You are always adding daily difference, thus you are always calculating the difference
	 * between current price and buy price in history.
	 */
	public int maxProfit(int[] prices) {
		int total = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				int profit = prices[i] - prices[i - 1];
				total += profit;
			}
		}
		return total;
	}

	/** Method2:finding next local minimum and next local maximum */
	public int maxProfit2(int[] prices) {
		if (prices.length == 0 || prices == null) {
			return 0;
		}
		// i =1
		int i = 1;
		int maxPro = 0;
		while (i < prices.length) {
			while (i < prices.length && prices[i] < prices[i - 1]) {
				i++;
			}
			// buy at local min i－1
			int buy = prices[i - 1];
			while (i < prices.length && prices[i] > prices[i - 1]) {
				i++;
			}
			// sell at local max i+1
			int sell = prices[i - 1];
			maxPro += sell - buy;
			i++;
		}
		return maxPro;

	}
}
