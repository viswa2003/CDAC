
import java.util.*;

public class AsList {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size of the array: ");
		int n = sc.nextInt();
		Integer arr[] = new Integer[n];
		
		System.out.println("Enter elements of array: ");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Enter element to search: ");
		int search = sc.nextInt();
		
		List<Integer> list = Arrays.asList(arr);
		
		if(list.contains(search)) {
			System.out.println("Found");
		}
		else
			System.out.println("Not Found");
			
	}
}