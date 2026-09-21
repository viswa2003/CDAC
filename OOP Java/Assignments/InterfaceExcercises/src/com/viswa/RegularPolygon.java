package com.viswa;

public interface RegularPolygon {
	
	static int totalSide(RegularPolygon[] polygons) {
		
		int total = 0;
		
		for(RegularPolygon poly : polygons) {
			total += poly.getNumSides();
		}
		
		return total;
	}
	
	int getNumSides();
	
	int getSideLength();
	
	default int getPerimeter() {
		return getNumSides() * getSideLength();
	}
	
	default double getInteriorAngle() {
		int n = getNumSides();
		return (n-2) * (Math.PI/n);
	}
	
}
