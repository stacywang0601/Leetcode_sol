package B06_27;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Leet310MinimumHeightTrees {
	/**
	 * The implementation is similar to the BFS topological sort. Remove the leaves, update
	 * the degrees of inner vertexes. Then remove the new leaves. Doing so level by level until
	 * there are 2 or 1 nodes left. What's left is our answer!
	 * 
	 * The time complexity and space complexity are both O(n).
	 */
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> leaves = new ArrayList<>();
		if (n == 0)
			return leaves;
		if (n == 1) {
			leaves.add(0);
			return leaves;
		}
		// hashSet, iterator
		List<HashSet<Integer>> adj = new ArrayList<>(n);
		// add hashset first
		for (int i = 0; i < n; ++i)
			adj.add(new HashSet<Integer>());

		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}
		// add leaves
		for (int i = 0; i < n; ++i)
			if (adj.get(i).size() == 1)
				leaves.add(i);

		while (n > 2) {
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for (int i : leaves) {
				// iterate the set
				int j = adj.get(i).iterator().next();
				adj.get(j).remove(i);
				if (adj.get(j).size() == 1)
					newLeaves.add(j);
			}
			leaves = newLeaves;
		}
		return leaves;
	}

}