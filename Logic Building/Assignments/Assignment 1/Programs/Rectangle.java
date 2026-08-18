
import java.util.*;

class Rectangle {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter length");
		int length = sc.nextInt();
		
		System.out.println("Enter breadth");
		int breadth = sc.nextInt();
		
		System.out.println("Area = " + length * breadth);
	}
}