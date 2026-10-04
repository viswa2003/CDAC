package day7;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	
	public static void quickSort(int[] arr) {
		int lowIndex = 0;
		int highIndex = arr.length - 1;
		
		quickSort(arr, lowIndex, highIndex);
	}
	
	public static void quickSort(int[] arr, int lowIndex, int highIndex) {
		
		if(lowIndex >= highIndex) {
			return;
		}
		
		int pivotIndex = partition(arr, lowIndex, highIndex);
		
		quickSort(arr, lowIndex, pivotIndex - 1);
		quickSort(arr, pivotIndex + 1, highIndex);
		
	}

	private static int partition(int[] arr, int lowIndex, int highIndex) {
		int pivot = arr[highIndex];
		
		int lowPointer = lowIndex - 1;
		
		for(int currentIndex = lowIndex; currentIndex < highIndex; currentIndex++) {
			if(arr[currentIndex] < pivot) {
				
				lowPointer++;
				
				swap(arr, lowPointer, currentIndex);
			}
		}
		swap(arr, lowPointer + 1, highIndex);	
		
		return lowPointer + 1;
	}

	private static void swap(int[] arr, int lowPointer, int currentIndex) {
		int temp = arr[currentIndex];
		arr[currentIndex] = arr[lowPointer];
		arr[lowPointer] = temp;
	}
	
	
	public static void main(String[] args) {
		Random random = new Random();
		
		int[] arr = new int[10000000];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(10000);
		}
		
		System.out.println("Before : " + Arrays.toString(arr));

		quickSort(arr);
		
		System.out.println("after : " + Arrays.toString(arr));
		
	}
}