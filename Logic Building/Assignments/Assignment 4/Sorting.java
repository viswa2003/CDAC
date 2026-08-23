
import java.util.*;

public class Sorting {
	
	static void takeInput(int arr[], Scanner sc) {
		
		System.out.println("Enter 5 integers: ");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
	}
	
	static void display(int arr[]) {
		for(int nums : arr) {
			System.out.print(nums + " ");
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[5];
		
		Sorting.takeInput(arr, sc);
		Arrays.sort(arr);
		
		System.out.print("Sorted array: ");
		Sorting.display(arr);
	}
}