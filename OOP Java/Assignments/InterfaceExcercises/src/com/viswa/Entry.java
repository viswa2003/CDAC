package com.viswa;

public class Entry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RegularPolygon[] polygons = {
				new EquilateralTriangle(10),
				new Square(20),
				new Square(30)
		};
		
		System.out.println("Total sides : " + RegularPolygon.totalSide(polygons));
		
		for(RegularPolygon polygon : polygons) {
			System.out.println("\nsides : " + polygon.getNumSides());
			System.out.println("side length : " + polygon.getSideLength());
			System.out.println("perimeter : " + polygon.getPerimeter());
			System.out.println("angle : " + polygon.getInteriorAngle());
		}
	}

}
