
import java.util.*;

public class SumOfNumbers {
	
	static int sumOfTwoNumbers(int a, int b) {
		int result = a + b;
		return result;
		
	}
	
	public static void main(String ars[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first number: ");
		int num1 = sc.nextInt();
		
		System.out.println("Enter second number: ");
		int num2 = sc.nextInt();
		
		System.out.println("The sum of " + num1 + "and " + num2 + " is " + sumOfTwoNumbers(num1, num2));
		
		
	}
}