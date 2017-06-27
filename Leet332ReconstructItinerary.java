package B06_26;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival
 * airports [from, to], reconstruct the itinerary in order. All of the tickets
 * belong to a man who departs from JFK. Thus, the itinerary must begin with
 * JFK.
 * 
 * Note:
 * If there are multiple valid itineraries, you should return the itinerary that
 * has the smallest lexical order when read as a single string. For example, the
 * itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * Example 2:
 * tickets =
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 * Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But
 * it is larger in lexical order.
 * 
 */

public class Leet332ReconstructItinerary {
	/**
	 * map, key depart, value: PriorityQueue for all arrivals
	 */

	public List<String> findItinerary(String[][] tickets) {
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		// linkedList addFirst
		LinkedList<String> res = new LinkedList<String>();
		for (int i = 0; i < tickets.length; i++) {
			if (map.get(tickets[i][0]) == null) {
				// new
				map.put(tickets[i][0], new PriorityQueue<String>());
			}
			map.get(tickets[i][0]).add(tickets[i][1]);
		}
		dfs("JFK", map, res);
		return res;
	}

	private void dfs(String depart, Map<String, PriorityQueue<String>> map, LinkedList<String> res) {
		// get arrivals
		PriorityQueue<String> arrivals = map.get(depart);
		// final stop
		if (arrivals == null) {
			res.addFirst(depart);
			return;
		}
		while (!arrivals.isEmpty()) {
			dfs(arrivals.poll(), map, res);
		}
		// when return from arrival, arrival is empty, add this depart
		res.addFirst(depart);
	}

}
