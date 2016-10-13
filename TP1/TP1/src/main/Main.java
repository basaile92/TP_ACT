package main;

import java.util.ArrayList;

import ressources.Point;
import ressources.Rectangle;

public class Main {

	public static void main(String[] args) {

		ArrayList<Point> pointList = new ArrayList<Point>();
		pointList.add(new Point(2,5));
		pointList.add(new Point(5,17));
		pointList.add(new Point(11,4));
		pointList.add(new Point(16,6));		
		pointList.add(new Point(20,1));
		Rectangle rectangle = new Rectangle(pointList, 20, 25);
		
		System.out.println("Nombre de points: " + rectangle.getNumberOfPoint());
		System.out.println("Surface du rectangle (getBiggestAreaRectangle()): " + rectangle.getBiggestAreaRectangle());
		rectangle.printNbrCmpAndSetToZ();

		System.out.println("Surface du rectangle (getBiggestAreaRectangle2()): " + rectangle.getBiggestAreaRectangle2());
		rectangle.printNbrCmpAndSetToZ();
		System.out.println("Surface du rectangle (getBiggestAreaRectangleRec()): " + rectangle.getBiggestAreaRectangleRec());
		rectangle.printNbrCmpAndSetToZ();
	}

}
