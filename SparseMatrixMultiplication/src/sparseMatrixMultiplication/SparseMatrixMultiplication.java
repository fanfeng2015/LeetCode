package sparseMatrixMultiplication;

// LeetCode #311
// Given two sparse matrices A and B, return the result of AB.
// You may assume that A's column number is equal to B's row number.

public class SparseMatrixMultiplication {

	public int[][] multiply(int[][] A, int[][] B) {
		int rowA = A.length, colA = A[0].length;
		int rowB = B.length, colB = B[0].length;
		int[][] result = new int[rowA][colB];
		for (int i = 0; i < rowA; i++) {
			for (int j = 0; j < colA; j++) {
				if (A[i][j] != 0) {
					for (int k = 0; k < colB; k++) {
						if (B[j][k] != 0) {
							result[i][k] += A[i][j] * B[j][k];
						}
					}
				}
			}
		}
		return result;
	}
}
