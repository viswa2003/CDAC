
public class Calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Enter day : ");
		int day = ConsoleInput.getInt();

		System.out.println("Enter Month : ");
		int month = ConsoleInput.getInt();
		
		System.out.println("Enter year : ");
		int year = ConsoleInput.getInt();
		
		
		Date obj = new Date();
		obj.setDate(day, month, year);
		
		int choice;
		
		do {
			System.out.println("Menu");
			System.out.println("Choose an operation : ");
			System.out.println("1. Add days \n2. Add months \n3.Add years \n4. Display \n5. Compare Dates \n6. Exit");
			choice = ConsoleInput.getInt();
			
			switch(choice) {
			case 1:	
				System.out.println("Enter number of days to add : ");
				int days = ConsoleInput.getInt();
				obj.addDays(days);
				System.out.println("The date is : " + obj.getDay() + "/" + obj.getMonth() + "/" + obj.getYear() + "\n\n");
				break;
				
			case 2:	
				System.out.println("Enter number of months to add : ");
				int months = ConsoleInput.getInt();
				obj.addMonths(months);
				System.out.println("The date is : " + obj.getDay() + "/" + obj.getMonth() + "/" + obj.getYear() + "\n\n");
				break;
			
			case 3:	
				System.out.println("Enter number of years to add : ");
				int years= ConsoleInput.getInt();
				obj.addYear(years);
				System.out.println("The date is : " + obj.getDay() + "/" + obj.getMonth() + "/" + obj.getYear() + "\n\n");
				break;

			case 4:	
				obj.display();
				break;
				
			case 5: 
				System.out.println("Not implemented");
				break;
				
			default:
				System.out.println("Exiting.....");
			}
				
			
		}while(choice != 6);
		
		
		
	}

}
