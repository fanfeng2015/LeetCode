package rectangleArea;

// LeetCode #223

// Find the total area covered by two rectilinear rectangles in a 2D plane.
// Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

public class RectangleArea {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int height = (int) Math.max(0, (long) Math.min(D, H) - (long) Math.max(B, F));
		int width = (int) Math.max(0, (long) Math.min(C, G) - (long) Math.max(A, E));
		int overlap = height * width;
		return (D - B) * (C - A) + (H - F) * (G - E) - overlap;
	}

	// Time complexity is O(1).
	// Space complexity is O(1).
}
