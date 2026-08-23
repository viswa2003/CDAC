
import java.util.*;

class Average {
	
	static void takeInput(int arr[], Scanner sc) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
	}
	
	static void average(int arr[]) {
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		float avg = sum / arr.length;
		
		System.out.println("The average of numers is: " + avg);
	}
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[5];
		
		System.out.println("Enter 5 integers: ");
		Average.takeInput(arr, sc);
		Average.average(arr);
	}
}