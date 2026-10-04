package assignment_2;

import java.util.ArrayList;
import java.util.Scanner;

public class BusiestK_MinuteWindow {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("Enter no of requests : ");
//		int num = sc.nextInt();
//		sc.nextLine();
//		
//		ArrayList<Integer> requests = new ArrayList<>();
//		
//		for(int i = 0; i < num; i++) {
//			int req = sc.nextInt();
//			
//			requests.add(req);
//		}
//		
//		System.out.println("Enter window size: ");
//		int k = sc.nextInt();
		
		int[] requests = {120, 340, 560, 210, 90, 680, 720, 150};
		
		int k = 3;
		
		if(requests.length < k) 
			return;
		
		long sum = 0;
		
//		First k-sums
		for(int i = 0; i < k; i++) {
			sum += requests[i];
		}
		
		long maximum = sum;
		int index =  k - 1;
		
		for(int i = k; i < requests.length; i++) {
			sum = sum - requests[i - k] + requests[i];
			
			if(sum > maximum) {
				maximum = sum;
				
				index = i;
			}
			
		}
		
		System.out.printf("Peak %d-minute load = %d requests (minutes %d to %d)", k, maximum, (index - k + 2), index + 1);
		
	}
	
}













