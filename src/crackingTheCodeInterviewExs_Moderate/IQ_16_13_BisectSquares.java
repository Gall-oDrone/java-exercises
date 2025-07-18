package crackingTheCodeInterviewExs_Moderate;

import crackingTheCodeInterviewExs_Moderate.IQ_16_3_Intersection.Point;

public class IQ_16_13_BisectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public class Square {
		
		private double left;
		private double right;
		private double top;
		private double bottom;
		private Point point;
		private double size;
		
		public Square(double left, double right, double top, double bottom, Point point) {
			this.left = left;
			this.right = right;
			this.top = top;
			this.bottom = bottom;
			this.point = point;
		}
		
		public class Point {
			
			public double x;
			public double y;
			
			public Point(double x, double y) {
				this.x = x;
				this.y = y;
			}
		}
		
		public Point middle() {
			return new Point((this.left + this.right) / 2.0,
							  this.top + this.bottom) / 2.0);
		}
		
		/* Return the point where the line segment connecting mid1 and mid2 intercepts
		 * the edge of square 1. That is, draw a line from mid2 to mid1, and continue it
		 * out until the edge of the square. 
		 * SLope = (y1 - y2) / (x1 - x2) */
		public Point extend(Point mid1, Point mid2, double size) {
			/* Find what direction the line mid2 -> mid1 goes. */
			double xdir = mid1.x < mid2.x ? -1 : 1;
			double ydir = mid1.y < mid2.y ? -1 : 1;
			
			/* If mid1 and mid2 have the same x value, then the slope calculation will
			 * throw a divide by 0 exception.*/
			if (mid1.x == mid2.x) {
				return new Point(mid1.x, mid1.y + ydir * size / 2.0);
			}
			
			double slope = (mid1.y - mid2.y) / (mid1.x - mid2.x);
			double x1 = 0;
			double y1 = 0;
			
			 /* Calculate slope using the equation (yl - y2)/(xl - x2).
			* Note: if the slope is "steep" (>1) then the end of the line segment will
			* hit size/2 units away from the middle on the y axis. If the slope is
			* "shallow" (<1) the end of the line segment will hit size/2 units away
			* from the middle on the x axis. */

			if (Math.abs(slope) == 1) {
				x1 = mid1.x + xdir * size / 2.0;
				y1 = mid1.y + ydir * size / 2.0;
			} else if (Math.abs(slope) < 1) { // shallow slope
				x1 = mid1.x + xdir * size / 2.0;
				y1 = slope * (x1 - mid1.x) + mid1.y;
			} else { // steep slope
				y1 = mid1.y + ydir * size / 2.0;
				x1 = (y1 - mid1.y) / slope + mid1.x;
			}
			return new Point(x1,y1);
		}
		
		public Line cut(Square other) {
			/* Calculate where a line between each middle would collide with the edges of
			 * the sqaures */
			Point p1 = extend(this.middle(), other.middle(), this.size);
			Point p2 = extend(this.middle(), other.middle(), -1 * this.size);
			Point p3 = extend(other.middle(), this.middle(), other.size);
			Point p4 = extend(other.middle(), this.middle(), -1 * other.size);
			
			/* Of above points, find start and end of lines. Start is farthest left (with
			 * top most as a tie breaker) and end is farthest right (with bottom most as 
			 * a tie breaker. */
			Point start = p1;
			Point end = p1;
			Point[] points = {p2,p3,p4};
			for (int i = 0; i < points.length; i++) {
				if (points[i].x < start.x ||
						(points[i].x == start.x && points[i].y < start.y)) {
					start = points[i];
				} else if (points[i].x > end.x ||
						(points[i].x == end.x && points[i].y > end.y)) {
					end = points[i];
				}
			}
			return new Line(start, end);
		}
	}
}
