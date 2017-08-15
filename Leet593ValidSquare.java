package B08_15;

public class Leet593ValidSquare {
	/**
	 * If we consider all the permutations descripting the arrangement of points as in the brute
	 * force approach, we can come up with the following set of 24 arrangements:
	 * In this figure, the rows with the same shaded color indicate that the corresponding
	 * arrangements lead to the same set of edges and diagonals. Thus, we can see that only three
	 * unique cases exist. Thus, instead of generating all the 24 permutations, we check for the
	 * equality of edges and diagonals for only the three distinct cases.
	 * 
	 * Time complexity : O(1). A fixed number of comparisons are done.
	 * Space complexity: O(1). No extra space required.
	 */

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		return check(p1, p2, p3, p4) || check(p1, p3, p2, p4) || check(p1, p2, p4, p3);
	}

	public boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
		return dist(p1, p2) > 0 && dist(p1, p2) == dist(p2, p3) && dist(p2, p3) == dist(p3, p4)
		            && dist(p3, p4) == dist(p4, p1) && dist(p1, p3) == dist(p2, p4);
	}

	public double dist(int[] p1, int[] p2) {
		return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
	}
}