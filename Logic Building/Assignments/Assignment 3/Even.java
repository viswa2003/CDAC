
import java.util.*;

public class Even {
	
	void printEven() {
		int i = 1;
		while (i <= 50) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
				
			}
			i++;
		}
	}
	
	public static void main(String args[]) {
		Even obj1 = new Even();
		obj1.printEven();
	}
}