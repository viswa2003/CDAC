
import java.util.*;

public class Positive {
	
	static void askForPositiveNumber() {
		Scanner sc = new Scanner(System.in);
		int num;
		
		do {
			System.out.println("Enter a positive number: ");
			num = sc.nextInt();
		}
		while (num <= 0);
	}
	
	
	public static void main (String args[]) {
		askForPositiveNumber();
		
	}
}