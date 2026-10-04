package day7;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

	public static void selectionSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int min = i;
			
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		
		int[] arr = new int[20];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(100);
		}
		
		System.out.println(Arrays.toString(arr));
		
		selectionSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
	
}
