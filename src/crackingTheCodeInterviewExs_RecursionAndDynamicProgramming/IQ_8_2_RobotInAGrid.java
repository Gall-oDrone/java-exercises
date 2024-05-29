package crackingTheCodeInterviewExs_RecursionAndDynamicProgramming;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

public class IQ_8_2_RobotInAGrid {

	public static void main(String[] args) {
		
	}
	
	ArrayList<Point> getPath(boolean[][] maze) {
		if (maze == null || maze.length == 0) return null;
		ArrayList<Point> path = new ArrayList<Point>();
		if (getPath(maze, maze.length -1, maze[0].length - 1, path)) {
			return path;
		}
		return null;
	}
	
	boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
		/* If out of bounds or not available, return. */
		if (col < 0 || row < 0 || !maze[row][col]) {
			return false;
		}
		boolean isAtOrigin = (row == 0) && (col == 0);
		
		/* If there's a path from the start to here, add my location. */
		if (isAtOrigin || getPath(maze, row, col -1, path) ||
				getPath(maze, row - 1, col, path)) {
			Point p = new Point(row, col);
			path.add(p);
			return true;
		}
		return false;
	}
	
	ArrayList<Point> getPathDynamic(boolean[][] maze) {
		if (maze == null || maze.length == 0) return null;
		ArrayList<Point> path = new ArrayList<Point>();
		HashSet<Point> failedPoints = new HashSet<Point>();
		if (getPathDynamic(maze, maze.length -1, maze[0].length - 1, path, failedPoints)) {
			return path;
		}
		return null;
	}
	
	boolean getPathDynamic(boolean[][] maze, int row, int col, ArrayList<Point> path,
			HashSet<Point> failedPoints) {
		/* If out of bounds or not available, return.*/
		if (col < 0 || row < 0 || !maze[row][col]){
			return false;
		}
		
		Point p = new Point(row, col);
		
		/* If we've already visited this cell, return. */
		if (failedPoints.contains(p)) {
			return false;
		}
		
		// Suponer que row y col lo da el problema
		boolean isAtOrigin = (row == 0) && (col == 0);
		
		/* If there's a path from start to my current location, add my location.*/
		if (isAtOrigin || getPathDynamic(maze, row, col- 1, path, failedPoints) ||
				getPathDynamic(maze, row -1, col, path, failedPoints)) {
			path.add(p);
			return true;
		}
		
		failedPoints.add(p); // Cache result
		return false;
	}
}
