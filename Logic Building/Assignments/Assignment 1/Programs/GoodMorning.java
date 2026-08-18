
import java.util.*;

class GoodMorning {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter time");
		int time = sc.nextInt();
		
		if (5 < time && time < 12 ) {
			System.out.println("Good Morning");
		}
	}
}