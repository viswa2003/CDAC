package assignment_1;

import java.util.Arrays;

public class Maximum_Minimum {
	
	public static void main(String[] args) {
//		
//		Question 1
		{
			int[] arr = {15, 8, 23, 4, 19, 7};
	
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			
			for(int num : arr) {
				max = Math.max(num,  max);
				min = Math.min(num, min);
			}
			
			System.out.println("Question 1");		
			System.out.println("Max : " + max);		
			System.out.println("Min : " + min);		
		}
//		Question 2
		{
			int[] arr = {12, 5, 8, 20, 15, 20, 7};
			
			int largest = arr[0];
			
			int second = 0;
			
			for(int num : arr) {		
				
				if(num > largest) {
					second = largest;
					largest = num;
				}
				else if(num > second && num < largest) {
					second = num;
				}
			}
			
			System.out.println("Second largest : " + second);
		}
		
		
//		Question 3
		{
			int[] arr = {0,5,0,3,8,0,2,0,5,6,4,0,0,2,3,4};
			
			int left = 0;
			
			for(int right = 0; right < arr.length; right++) {
				
				if(arr[right] != 0) {
					
					arr[left] = arr[right];
					arr[right] = 0;

					left++;
				}
			}
			
			System.out.println(Arrays.toString(arr));
			
		}
	
	}
}