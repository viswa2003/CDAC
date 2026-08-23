
import java.math.*;
import java.util.*;

class Largest {
	
	static void takeInput(int arr[], Scanner sc) {
		
		for(int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
		}
	}
	
	static void largest(int arr[]) {
		
		int max = 0;
		
		for(int i = 0; i < 4; i++) {
			max = Math.max(arr[i], arr[i + 1]);
			
		}
		
		System.out.println("The largest element is: " + max);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[5];
		
		System.out.println("Enter 5 integers: ");
		
		Largest.takeInput(arr, sc);
		Largest.largest(arr);
		
	}
}