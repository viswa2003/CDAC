
import java.util.*;
public class Vowels {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		char vowels[] = {'a','e','i','o','u'};
		int count = 0;
		
		System.out.println("Enter a string: ");
		String str = sc.nextLine();
		
		for(int i =0; i <= str.length() - 1; i++) {
			char ch = str.charAt(i);
			
			for(char v : vowels) {
				if (ch == v) {
					count ++;
				}
			}
		}
		System.out.printf("The number of vowels in ' %s ' is: %d", str, count);
	}
}