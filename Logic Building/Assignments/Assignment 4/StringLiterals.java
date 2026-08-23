
public class StringLiterals {
	public static void main(String args[]) {
		
		String str1 = "Hello";
		String str2 = "Hello";
		System.out.println("Both variables point to the same object: ");
		
		if(str1 == str2) {
			System.out.print("True");
		}
		else
			System.out.print("False");
	}
}