
public class forLoopOperations {

//	1 - Print odd
	public static void displayOdd() {
		for(int iTmp = 0; iTmp <= 1000; iTmp++) {
			if(iTmp % 2 != 0) 
				System.out.println(iTmp + " ");
		}
	}
//	2 - Print even
	public static void displayEven() {
		for(int iTmp = 0; iTmp <= 500; iTmp++) {
			if(iTmp % 2 == 0) 
				System.out.println(iTmp + " ");
		}
	}
	
//	3 - Every 7th
	public static void displaySeventh() {
		for(int iTmp = 7; iTmp < 200; iTmp += 7) {
			System.out.println(iTmp + " ");
		}
	}
	
	
//	4 - Right triangle
	public static void rightTriangle() {
		for(int iTmp = 1; iTmp <= 5; iTmp ++) {
			for(int iTmp2 = 1; iTmp2 <= iTmp; iTmp2++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
//	5 - Inverted right triangle
	public static void invertedTriangle() {
		for(int iTmp1 = 5; iTmp1 >= 1; iTmp1--) {
			for(int iTmp2 = 1; iTmp2 <= iTmp1; iTmp2++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	
//	6 - number triangle
	public static void numberTriangle() {
		int count = 1;
		for(int iTmp = 1; iTmp <= 4; iTmp++) {
			for(int iTmp1 = 1; iTmp1 <= iTmp; iTmp1++) {
				System.out.print(count + " ");
				count++;
			}
			System.out.println();
		}
	}
	
	
//	7 - right number triangle
	public static void rightNumberTriangle() {
		for(int iTmp1 = 1; iTmp1 <= 6; iTmp1++) {
			for(int iTmp2 = 1; iTmp2 <= iTmp1; iTmp2++) {
				System.out.print(iTmp2);
			}
			System.out.println();
		}
	}
	
	
//	8 - inverted number triangle
	public static void invertedNumberTriangle() {
		for(int iTmp = 6; iTmp >= 1; iTmp--) {
			for(int iTmp2 = 1; iTmp2 <= iTmp; iTmp2++) {
				System.out.print(iTmp2);
			}
			System.out.println();
		}
	}
	
	
}



















