
import java.util.*;

public class AgeChecker {
	
	static void checkAgeCategory(int age) {
		
		String result = (age > 60) ? "Senior citizen" : (age >= 18) ? "Adult" : "Minor";
		
		System.out.println("You are an " + result);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter age: ");
		int age = sc.nextInt();
		
		AgeChecker.checkAgeCategory(age);
	}
}