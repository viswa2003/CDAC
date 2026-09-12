
public class Array {
	public static void main(String[] args) {
				
		System.out.println("Enter size of array: ");
		int size = ConsoleInput.getInt();
		
		int[] arr = new int[size];
		
		
		System.out.println("Enter elements of array: ");
		for(int iTmp = 0; iTmp < size; iTmp++) {
			arr[iTmp] = ConsoleInput.getInt();
		}
		
//		2 - Sort
		int[] sortedArr = ArrayOperations.sort(arr);
		for(int iTmp = 0; iTmp < size; iTmp++) {
			System.out.print(sortedArr[iTmp] + " ");			
		}
		System.out.println();
		
//		3 - Sum
		System.out.println("Sum : " + ArrayOperations.sumArray(arr));

//		4 - Average	
		System.out.println("Avg : " + ArrayOperations.average(arr));
	
//		5 - Array copy
		int[] copyArr = ArrayOperations.arrayCopy(arr);
		for(int iTmp = 0; iTmp < size; iTmp++) {
			System.out.print(copyArr[iTmp] + " ");			
		}
		System.out.println();
		
		
//		6 - Min and Max
		ArrayOperations.maxMin(arr);
		
//		7 - Reverse
		System.out.print("Reverse: ");

		int[] reverse = ArrayOperations.reverseArray(arr);
		for(int iTmp = 0; iTmp < size; iTmp++) {
			System.out.print(reverse[iTmp] + " ");			
		}
		System.out.println();
		
//		8 - Duplicates
		System.out.print("Duplicates : ");
		ArrayOperations.duplicates(arr);
		System.out.println();

//		10 - Common Elements
		System.out.println("Enter second array size : ");
		int size2 = ConsoleInput.getInt();
		int[] arr2 = new int[size2];
		
		System.out.println("Enter second array : ");
		for(int iTmp = 0; iTmp < size2; iTmp++) {
			arr2[iTmp] = ConsoleInput.getInt();
		}
		
		int[] commonArr = ArrayOperations.commonElements(arr, arr2);
		for(int iTmp = 0; iTmp < size - 1; iTmp++) {
			System.out.print(commonArr[iTmp] + " ");			
		}
		System.out.println();
	
	
		
		
//		1 - Complex
		ComplexNumber[] complexArr = new ComplexNumber[5];
		
		for(int iTmp = 0; iTmp < 5; iTmp ++) {
			
			System.out.println("Enter number 1 of complex " + iTmp+1 );
			int number1 = ConsoleInput.getInt();
						
			System.out.println("Enter number 2 of complex " + iTmp+1);
			int number2 = ConsoleInput.getInt();

			complexArr[iTmp] = new ComplexNumber(number1, number2);
							
		}
		
		for(int iTmp = 0; iTmp < 5; iTmp++) {
			System.out.println(complexArr[iTmp].computeComplexNumber());
		}
	
		
	}
}
