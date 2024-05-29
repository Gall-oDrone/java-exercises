package crackingTheCodeInterviewExs;

import java.util.Random;

public class IQ_1_7_RotateMatrix {

	static final int MAX = 4;
	static int[][] mat = new int[MAX][MAX];
	static int[][] cum = new int[MAX][MAX];
	
	public static void main(String[] args) {
		int n = 4;
		constructMatrix(n, "4b");
		System.out.println("Input matrix");
		printMat(n, mat);
		RotMat(n);
		System.out.println("Output matrix");
		printMat(n, cum);
	}
	
	static int genRnd4Bytes() {
		Random rnd = new Random();
		int result = (rnd.nextInt(0xFF)+1) << 8*2;
		result += rnd.nextInt(0x1000000);
		return result;
	}
	
	static void constructMatrix(int n, String base) {
		for (int i=0; i<n; i++) {
			for (int j= 0; j<n; j++) {
				switch(base){
					case "4b":
						mat[i][j] = genRnd4Bytes();
					default:
						cum[i][j] = 0;
				}
			}
		}
	}
	
	static void printMat(int n, int[][]mat) {
		for (int i=0; i<n; i++) {
			for (int j= 0; j<n; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void RotMat(int n) {
		constructMatrix(n, "");
		for (int i=0; i<n; i++) {
			for (int j= 0; j<n; j++) {
				cum[n-1-j][i] = mat[i][j];
			}
		}
	}
	
	/* Solution */
	boolean rotate(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
		int n = matrix.length;
		for (int layer = 0; layer < n/2; layer ++) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				
				// left -> top
				matrix[first][i] = matrix[last-offset][first];
				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset];
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				// top -> right
				matrix[i][last] = top; // right <- save top
			}
		}
		return true;
	}
	
}
