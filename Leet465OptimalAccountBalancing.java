package B08_31;

/**
 * A group of friends went on holiday and sometimes lent each other money. For example, Alice paid
 * for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each
 * transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and
 * Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be
 * represented as [[0, 1, 10], [2, 0, 5]].
 * 
 * Given a list of transactions between a group of people, return the minimum number of transactions
 * required to settle the debt.
 * 
 * Note:
 * 
 * A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
 * Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the
 * persons 0, 2, 6.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Leet465OptimalAccountBalancing {
	/**
	 * debt[i] > 0 means a person needs to pay $ debt[i] to other person(s);
	 * debt[i] < 0 means a person needs to collect $ debt[i] back from other person(s).
	 * Starting from first debt debt[0], we look for all other debts debt[i] (i>0) which have
	 * opposite sign to debt[0]. Then each such debt[i] can make one transaction debt[i] += debt[0]
	 * to clear the person with debt debt[0]. From now on, the person with debt debt[0] is dropped
	 * out of the problem and we recursively drop persons one by one until everyone's debt is
	 * cleared meanwhile updating the minimum number of transactions during DFS.
	 */
	public int minTransfers(int[][] transactions) {
		Map<Integer, Long> map = new HashMap<>();
		for (int[] t : transactions) {
			long val1 = map.getOrDefault(t[0], 0L);
			long val2 = map.getOrDefault(t[1], 0L);
			map.put(t[0], val1 - t[2]);
			map.put(t[1], val2 + t[2]);
		}

		List<Long> list = new ArrayList<>();
		for (long val : map.values()) {
			if (val != 0)
				list.add(val);
		}

		Long[] debts = new Long[list.size()];
		debts = list.toArray(debts);
		return helper(debts, 0, 0);
	}

	int helper(Long[] debts, int pos, int count) {
		while (pos < debts.length && debts[pos] == 0)
			pos++;
		int res = Integer.MAX_VALUE;
		long pre = 0;
		for (int i = pos + 1; i < debts.length; i++) {
			if (debts[i] != pre && debts[pos] * debts[i] < 0) {
				debts[i] += debts[pos];
				res = Math.min(res, helper(debts, pos + 1, count + 1));
				debts[i] = debts[i] - debts[pos];
				pre = debts[i];
			}
		}
		return res == Integer.MAX_VALUE ? count : res;
	}
}