package day4;

import java.util.Scanner;

public class binarySearch {
	
	public static int binarySearching(int[] arr, int key, int left, int right) {
		if(left > right)
			return -1;
		int middle = (left + right )/ 2;
		if(arr[middle] == key)
			return middle;
		else {
			if(key < arr[middle]) 
				return binarySearching(arr, key, left, middle - 1);
			else 
				return binarySearching(arr, key, middle + 1, right);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,22,33,44,55,66,77,88,99};
		
		System.out.println("Enter key : ");
		int key = sc.nextInt();
		
		int index = binarySearching(arr, key, 0, arr.length);
		System.out.println(key + " found at index " + index);
	}
	
}
