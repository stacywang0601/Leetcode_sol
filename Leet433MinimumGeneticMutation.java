package B08_03;

import java.util.HashSet;
import java.util.Set;

/**
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * 
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in
 * the bank to make it a valid gene string.
 * 
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of
 * mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
 * 
 * Note:
 * 
 * Starting point is assumed to be valid, so it might not be included in the bank.
 * If multiple mutations are needed, all mutations during in the sequence must be valid.
 * You may assume start and end string is not the same.
 * Example 1:
 * 
 * start: "AACCGGTT"
 * end: "AACCGGTA"
 * bank: ["AACCGGTA"]
 * 
 * return: 1
 */
public class Leet433MinimumGeneticMutation {
	/** two end bfs same as word ladder */
	char[]	gene	= new char[] { 'A', 'C', 'G', 'T' };

	public int minMutation(String start, String end, String[] bank) {
		if (bank == null || bank.length == 0)
			return -1;
		Set<String> bank1 = new HashSet<>();
		for (String s : bank)
			bank1.add(s);
		if (!bank1.contains(end))
			return -1;

		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();

		set1.add(start);
		set2.add(end);
		// different ladder 0
		return bfs(set1, set2, bank1, 0);
	}

	public int bfs(Set<String> start, Set<String> end, Set<String> bank, int count) {
		// first
		if (end.isEmpty()) {
			return -1;
		}
		if (start.size() > end.size()) {
			return bfs(end, start, bank, count);
		}
		bank.removeAll(start);
		bank.removeAll(end);
		Set<String> next = new HashSet<String>();
		for (String s : start) {
			char[] arr = s.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				char old = arr[i];
				for (int j = 0; j < gene.length; j++) {
					if (gene[j] == old)
						continue;
					arr[i] = gene[j];
					String newGene = String.valueOf(arr);
					if (end.contains(newGene))
						return count + 1;
					if (bank.contains(newGene)) {
						next.add(newGene);
					}
					arr[i] = old;
				}
			}
		}

		return bfs(end, next, bank, count + 1);
	}
}