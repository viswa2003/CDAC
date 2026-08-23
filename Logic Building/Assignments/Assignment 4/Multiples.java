
import java.util.*;

public class Multiples {
	
	static void multiple(int num) {
		for(int i = 1; i <= num; i++) {
			if (i % 3 == 0) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number");
		int num = sc.nextInt();
		
		multiple(num);
	}
}