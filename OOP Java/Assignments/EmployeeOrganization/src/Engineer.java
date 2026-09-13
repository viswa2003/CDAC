
public class Engineer extends Employee{

	int overTime;
	
	public Engineer(String name, String address, int age, char gender, int basicSalary, int overTime)  {
		super(name, address, age, gender, basicSalary);
		this.overTime = overTime;
	}
	
	public int getOvertime() {
		return this.overTime;
	}
	
	public void setOvertime(int overTime) {
		this.overTime= overTime;
	}
	
	
	public static Engineer addEngineer() {
		
		System.out.println("Enter name : ");
		String name = ConsoleInput.getString();
		
		System.out.println("Enter address : ");
		String address = ConsoleInput.getString();
		
		System.out.println("Enter age: ");
		int age = ConsoleInput.getInt();
		
		System.out.println("Enter Gender ( M / F / T ): ");
		char gender = ConsoleInput.getString().charAt(0);
		
		System.out.println("Enter basic salary : ");
		int basicSalary = ConsoleInput.getInt();
		
		System.out.println("Enter overtime : ");
		int overTime = ConsoleInput.getInt();
		
		Engineer engineer = new Engineer(name, address, age, gender, basicSalary, overTime);
		
		return engineer;
		
	}

	@Override
	public void display() {
		System.out.println(name + " " + address + " " + age + " " + gender + " " + basicSalary + " " + overTime);
	}

	
	public static Engineer[] engineerSort(Engineer[] arr, int count) {
			
			for(int iTmp = 0; iTmp < count - 1; iTmp++) {
				for(int iTmp2 = 0; iTmp2 < count - 1 - iTmp; iTmp2++) {
					if(arr[iTmp2].name.compareTo(arr[iTmp2 + 1].name) > 0 ) {
						Engineer temp = arr[iTmp2];
						arr[iTmp2] = arr[iTmp2 + 1];
						arr[iTmp2 + 1] = temp;
					}
				}
			}		
			return arr;
		}

	
}
