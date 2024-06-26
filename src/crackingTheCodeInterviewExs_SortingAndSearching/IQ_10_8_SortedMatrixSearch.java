package crackingTheCodeInterviewExs_SortingAndSearching;

public class IQ_10_8_SortedMatrixSearch {

	/*
	 * Solution #1: Naive Solution
	*/
	boolean findElement(int[][] matrix, int elem) {
		int row = 0;
		int col = matrix[0].length -1;
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == elem) {
				return true;
			} else if (matrix[row][col] > elem) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
	
	/*
	 * Solution #2: Binary Search
	*/
	Coordinate findElementBS(int[][] matrix, Coordinate origin, Coordinate dest, int x) {
		if (!origin.inbounds(matrix) || !dest.inbounds(matrix)) {
			return null;
		}
		if (matrix[origin.row][origin.column] == x) {
			return origin;
		} else if (!origin.isBefore(dest)) {
			return null;
		}
		
		/* Set start to start of diagonal and end to the end of the diagonal. Since the
		 * grid may not be sqaure, the end of the diagonal may not equal dest.
		 * */
		Coordinate start = (Coordinate) origin.clone();
		int diagDist = Math.min(dest.row - origin.row, dest.column - origin.column);
		Coordinate end = new Coordinate(start.row + diagDist, start.column + diagDist);
		Coordinate p = new Coordinate(0, 0);
		
		/* Do binary search on the diagonal, looking for the first element > x */
		while (start.isBefore(end)) {
			p.setToAverage(start, end);
			if (x > matrix[p.row][p.column]) {
				start.row = p.row + 1;
				start.column = p.column + 1;
			} else {
				end.row = p.row - 1;
				end.column = p.column - 1;
			}
		}
		
		/* Split the grid into quadrants. Search the bottom left and the top rigth. */
		return partitionAndSearch(matrix, origin, dest, start, x);	
	}
	
	Coordinate partitionAndSearch(int[][] matrix, Coordinate origin, Coordinate dest, Coordinate pivot, int x) {
		Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.column);
		Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.column - 1);
		Coordinate upperRightOrigin = new Coordinate(pivot.row, origin.column);
		Coordinate upperRightDest = new Coordinate(pivot.row - 1, dest.column);
		
		Coordinate lowerLeft = findElementBS(matrix, lowerLeftOrigin, lowerLeftDest, x);
		if (lowerLeft == null) {
			return findElementBS(matrix, upperRightOrigin, upperRightDest, x);
		}
		return lowerLeft;
	}
	
	Coordinate findElementBS(int[][] matrix, int x) {
		Coordinate origin = new Coordinate(0, 0);
		Coordinate dest = new Coordinate(matrix.length - 1, matrix[0].length - 1);
		return findElementBS(matrix, origin, dest, x);
	}
	
	public class Coordinate implements Cloneable {
		public int row, column;
		public Coordinate(int r, int c) {
			row = r;
			column = c;
		}
		
		public boolean inbounds(int[][] matrix) {
			return row >= 0 && column >= 0 && 
					row < matrix.length && column < matrix[0].length; 
		}
		
		public boolean isBefore(Coordinate p) {
			return row <= p.row && column <= p.column;
		}
		
		public Object clone() {
			return new Coordinate(row, column);
		}
		
		public void setToAverage(Coordinate min, Coordinate max) {
			row = (min.row + max.row) / 2;
			column = (min.column + max.column) / 2;
		}
	}
}
