package crackingTheCodeInterviewExs_OOD;

import java.util.LinkedList;

public class IQ_7_6_Jigsaw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public enum Orientation {
		LEFT, TOP, RIGHT, BOTTOM; // Should stay in this order
	
		public Orientation getOpposite(){
			switch(this) {
			case LEFT: return RIGHT;
			case RIGHT: return LEFT;
			case TOP: return BOTTOM;
			case BOTTOM: return TOP;
			default: return null;
			}
		}
	}
	
	public enum Shape {
		INNER, OUTER, FLAT;
		
		public Shape getOpposite() {
			switch (this) {
				case INNER: return OUTER;
				case OUTER: return INNER;
				default: return null;
			}
		}
	}
	
	public class Puzzle {
		private LinkedList<Piece> pieces; /* Remaining pieces to put away. */
		private Piece[][] solution;
		private int size;
		
		public Puzzle(int size, LinkedList<Piece> pieces) {}
		
		private void setEdgeInSolution(LinkedList<Piece> pieces, Edge edge, int row,
				int column, Orientation orientation) {
			Piece piece = edge.getParentPiece();
			piece.setEdgeAsOrientation(edge, orientation);
			pieces.remove(piece);
			solution[row][column] = piece;
		}
		
		/* Find the matching piece in piecesToSearch and insert it at row, column. */
		private boolean fitNextEdge(LinkedList<Piece> piecesToSearch, int row, int col);
		
		/* Solve puzzle. */
		public boolean solve() {}
	}
	
	public class Piece {
		private HashMap<Orientation, Edge> edges = new HashMap<Orientation, Edge>();
		
		public Piece(Edge[] edgeList) {}
		
		/* Rotate edges by "numberRotations". */
		public void rotateEdgeBy(int numberRotations) {}
		
		public boolean isCorner() {}
		public boolean isBorder() {}
	}
	
	public class Edge{
		private Shape shape;
		private Piece parentPiece;
		public Edge(SHape shape) {}
		public boolean fitsWith(Edge edge) {}
	}
	
	boolean fitNextEdge(LinkedList<Piece> piecesToSearch, int row, int column) {
		if (row == 0 && column == 0) {
			Piece p = piecesToSearch.remove();
			orientTopLeftCorner(p);
			solution[0][0] = p;
		} else {
			/* Get the right edge and list to match. */
			Piece pieceToMatch = column == 0 ? solution[row -1][0] :
												solution[row][column - 1];
			Orientation orientationToMatch = column == 0 ? Orientation.BOTTOM :
															Orientation.RIGHT;
			Edge edgeToMatch = pieceToMatch.getEdgeWithOrientation(orientationToMatch);
			
			/* Get matching edge. */
			Edge edge = getMatchingEdge(edgeToMatch, piecesToSearch);
			if (edge == null) return false; // Can't solve
			
			/* Insert piece and edge */
			Orientation orientation = orientationToMatch.getOpposite();
			setEdgeInSolution(piecesToSearch, edge, row, column, orientation);
		}
		return true;
	}
	
	boolean solve() {
		/* Group pieces. */
		LinkedList<Piece> cornerPieces = new LinkedList<Piece>();
		LinkedList<Piece> borderPieces = new LinkedList<Piece>();
		LinkedList<Piece> insidePieces = new LinkedList<Piece>();
		groupPieces(cornerPieces, borderPieces, insidePieces);
		
		/* Walk through puzzle, finding the piece that joins the previous one. */
		solution = new Piece[size][size];
		for (int row = 0; row < size; row++) {
			for (int column =0; column < size; column++) {
				LinkedList<Piece> piecesToSearch = getPieceListToSearch(cornerPieces,
						borderPieces, insidePieces, row, column);
				if (!fitNextEdge(piecesToSearch, row, column)) {
					return false;
				}
			}
		}
		return true;
	}
}
