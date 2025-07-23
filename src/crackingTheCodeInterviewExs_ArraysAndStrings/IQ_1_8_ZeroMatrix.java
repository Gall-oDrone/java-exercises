package crackingTheCodeInterviewExs_ArraysAndStrings;

import java.util.Random;

public class IQ_1_8_ZeroMatrix {
	
	static final int M=4;
	static final int N=5;
	static int [][] mat = new int[M][N];
	
	public static void main(String[] args) {
		int m=M,n=N;
		constructMatrix(m, n, "m");
		System.out.println("Input matrix");
		printMat(m, n, mat);
		ZMat(m, n);
		System.out.println("Output matrix");
		printMat(m, n, mat);
	}
	
	static int genRndNum() {
		Random rnd = new Random();
		int result = (rnd.nextInt(10));
		return result;
	}
	
	static void constructMatrix(int m, int n, String base) {
		for (int i=0; i<m; i++) {
			for (int j= 0; j<n; j++) {
				mat[i][j] = genRndNum();
			}
		}
	}
	
	static void printMat(int m, int n, int[][]mat) {
		for (int i=0; i<m; i++) {
			for (int j= 0; j<n; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void ZMat(int m, int n) {
		int row = 0;
		int col = 0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(mat[i][j]==0) {
					SetZ((m-1),(n-1), i, j, row, col);
				}
			}
			row=0; col = 0;
		}
	}
	
	public static void SetZ(int m, int n, int i, int j, int row, int col) {
		if(row == m && col == n) {
			return;
		}
		if(row <= m) {
			if(mat[row][j] != 0) mat[row][j] = 0;	
			row++;
			SetZ(m, n, i, j, row, col);
		}
		if(col <= n) {
			if(mat[i][col] != 0) mat[i][col] = 0;
			col++;
			SetZ(m, n, i, j, row, col);
		}
	}
	
	/* Solution */
	void setZeros(int[][] matrix) {
		boolean rowHasZero = false;
		boolean colHasZero = false;
		
		// Check if first row has a zero
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}
		
		// CHeck if first column has a zero
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[i][0] == 0) {
				colHasZero = true;
				break;
			}
		}
		
		// Check for zeros in the rest of the array
		for (int i=1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		// Nullify rows based on values in first column
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				nullifyRow(matrix, i);
			}
		}
		
		// Nullify columns based on values in first row
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				nullifyColumn(matrix, j);
			}
		}
		
		// Nullify first row
		if (rowHasZero) {
			nullifyRow(matrix, 0);
		}
		
		// Nullify first column
		if (colHasZero) {
			nullifyColumn(matrix, 0);
		}
	}
	
	void nullifyRow(int[][] matrix, int row) {
		for (int j=0; j < matrix[0].length;j++) {
			matrix[row][j] = 0;
		}
	}
	
	void nullifyColumn(int[][] matrix, int col) {
		for (int i=0; i < matrix[0].length;i++) {
			matrix[i][col] = 0;
		}
	}
}
