package day7;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
	public static void bubbleSort(int[] arr) {
		
		for(int i = 0; i < arr.length - 1 ; i++) {
			for(int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			System.out.println(Arrays.toString(arr) + " passes : " + (i + 1));
		}
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		
		int[] arr = new int[20];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(1000);
		}
		
		System.out.println(Arrays.toString(arr));

		bubbleSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
}
