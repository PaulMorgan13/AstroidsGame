

import java.awt.Color;
import java.awt.Graphics;

/*
CLASS: Polygon
DESCRIPTION: A polygon is a sequence of points in space defined by a set of
             such points, an offset, and a rotation. The offset is the
             distance between the origin and the center of the shape.
             The rotation is measured in degrees, 0-360.
USAGE: You are intended to instantiate this class with a set of points that
       forever defines its shape, and then modify it by repositioning and
       rotating that shape. In defining the shape, the relative positions
       of the points you provide are used, in other words: {(0,1),(1,1),(1,0)}
       is the same shape as {(9,10),(10,10),(10,9)}.
NOTE: You don't need to worry about the "magic math" details.
Original code by Dan Leyzberg and Art Simon.
Modified by Megan Owen
 */

public class Polygon {
	protected Point[] shape;   // An array of points.
	protected Point position;   // The offset mentioned above.
	protected double rotation; // Zero degrees is due east.

	public Polygon(Point[] inShape, Point inPosition, double inRotation) {
		shape = inShape;
		position = inPosition;
		rotation = inRotation;

		// First, we find the shape's top-most left-most boundary, its origin.
		Point origin = shape[0].clone();
		for (Point p : shape) {
			if (p.getX() < origin.getX()) {
				origin.setX(p.getX());
			}
			if (p.getY() < origin.getY())  {
				origin.setY(p.getY());
			}
		}

		// Then, we orient all of its points relative to the real origin.
		for (Point p : shape) {
			p.addToX(-origin.getX());
			p.addToY(- origin.getY());
		}
	}

	public Polygon(int i, int j, double inRotation) {
		// TODO Auto-generated constructor stub
	}

	// "getPoints" applies the rotation and offset to the shape of the polygon.
	public Point[] getPoints() {
		Point center = findCenter();
		Point[] points = new Point[shape.length];
		for (int i = 0; i < shape.length; i++) {
			//    for (Point p : shape) {
			Point p = shape[i];
			double x = ((p.getX()-center.getX()) * Math.cos(Math.toRadians(rotation)))
					- ((p.getY()-center.getY()) * Math.sin(Math.toRadians(rotation)))
					+ center.getX()/2 + position.getX();
			double y = ((p.getX()-center.getX()) * Math.sin(Math.toRadians(rotation)))
					+ ((p.getY()-center.getY()) * Math.cos(Math.toRadians(rotation)))
					+ center.getY()/2 + position.getY();
			points[i] = new Point(x,y);
		}
		return points;
	}

	// "contains" implements some magical math (i.e. the ray-casting algorithm).
	public boolean contains(Point point) {
		Point[] points = getPoints();
		double crossingNumber = 0;
		for (int i = 0, j = 1; i < shape.length; i++, j=(j+1)%shape.length) {
			if ((((points[i].getX() < point.getX()) && (point.getX() <= points[j].getX())) ||
					((points[j].getX() < point.getX()) && (point.getX() <= points[i].getX()))) &&
					(point.getY() > points[i].getY() + (points[j].getY()-points[i].getY())/
							(points[j].getX() - points[i].getX()) * (point.getX() - points[i].getX()))) {
				crossingNumber++;
			}
		}
		return crossingNumber%2 == 1;
	}

	public void rotate(int degrees) {rotation = (rotation+degrees)%360;}

	/*
  The following methods are private access restricted because, as this access
  level always implies, they are intended for use only as helpers of the
  methods in this class that are not private. They can't be used anywhere else.
	 */

	// "findArea" implements some more magic math.
	private double findArea() {
		double sum = 0;
		for (int i = 0, j = 1; i < shape.length; i++, j=(j+1)%shape.length) {
			sum += shape[i].getX()*shape[j].getY()-shape[j].getX()*shape[i].getY();
		}
		return Math.abs(sum/2);
	}

	// "findCenter" implements another bit of math.
	private Point findCenter() {
		Point sum = new Point(0,0);
		for (int i = 0, j = 1; i < shape.length; i++, j=(j+1)%shape.length) {
			sum.addToX( (shape[i].getX() + shape[j].getX())
					* (shape[i].getX() * shape[j].getY() - shape[j].getX() * shape[i].getY()) );
			sum.addToY( (shape[i].getY() + shape[j].getY())
					* (shape[i].getX() * shape[j].getY() - shape[j].getX() * shape[i].getY()) );
		}
		double area = findArea();
		return new Point(Math.abs(sum.getX()/(6*area)),Math.abs(sum.getY()/(6*area)));
	} 
	//paint method
	public void paint(Graphics brush){
		Point ps[] = getPoints();
		
		int x[] = new int[ps.length]; 
		int y[] = new int[ps.length]; 
		
		for(int i = 0; i <ps.length; i++){  
			x[i] = (int)ps[i].getX();
			y[i] = (int)ps[i].getY();
		}
		
		brush.drawPolygon(x,y,ps.length);
		brush.fillPolygon(x,y,ps.length);
	} 
	
}