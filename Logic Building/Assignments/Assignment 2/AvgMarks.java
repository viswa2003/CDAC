
import java.util.*;

class AvgMarks{
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Marks in Maths: ");
		int maths = sc.nextInt();
		
		System.out.println("Marks in Science: ");
		int science = sc.nextInt();
		
		System.out.println("marks in History: ");
		int history = sc.nextInt();
		
		int average = (maths + science + history) / 3;
		System.out.println("Average Marks: " + average);
		if (average >= 90) {
			System.out.println("Grade: A");
		} 
		else if (average >= 70) {
			System.out.println("Grade: B");			
		}
		else if (average >= 50) {
			System.out.println("Grade: C");
		}
		else if (average >= 30) {
			System.out.println("Grade: D");
		}
		else 
			System.out.println("Grade: Fail");
	}
}