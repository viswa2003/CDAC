import java.util.*; 

class Count {
	
	static void takeInput(int arr[], Scanner sc) {
		
		System.out.println("Enter 6 integers: ");
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
	}
	
	static void displayCount(int arr[]) {
		
		int positive = 0;
		int negative = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				positive += 1;
			}
			else if (arr[i] < 0){
				negative += 1;
			}
		}
		
		System.out.println("Positive: " + positive);
		System.out.println("Negative: " + negative);
		
	}
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[6];
		
		Count.takeInput(arr, sc);
		Count.displayCount(arr);
		
	}
}