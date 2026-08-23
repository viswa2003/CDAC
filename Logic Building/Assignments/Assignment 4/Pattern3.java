
public class Pattern3 {
	public static void main(String args[]) {
		for(int i = 1; i <= 9; i += 2) {
			for(int j = 1; j <= i; j += 2) {
				System.out.print(j);
				
				if(i > j) {
					System.out.print("*");
				}
			}
			
			System.out.println();
		}
	}
}