 
 public class Intern{
	 public static void main(String args[]) {
		String str1 = new String("Hello");
		String str2 = str1.intern();
		String str3 = "Hello";
		
		System.out.println("Is str2 and str3 pointing to the same object? " + (str2 == str3));
		
	 }
 }