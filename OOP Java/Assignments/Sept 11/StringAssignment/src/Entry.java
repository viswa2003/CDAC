
public class Entry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Q1
		System.out.println("Enter a string : ");
		String str = ConsoleInput.getString();
		
		System.out.println("Enter index : ");
		int index = ConsoleInput.getInt();
		
		System.out.println("The charecter at index " + index + " is " + str.charAt(index));
		
//		Q2
		System.out.println("Enter a string 1: ");
		String str1 = ConsoleInput.getString();
		
		System.out.println("Enter a string 2: ");
		String str2 = ConsoleInput.getString();
		
		int result = str1.compareTo(str2);
		
		if(result > 0) 
			System.out.println( str1 + " is greater than " + str2);
		else if(result < 0) 
			System.out.println(str2 + " is greater than " + str1);
		else
			System.out.println( str1 + " is equal to " + str2);
		
		System.out.println("Enter a string : ");
		String str3 = ConsoleInput.getString();
		
		System.out.println("Enter another string : ");
		String ending = ConsoleInput.getString();
		
		System.out.println(str3 + " ends with " + ending + " ? : " + str3.endsWith(ending));
		

//		Q5
		System.out.println("Enter a string : ");
		String str5 = ConsoleInput.getString();
		
		System.out.println("Enter which string to replace : ");
		String replaceto = ConsoleInput.getString();
		
		System.out.println("Enter a string to replace : ");
		String replacewith = ConsoleInput.getString();
		
		String replacedString = str5.replace(replaceto, replacewith);
		System.out.println(replacedString);
		
		
//		Q6
		System.out.println("Enter a string : ");
		String str6 = ConsoleInput.getString();
		System.out.println(str6.toUpperCase());
	
		
//		Q7
		System.out.println("Enter a string : ");
		String str7 = ConsoleInput.getString();
		
		for(int iTmp = str7.length()-1; iTmp >= 0 ; iTmp--) {
			System.out.print(str7.charAt(iTmp));
		}
		
		
		
	}

}
