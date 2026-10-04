package day7;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
	public static void mergeSort(int[] arr) {		
		int length = arr.length;
		int middle = length / 2;
		
		if(length < 2)
			return;
		
		int[] leftArr = new int[middle];
		int[] rightArr = new int[length - middle];
		
		for(int i = 0; i < middle; i++) {
			leftArr[i] = arr[i];
		}
		
		for(int j = middle; j < length; j++) {
			rightArr[j - middle] = arr[j];
		}
		
		mergeSort(leftArr);
		mergeSort(rightArr);
		
//		Merge method
		
		merge(arr, leftArr, rightArr);
		
	}
	
	private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
		int leftSize = leftArr.length;
		int rightSize = rightArr.length;
		
		int i = 0, j = 0, k = 0;
		
		while(i < leftSize && j < rightSize) {
			if(leftArr[i] <= rightArr[j]) {
				arr[k++] = leftArr[i++];				
			}
			else {
				arr[k++] = rightArr[j++];				
			}			
		}
		while(i < leftSize)
			arr[k++] = leftArr[i++];
		while(j < rightSize)
			arr[k++] = rightArr[j++];
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		int[] arr = new int[20];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(100);
		}
		
		System.out.println(Arrays.toString(arr));
		
		mergeSort(arr);

		System.out.println(Arrays.toString(arr));
	}
}
