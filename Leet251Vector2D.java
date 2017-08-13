package B08_13;

import java.util.Iterator;
import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.
 * 
 * For example,
 * Given 2d vector =
 * 
 * [
 * [1,2],
 * [3],
 * [4,5,6]
 * ]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next
 * should be: [1,2,3,4,5,6].
 */
// Method1:use index in list
public class Leet251Vector2D implements Iterator<Integer> {
	int	                r;
	int	                c;
	List<List<Integer>>	vec2d;

	public Leet251Vector2D(List<List<Integer>> vec2d) {
		r = 0;
		c = 0;
		this.vec2d = vec2d;
	}

	@Override
	public Integer next() {
		return vec2d.get(r).get(c++);
	}

	@Override
	public boolean hasNext() {
		while (r < vec2d.size() && c >= vec2d.get(r).size()) {
			r++;
			c = 0;
		}
		return r < vec2d.size() && c < vec2d.get(r).size();
	}
}

/** Method2: Only use Iterator */
class Vector2D_2 {

	private Iterator<List<Integer>>	i;
	private Iterator<Integer>	    j;

	public Vector2D_2(List<List<Integer>> vec2d) {
		i = vec2d.iterator();
	}

	public int next() {
		// call hasNext(), j can be changed to the next row when the current row is ended.
		hasNext();
		return j.next();
	}

	public boolean hasNext() {
		while ((j == null || !j.hasNext()) && i.hasNext())
			j = i.next().iterator();
		return j != null && j.hasNext();
	}
}