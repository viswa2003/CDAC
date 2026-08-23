
import java.util.*;

public class SumNumbers {
	
	static int calculateSum(int num) {
		int sum = 0;
		for(int i = 1; i <= num; i++) {
			sum += i; 
		}
		return sum;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number: ");
		int num = sc.nextInt();
		
		System.out.println("The sum of numbers form 1 to " + num + " is " + calculateSum(num)); 
	}
}