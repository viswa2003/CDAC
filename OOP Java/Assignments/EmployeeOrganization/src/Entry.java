
public class Entry {
	public static void main(String[] args) {
		
		Employee[] empArr = new Employee[50];
		
		int choice1;
		int choice2;
		int empCount = 0;
		int displayIndex = 0;
			
		System.out.println("Employee Organization");

		
//		Main Menu
//		=========
		do {
			System.out.println("MENU");
			System.out.println("===================");
			System.out.println("1. Add an Employee \n2. Display \n3. Sort \n4. Save to File \n5. Load from File \n6. Exit");
			System.out.println("Choose an option :");
			
			choice1 = ConsoleInput.getInt();
			
			switch(choice1) {
			
			case 1 :  
			{
				
//			Add Employee Menu
//			=================
				do {	
					System.out.println("Select which employee to add : \n1. Manager \n2. Engineer \n3. Sales Person \n4. Exit to main");
					System.out.println("Choose an option :");
					choice2 = ConsoleInput.getInt();
				
					switch(choice2) {
					
//					Add Manager
//					===========
					case 1 : {
						Employee manager = Manager.addManager();
						empArr[empCount] = manager;
						empCount++;
						break;
					}
					
//					Add Engineer
//					===========
					case 2 : {
						Employee engineer = Engineer.addEngineer();
						empArr[empCount] = engineer;
						empCount++;
						break;
					}
					
//					Add Sales Person
//					================
					case 3 : {
						Employee salesPerson = SalesPerson.addSalesPerson();
						empArr[empCount] = salesPerson;
						empCount++;
						break;
					}
					
//					Exit to main
//					============
					case 4 : 
						System.out.println("Returning to main menu...");
						break;
					
					default : System.out.println("Enter valid option (1, 2, 3, 4) !!!");	
					}	
					
				} while(choice2 != 4);
				break;
			}
				
//			Display Menu
//			============
			case 2 :{
				do {
					System.out.println("1. All Employees \n2. First Employee\n3. Next Employee\n4. Previous Employee\n5. Last Employee\n6. Exit to main menu");
					System.out.println("Choose an option :");
					choice2 = ConsoleInput.getInt();
				
					switch(choice2) {

//					Display All employees
//					=====================
					case 1 : {
						if(empCount == 0) {
							System.out.println("Empty...\n");
							break;
						}
						else {
							for(int iTmp = 0; iTmp < empCount; iTmp++) 
								empArr[iTmp].display();
								break;
						}
					}
//					Display first employee
//					=====================
					case 2 : {
						if(empCount == 0) {
							System.out.println("Empty...\n");
							break;
						}
						empArr[0].display();
						break;
					}
//					Display next employees
//					=====================
					case 3 : {
						if(displayIndex == empCount - 1 || empCount == 0) {
							System.out.println("No more employee....\n");
							break;
						}
						else {
							empArr[displayIndex + 1].display();
							displayIndex++;
							break;							
						}
					}
//					Display previous employees
//					=====================
					case 4 : {
						if(displayIndex == 0) {
							System.out.println("No previous employee...\n");
							break;
						}
						else {
							
							empArr[displayIndex - 1].display();
							displayIndex--;
							break;	
						}
					}
//					Display last employees
//					=====================
					case 5 : 
						if(empCount == 0) {
							System.out.println("Employee is empty...\n");
							break;
						}
						else {
							empArr[empCount - 1].display();
							break;
						}
						
//					Exit
//					=====================
					case 6 :
						System.out.println("Going back to main menu...\n");
						break;
						
					default : 
						System.out.println("Enter valid choice....\n");
					}
						
				} while(choice2 != 6);
				break;
			} //end of case 2
			
			
			case 3 : {
			
//				Sorting Menu
//				============
				do {
					System.out.println("1. All Managers \n2. All Engineers \n3. All Sales Person \n4. All Employees in ascendidng order \n5. All employees in descending order \n6. Exit to main menu \n");
					System.out.println("Choose an option :");
					choice2 = ConsoleInput.getInt();
				
					switch(choice2) {
					
//					All Managers
//					============
					case 1 : {
						Manager[] managerArr = new Manager[empCount];
						int managerArrIndex = 0;
						
						for(int iTmp = 0; iTmp < empCount; iTmp++) {
							if(empArr[iTmp] instanceof Manager) {
								managerArr[managerArrIndex] = (Manager)empArr[iTmp];
								managerArrIndex++;
							}
						}
						Manager.managerSort(managerArr, managerArrIndex - 1);
						for(int iTmp = 0; iTmp < managerArrIndex; iTmp++) {
							managerArr[iTmp].display();
						}
						break;
					}//end of case 1
					 //end of switch
					
//					All Engineers
//					============
					case 2 : {
						Engineer[] engineerArr = new Engineer[empCount];
						int engineerArrIndex = 0;
						
						for(int iTmp = 0; iTmp < empCount; iTmp++) {
							if(empArr[iTmp] instanceof Engineer) {
								engineerArr[engineerArrIndex] = (Engineer)empArr[iTmp];
								engineerArrIndex++;
							}
						}
						Engineer.engineerSort(engineerArr, engineerArrIndex - 1);
						for(int iTmp = 0; iTmp < engineerArrIndex; iTmp++) {
							engineerArr[iTmp].display();
						}
						break;
					}//end of case 2
					
//					All Sales Person
//					============
					case 3 : {
						SalesPerson[] salesArr = new SalesPerson[empCount];
						int salesArrIndex = 0;
						
						for(int iTmp = 0; iTmp < empCount; iTmp++) {
							if(empArr[iTmp] instanceof SalesPerson) {
								salesArr[salesArrIndex] = (SalesPerson)empArr[iTmp];
								salesArrIndex++;
							}
						}
						SalesPerson.salesSort(salesArr, salesArrIndex - 1);
						for(int iTmp = 0; iTmp < salesArrIndex; iTmp++) {
							salesArr[iTmp].display();
						}
						break;
					}//end of case 3
					
//					All Employees ascending
//					============
					case 4 : {
						Employee.employeeSort(empArr, empCount);
						for(int iTmp = 0; iTmp < empCount; iTmp++) {
							empArr[iTmp].display();
						}
						break;
					} // end of case 4
					
//					All Employees descending
//					============
					case 5 : {
						Employee.employeeSort(empArr, empCount);
						for(int iTmp = empCount - 1; iTmp >= 0; iTmp--) {
							empArr[iTmp].display();
						}
						break;
					} // end of case 5
					
					case 6 : {
						System.out.println("Exiting to main menu...");
						break;
					}
					
					default : System.out.println("Enter valid option...");
					
					
					} //end of sort menu switch
				} while (choice2 != 6);
				break;
				
			} // end of case 3 sorting
			
			case 4 :
				System.out.println("Not yet implemented!!!");
				break;
				
			case 5 :
				System.out.println("Not yet implemented!!!");
				break;
				
			case 6 :
				System.out.println("Exiting..");
				break;
				
			} //end of main menu switch					
			
		}while(choice1 != 6);
		
	}
}
