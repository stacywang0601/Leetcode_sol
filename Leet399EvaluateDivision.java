package B06_28;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings,
 * and k is a real number (floating point number). Given some queries, return the answers. If the
 * answer does not exist, return -1.0.
 * 
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Leet399EvaluateDivision {
	/**
	 * 1.Build the map, the key is dividend,
	 * The value is also a map whose key is divisor and value is its parameter.
	 * For example, a / b = 2.0, the map entry is <"a", <"b", 2.0>>.
	 * To make searching and calculation easier, also put b / a = 0.5 into the map.
	 * 2.For each query, use DFS to search divisors recursively
	 */
	public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
		// build the map
		Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
		for (int i = 0; i < equations.length; i++) {
			if (!map.containsKey(equations[i][0]))
				map.put(equations[i][0], new HashMap<String, Double>());
			map.get(equations[i][0]).put(equations[i][1], values[i]);

			if (!map.containsKey(equations[i][1]))
				map.put(equations[i][1], new HashMap<String, Double>());
			map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
		}

		// search dividend and divisor using DFS
		double[] result = new double[query.length];
		for (int i = 0; i < query.length; i++) {
			if (map.containsKey(query[i][0]) && map.containsKey(query[i][1])) {
				if (query[i][0] == query[i][1])
					result[i] = 1.0;
				else {
					double res = dfs(map, query[i][0], query[i][1], new HashSet<String>(), 1.0);
					result[i] = res == 0.0 ? -1.0 : res;
				}
			} else
				result[i] = -1.0;
		}
		return result;
	}

	private double dfs(Map<String, Map<String, Double>> map, String num1, String num2,
	            HashSet<String> visited, double val) {
		if (map.get(num1).containsKey(num2))
			return val * map.get(num1).get(num2);
		double tmp = 0.0;
		for (String neighbor : map.get(num1).keySet()) {
			if (!visited.contains(neighbor)) {
				visited.add(neighbor);
				tmp = dfs(map, neighbor, num2, visited, val * map.get(num1).get(neighbor));
				if (tmp != 0.0)
					break;
			}
		}
		return tmp;
	}
}