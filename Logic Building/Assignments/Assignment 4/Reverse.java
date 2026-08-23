
import java.util.*;

public class Reverse {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String reversed = "";
		
		System.out.println("Enter a string: ");
		String str = sc.nextLine();
		
		for(int i = str.length() - 1; i >= 0; i--) {
			reversed += str.charAt(i);
		}
		
		
		System.out.printf("Reversed string: %s", reversed);
		
		
	}
}