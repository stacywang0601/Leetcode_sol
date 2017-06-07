package B06_06;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before
 * you buy again).
 */

public class Leet123BestTimetoBuyandSellStockIII {
	/**
	 * First assume that we have no money
	 * buy1 means to borrow money to buy it borrow as less as possible ( negative).
	 * sell1 means to sell the stock, price[i] - |buy1| = prices[i] + buy1
	 * buy2 means to buy another stock, buy2 = sell1 - price[i]
	 * sell2 means to sell stock2, sell2 = buy2 + prices[i], we make this max.
	 * So sell2 is the most money we can have.
	 */
	/**
	 * At first increasing period, sell1 update every time
	 * buy2 = buy1 + price -price = buy1 will also update every time
	 * sell2 = sell1 - price + price = sell1 will also update every time
	 * Then at the first drop down point, sell1 won't update
	 * since price[i] < price[i-1], buy2 = buy1 + price[i-1] -price[i] > buy1, so it will update
	 * so does sell2
	 * The logic is max maintain the best route in dp, wont update until satisfy the condition
	 */
	public static int maxProfit(int[] prices) {
		int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
		for (int price : prices) {
			buy1 = Math.max(buy1, -price);
			sell1 = Math.max(sell1, buy1 + price);
			buy2 = Math.max(buy2, sell1 - price);
			sell2 = Math.max(sell2, buy2 + price);
		}
		return sell2;
	}

	/**
	 * update: from 188
	 * buy[j]- the balance with at most j transactions with item 0 to i
	 * sell[j] - the profit with at most j transactions with item 0 to i
	 */
	public int maxProfit2(int[] prices) {
		int len = prices.length;
		int[] buy = new int[3];
		int[] sell = new int[3];

		// initialize!!!
		for (int i = 0; i < buy.length; i++) {
			buy[i] = Integer.MIN_VALUE;
		}

		for (int i = 0; i < len; i++) {
			for (int j = 1; j <= 2; j++) {
				buy[j] = Math.max(sell[j - 1] - prices[i], buy[j]); // whether to buy at prices[i]
				sell[j] = Math.max(buy[j] + prices[i], sell[j]); // whether to sell at prices[i]
			}
		}
		return sell[2];
	}

	public static void main(String[] args) {
		int[] prices = { 1, 3, 5, 7, 2, 5, 1, 8 };
		int res = maxProfit(prices);
		System.out.println(res);
	}
}