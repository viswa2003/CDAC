
import java.util.*;

public class PrintArrayNames {
		
	static void display(String arr[]) {
		
		for(String name : arr) {
			System.out.println(name);
		}
	} 
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String arr[] = new String[4];
		
		System.out.print("Enter 4 names: ");
		arr = sc.nextLine().split(" ");
		
		PrintArrayNames.display(arr);
		
		
	}
}