package com.viswa;

import java.util.ArrayList;

public class Entry {

	public static void main(String[] args) {

		ArrayList<String> colors = new ArrayList<String>();

		// 1. 

		colors.add("Red");
		colors.add("Green");
		colors.add("Blue");
		colors.add("Yellow");

		System.out.println("1. Colors: " + colors);


		// 2. 

		colors.add(0, "Orange");

		System.out.println("2. After inserting at first position: " + colors);


		// 3. 
		
		int index = 2;

		System.out.println("3. Element at index " + index + ": " + colors.get(index));


		// 4. 

		colors.set(2, "Black");

		System.out.println("4. After updating element: " + colors);


		// 5.

		colors.remove(2);

		System.out.println("5. After removing third element: " + colors);


		// 6. 

		String color = "Blue";

		if (colors.contains(color)) {
			System.out.println("6. " + color + " found in the ArrayList");
		} else {
			System.out.println("6. " + color + " not found in the ArrayList");
		}
	}
}