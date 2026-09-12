
public class ArrayOperations {
	
//	2 - Sorting
	static int[] sort(int[] arr) {
		for(int iTmp = 0; iTmp < arr.length - 1; iTmp++) {
			for(int iTmp2 = 0; iTmp2 < arr.length - 1; iTmp2++) 
			{
				
				if(arr[iTmp2] > arr[iTmp2 + 1]) 
				{
					int temp = arr[iTmp2];
					arr[iTmp2] = arr[iTmp2 + 1];
					arr[iTmp2 + 1] = temp;
				}
			}
		}
		return arr;
	}
	
	
//	3 - Sum
	static int sumArray(int[] arr) {
		int sum = 0;
		for(int iTmp = 0; iTmp < arr.length; iTmp++) {
			sum += arr[iTmp];
		}
		return sum;
	}
	
	
	
//	4 Average
	static int average(int[] arr) {
		int avg = sumArray(arr) / arr.length;
		return avg;
	}
	
	
	
//	5 - Array Copy
	static int[] arrayCopy(int[] arr) {
		int[] copyArray = new int[arr.length];
		
		for(int iTmp = 0; iTmp < arr.length; iTmp++) {
			copyArray[iTmp] = arr[iTmp];
		}
		return copyArray;
	}
	
//	6 - Max and Min
	
	static void maxMin(int[] arr) {
		int maximum = Integer.MIN_VALUE;
		int minimum= Integer.MAX_VALUE;
		
		for(int iTmp = 0; iTmp < arr.length; iTmp++) {
			if(arr[iTmp] > maximum) 
				maximum = arr[iTmp];
			if(arr[iTmp] < minimum) 
				minimum = arr[iTmp];
		}
		
		System.out.println("Max value : " + maximum + "\nMin value : " + minimum);
	}
	
	
//	7 - reverse array
	static int[] reverseArray(int[] arr) {
		int[] reverseArr = new int[arr.length];
		
		for (int iTmp = 0; iTmp < arr.length; iTmp++) {
			reverseArr[iTmp] = arr[arr.length - 1 - iTmp];
			}
		return reverseArr;
	}
	
	
//	8 - duplicate values
	static void duplicates(int[] arr) {
		
		for(int iTmp = 0; iTmp < arr.length; iTmp++) {
			for(int iTmp2 = iTmp + 1; iTmp2 < arr.length; iTmp2++) {
				if(arr[iTmp] == arr[iTmp2]) {
					System.out.print(arr[iTmp] + " ");				
				}
			}
		}
	}
	
	
//	10 - common elements of 2 array
	static int[] commonElements(int[] arr1, int[] arr2) {
		int[] commonArr = new int[arr1.length];
		int index = 0;
		
		for(int iTmp = 0; iTmp < arr1.length; iTmp++) {
			for(int iTmp2 = 0; iTmp2 < arr2.length; iTmp2++) {
				if(arr1[iTmp] == arr2[iTmp2]) {
					commonArr[index] = arr1[iTmp];
					index++;
				}
			}
		}
		return commonArr;
		
		
		

	}
	
	
}



