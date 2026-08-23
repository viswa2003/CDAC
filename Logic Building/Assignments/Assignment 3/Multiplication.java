
import java.util.*;

public class Multiplication {
	static void printMultiplication(int num) {
		for(int i = 1; i <= 10; i++) {
			System.out.println(num + " X " + i + " = " + num * i);
		}
		
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number: ");
		int num = sc.nextInt();
		printMultiplication(num);
	}
}