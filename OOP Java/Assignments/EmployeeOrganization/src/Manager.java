
public class Manager extends Employee {

	int hra;
	
	public Manager(String name, String address, int age, char gender, int basicSalary, int hra) {
		super(name, address, age, gender, basicSalary);
		this.hra = hra;	
	}
	
	public int getHra() {
		return this.hra;
	}
	
	public void setHra(int hra) {
		this.hra = hra;
		
	}
	
	public static Employee addManager() {
		
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
		
		System.out.println("Enter hra : ");
		int hra = ConsoleInput.getInt();
		
		Manager manager = new Manager(name, address, age, gender, basicSalary, hra);
		
		return manager;
		
	}
	
	@Override
	public void display() {
		System.out.println(name + " " + address + " " + age + " " + gender + " " + basicSalary + " " + hra);
	}
	
	
	public static Manager[] managerSort(Manager[] arr, int count) {
		
		for(int iTmp = 0; iTmp < count - 1; iTmp++) {
			for(int iTmp2 = 0; iTmp2 < count - 1 - iTmp; iTmp2++) {
				if(arr[iTmp2].name.compareTo(arr[iTmp2 + 1].name) > 0 ) {
					Manager temp = arr[iTmp2];
					arr[iTmp2] = arr[iTmp2 + 1];
					arr[iTmp2 + 1] = temp;
				}
			}
		}		
		return arr;
	}
	
}
