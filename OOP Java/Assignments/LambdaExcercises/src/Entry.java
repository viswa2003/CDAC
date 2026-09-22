import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.utilities.ConsoleInput;


public class Entry {

	public static void main(String[] args) {
		
//		Q1
		ArrayList<String> strArr = new ArrayList<>(Arrays.asList("Viswa", "qwe", "Anu", "Abhi"));
//		
//		Comparator<String> comparator = (str1, str22) -> str1.compareTo(str2);
//		
//		strArr.sort(comparator);
		
		strArr.sort((str1, str2) -> str1.compareTo(str2));
		
		System.out.println(strArr);
		
		
//		Q2
		int[] arr = new int[] {10, 20, 30, 40, 15, 35};
		
		Function<int[], Integer> largest = intArr -> {
			int large = arr[0];
			for(int num : intArr) {
				large = Math.max(large, num);
			}
			return large;
		};
		
		System.out.println(largest.apply(arr));
	
//	3
		Integer[] intArr = new Integer[] {10,20,30,40,50,50,6};
		
		Function<Integer[], Integer> minimum = minArr -> {
			int min = minArr[0];
			for(int num : minArr) {
				min = Math.min(num, min);				
			}
			return min;
		};
		
		System.out.println(minimum.apply(intArr));
		
//		4
		Supplier<Integer> randomNumber = () -> {
			double random = Math.random() * 900 + 100;
			return (int)random;
		};
		
		System.out.println("Random : " + randomNumber.get());
		
//		5
		Function<int[], int[]> reverse = arr1 -> {
			int[] reverseArr = new int[arr1.length];
			
			for(int iTmp = 0; iTmp < arr1.length; iTmp++) {
				reverseArr[arr1.length - 1 - iTmp] = arr1[iTmp];
			}
			return reverseArr;
		};
		
		int[] arrayRev = new int[] {1,2,3,4,5,6,7,8,9};
		
		int[] reverseArray = reverse.apply(arrayRev);
		
		for(int iTmp = 0; iTmp < reverseArray.length; iTmp++) {
			System.out.print(reverseArray[iTmp]);
		}
		System.out.println();
		
//		6
		Calendar c = Calendar.getInstance();
		
		int year = c.get(c.YEAR);
		int month = c.get(c.MONTH) + 1;
		int day = c.get(c.DAY_OF_MONTH);
		System.out.println(day + " - " + month + " - " + year);
		
		
		LocalDate date = LocalDate.now();
		System.out.println(date.getDayOfMonth() + " - " + date.getMonthValue() + " - " + date.getYear());
		
//		7
		System.out.println("Enter a number: ");
		int num = ConsoleInput.getInt();
		
		Predicate<Integer> checkPrime = n -> {
			for(int iTmp = 2; iTmp < Math.sqrt(n); iTmp++) {
				if(n % iTmp == 0)
					return false;
			}
			return true;
		};
		
		System.out.println(num + " is prime? " + checkPrime.test(num));
		
//		8
		
		BiFunction<String, String, String> concat = (str1, str2) -> {
			return str1 + str2;
		};
		
		System.out.println("Enter str1 : ");
		String str1 = ConsoleInput.getString();
		System.out.println("Enter str1 : ");
		String str2 = ConsoleInput.getString();
		
		System.out.println(concat.apply(str1, str2));
				
	}

}
