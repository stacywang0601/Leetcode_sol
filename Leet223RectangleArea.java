package B07_21;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 **/
public class Leet223RectangleArea {
	/** area1 + area2 - overlap */
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int x = Math.min(G, C) > Math.max(E, A) ? (Math.min(G, C) - Math.max(E, A)) : 0;
		int y = Math.min(D, H) > Math.max(B, F) ? (Math.min(D, H) - Math.max(B, F)) : 0;
		return (D - B) * (C - A) + (G - E) * (H - F) - x * y;
	}
}