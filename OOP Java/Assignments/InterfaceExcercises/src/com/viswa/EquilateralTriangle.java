package com.viswa;

public class EquilateralTriangle implements RegularPolygon {
	
	public int sideLength;
	
	public EquilateralTriangle(int sideLength) {
		this.sideLength = sideLength;
	}

	@Override
	public int getNumSides() {
		
		return 3;
	}

	@Override
	public int getSideLength() {
		return this.sideLength;
	}

}
