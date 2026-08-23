
import java.util.*; 

public class Palindrome {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String reversed = "";
		
		System.out.println("Enter a string: ");
		String st = sc.nextLine();
		
		for(int i = st.length() - 1; i >= 0; i--) {
			reversed += st.charAt(i);
		}
		
		if(st.equals(reversed)) {
			System.out.printf("The string %s is a palindrome", st);
		}
		else
			System.out.printf("The string %s is a not palindrome", st);
			
	}
}