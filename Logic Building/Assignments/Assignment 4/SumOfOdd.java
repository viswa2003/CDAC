
import java.util.*;

public class SumOfOdd {
	
	static void oddSum(int num) {
		
		int sum = 0;
		for(int i = 1; i<= num; i++) {
			if(i % 2 != 0) {
				sum += i;
			}
		}
		
		System.out.println("The sum of odd numbers from 1 and " + num + " is " + sum);
		
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number: ");
		int num = sc.nextInt();
		
		SumOfOdd.oddSum(num);
	}
}