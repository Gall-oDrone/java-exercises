package crackingTheCodeInterviewExs_Moderate;

import java.util.ArrayList;
import java.util.Iterator;

public class IQ_16_4_TicTacWin {
	
	// Solution #1: If hasWon is called many times
	Piece hasWon(int board) {
		return winnerHashTable[board];
	}
	
	enum Piece { Empty, Red, Blue };
	
	int convertBoardToInt(Piece[][] board) {
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				/* Each value in enum has an integer associated with it. We
				 * can just use that. */
				int value = board[i][j].ordinal();
				sum = sum * 3 + value;
			}
		}
		return sum;
	}
	
	// Solution #2: If we know the last move
	Piece hasWonS2(Piece[][] board, int row, int column) {
		if (board.length != board[0].length) return Piece.Empty;
		
		Piece piece = board[row][column];
		
		if (piece == Piece.Empty) return Piece.Empty;
		
		if (hasWonRow(board, row) || hasWonColumn(board, column)) {
			return piece;
		}
		
		if (row == column && hasWonDiagonal(board, 1)) {
			return piece;
		}
		
		if (row == (board.length - column - 1) && hasWonDiagonal(board, -1)) {
			return piece;
		}
		
		return Piece.Empty;
	}
	
	boolean hasWonRow(Piece[][] board, int row) {
		for (int c = 1; c < board[row].length; c++) {
			if (board[row][c] != board[row][0]) {
				return false;
			}
		}
		return true;
	}
	
	boolean hasWonColumn(Piece[][] board, int column) {
		for (int r = 1; r < board.length; r++) {
			if (board[r][column] != board[0][column]) {
				return false;
			}
		}
		return true;
	}
	
	boolean hasWonDiagonal(Piece[][] board, int direction) {
		int row = 0;
		int column = direction == 1 ? 0 : board.length - 1;
		Piece first = board[0][column];
		for (int i = 0; i < board.length; i++) {
			if (board[row][column] != first) {
				return false;
			}
			row += 1;
			column += direction;
		}
		return true;
	}
	
	// Solution #3: Designing for just a 3x3 board
	Piece hasWonS3(Piece[][] board) {
		for (int i = 0; i < board.length; i++) {
			/* Check Rows */
			if (hasWinner(board[i][0], board[i][1], board[i][2])) {
				return board[i][0];
			}
			
			/* Check Columns */
			if (hasWinner(board[0][i], board[1][i], board[2][i])) {
				return board[0][i];
			}
		}
		/* Check Diagonal */
		if (hasWinner(board[0][0], board[1][1], board[2][2])) {
			return board[0][0];
		}
		
		if (hasWinner(board[0][2], board[1][1], board[2][0])) {
			return board[0][2];
		}
		
		return Piece.Empty;
	}
	
	boolean hasWinner(Piece p1, Piece p2, Piece p3) {
		if (p1 == Piece.Empty) {
			return false;
		}
		return p1 == p2 && p2 == p3;
	}
	
	// Solution #4: Designing for an NxN board
	
	// Nested For-Loops
	Piece hasWonS4(Piece[][] board) {
		int size = board.length;
		if (board[0].length != size) return Piece.Empty;
		Piece first;
		
		/* Check rows. */
		for (int i = 0; i < size; i++) {
			first = board[i][0];
			if (first == Piece.Empty) continue;
			for (int j = 1; j < size; j++) {
				if (board[i][j] != first) {
					break;
				} else if (j == size -1) { // last element
					return first;
				}
			}
		}
		
		/* Check columns. */
		for (int i = 0; i < size; i++) {
			first = board[0][i];
			if (first == Piece.Empty) continue;
			for (int j = 1; j < size; j++) {
				if (board[j][i] != first) {
					break;
				} else if (j == size -1) { // last element
					return first;
				}
			}
		}
		
		/* Check diagonals. */
		first = board[0][0];
		if (first != Piece.Empty) {
			for (int i = 1; i < size; i++) {
				if (board[i][i] != first) {
					break;
				} else if (i == size - 1) { // Last element
					return first;
				}
			}
		}
		
		first = board[0][size - 1];
		if (first != Piece.Empty) {
			for (int i = 1; i < size; i++) {
				if (board[i][size - i - 1] != first) {
					break;					
				} else if (i == size - 1) { // Last element
					return first;
				}
			}
		}
		
		return Piece.Empty;
	}
	
	// Increment and Decrement Function
	class Check {
		public int row, column;
		private int rowIncrement, columnIncrement;
		public Check(int row, int column, int rowI, int colI) {
			this.row = row;
			this.column = column;
			this.rowIncrement = rowI;
			this.columnIncrement = colI;
		}
		
		public void increment() {
			row += rowIncrement;
			column += columnIncrement;
		}
		
		public boolean inBounds(int size) {
			return row >= 0 && column >= 0 && row < size && column < size;
		}
	}
	
	Piece hasWon_ID(Piece[][] board) {
		if (board.length != board[0].length) return Piece.Empty;
		int size = board.length;
		
		/* Create list of things to check. */
		ArrayList<Check> instructions = new ArrayList<Check>();
		for (int i = 0; i < board.length; i++) {
			instructions.add(new Check(0, i, 1 ,0));
			instructions.add(new Check(i, 0, 0 ,1));
		}
		instructions.add(new Check(0, 0, 1, 1));
		instructions.add(new Check(0, size - 1, 1, -1));
		
		/* Check them. */
		for (Check instr : instructions) {
			Piece winner = hasWon_ID(board, instr);
			if (winner != Piece.Empty) {
				return winner;
			}
		}
		return Piece.Empty;
	}
	
	Piece hasWon_ID(Piece[][] board, Check instr) {
		Piece first = board[instr.row][instr.column];
		while (instr.inBounds(board.length)) {
			if (board[instr.row][instr.column] != first) {
				return Piece.Empty;
			}
			instr.increment();
		}
		return first;
	}
	
	/* Iterator */
	Piece hasWon_I(Piece[][] board) {
		if (board.length != board[0].length) return Piece.Empty;
		int size = board.length;
		
		ArrayList<PositionIterator> instructions = new ArrayList<PositionIterator>();
		for ( int i = 0; i < board.length; i++) {
			instructions.add(new PositionIterator(new Position(0, i), 1, 0, size));
			instructions.add(new PositionIterator(new Position(i, 0), 0, 1, size));
		}
		instructions.add(new PositionIterator(new Position(0, 0), 1, 1, size));
		instructions.add(new PositionIterator(new Position(0, size - 1), 1, -1, size));
		for (PositionIterator iterator : instructions) {
			Piece winner = hasWon_I(board, iterator);
			if (winner != Piece.Empty) {
				return winner;
			}
		}
		return Piece.Empty;
	}
	
	Piece hasWon_I(Piece[][] board, PositionIterator iterator) {
		Position firstPosition = iterator.next();
		Piece first = board[firstPosition.row][firstPosition.column];
		while (iterator.hasNext()) {
			Position position = iterator.next();
			if (board[position.row][position.column] != first) {
				return Piece.Empty;
			}
		}
		return first;
	}
	
	class PositionIterator implements Iterator<Position> {
		private int rowIncrement, colIncrement, size;
		private Position current;
		
		public PositionIterator(Position p, int rowIncrement, int colIncrement, int size) {
			this.rowIncrement = rowIncrement;
			this.colIncrement = colIncrement;
			this.size = size;
			current = new Position(p.row - rowIncrement, p.column - colIncrement);
		}
		
		@Override
		public boolean hasNext() {
			return current.row + rowIncrement < size &&
					current.column + colIncrement < size;
		}
		
		@Override
		public Position next() {
			current = new Position(current.row + rowIncrement, current.column + colIncrement);
			return current;
		}
	}
	
	public class Position {
		public int row, column;
		public Position(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}
}
