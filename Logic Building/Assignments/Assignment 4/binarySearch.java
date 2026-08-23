
import java.util.*;

public class binarySearch {
	public static void main(String args[]) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of elements: ");
		int n = sc.nextInt();
		
		int arr[] = new int[n];
			
		System.out.println("Enter elements: ");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Enter number to search: ");
		int search = sc.nextInt();
				
		int index = Arrays.binarySearch(arr, search);
		
		if(index >= 0) {
			System.out.printf("The number %d found at index %d", search, index);
		}
		else {
			System.out.println("Not found");
			
		}
	
	}
	
	
}