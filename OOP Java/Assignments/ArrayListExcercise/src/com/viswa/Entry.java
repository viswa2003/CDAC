package com.viswa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

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
		
		// 7
		
		Collections.sort(colors);
		
		System.out.println("After sorting : " + colors);
		
		//8
		ArrayList<String> copyColors = new ArrayList<>(colors);
		
//		Collections.copy(copyColors, colors); //need to add empty strings using loop to allocate size
		
		System.out.println("After copying : " + copyColors);
		
		//9
		Collections.shuffle(copyColors);
		
		System.out.println("After shuffling : " + copyColors);
		
		
		//10
		
		Collections.reverse(copyColors);
		
		System.out.println("After reversing : " + copyColors);
		
		
		//11
		
		TreeSet<String> treeSet = new TreeSet<>();
		
		treeSet.addAll(colors);
		
		System.out.println("tree set : " + treeSet);
		
		//12
		TreeSet<String> secondTreeSet = new TreeSet<>(treeSet);
		
		System.out.println("second tree set : " + treeSet);
		
		//13
		secondTreeSet.descendingSet();
		
		System.out.println("descending tree set : " + treeSet);
		
		//14
		System.out.println("First : " + treeSet.first());
		System.out.println("Last: " + treeSet.last());
		
		//15
		String given = "Green";
		
		System.out.println(treeSet.ceiling(given));
	}
}
