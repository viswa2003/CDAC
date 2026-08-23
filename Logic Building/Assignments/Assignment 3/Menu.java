
import java.util.*;

public class Menu {
	
	
	static void gradeEvaluation() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter marks for maths: ");
		int maths = sc.nextInt();
		
		System.out.println("Enter marks for science: ");
		int science = sc.nextInt();
		
		System.out.println("Enter marks for history: ");
		int history = sc.nextInt();
		
		int avg = (maths + science + history) / 3;
		
		String result = (avg >= 90) ? "Grade: A" : (avg >= 70) ? "Grade B" : (avg >= 50) ? "Grade C" : (avg >= 30) ? "Grade D" : "Fail";
		
		System.out.println(result);
		
		return;
		
		
	
	}
	
	static void leapYear() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a year: ");
		int year = sc.nextInt();
		
		String result = (year % 400 == 0) ? "Leap Year" : (year % 100 != 0 && year % 4 == 0) ? "Leap Year" : "Not Leap Year";
		
		System.out.println(result);
		return;
		
	}
	
	static void dayOfWeek() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter day number: ");
		int day = sc.nextInt();
		
		String result = (day == 1) ? "Monday" : (day == 2) ? "Tuesday" : (day == 3) ? "Wednesday" : (day == 4) ? "Thursday" : (day == 5) ? "Friday" : (day == 6) ? "Saturday" : (day == 7) ? "Sunday" : "Enter valid day number";
		
		System.out.println(result);
		return;
	}
	

	static void variables() {

		byte a = 0;
		short b = 0;
		int c = 0;
		long d = 0;
		float e = 0.0f;
		double f = 0.0;
		char g = '\u0000';
		boolean h = false;

		System.out.println("byte: " + a);
		System.out.println("short: " + b);
		System.out.println("int: " + c);
		System.out.println("long: " + d);
		System.out.println("float: " + e);
		System.out.println("double: " + f);
		System.out.println("char: " + g);
		System.out.println("boolean: " + h);
	}
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int choice;
		
		do {
			
			System.out.println("Choose a number: \n1: Grade Evaluation System \n2: Leap Year Check \n3: Day of the Week \n4. Identify Default Values \n5: Exit");
			
			choice = sc.nextInt();

			switch (choice) {
				case 1 : gradeEvaluation();
							break;
							
				case 2 : leapYear();
							break;
							
				case 3 : dayOfWeek();
							break;
				
				case 4 : variables();
							break;
							
				default : System.out.println("Choose valid number");
			}
			
		
		
		}
		while (choice != 5);
	}
}