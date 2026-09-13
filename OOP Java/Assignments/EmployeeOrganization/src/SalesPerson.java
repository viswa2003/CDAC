
public class SalesPerson extends Employee{

	int commission;
	
	public SalesPerson(String name, String address, int age, char gender, int basicSalary, int commission) {
		super(name, address, age, gender, basicSalary);
		this.commission = commission;
	}
	
	public int getCommission() {
		return this.commission;
	}
	
	public void setCommission(int commission) {
		this.commission = commission;
	}

	
	public static SalesPerson addSalesPerson() {
		
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
		
		System.out.println("Enter commission : ");
		int commission = ConsoleInput.getInt();
		
		SalesPerson sales = new SalesPerson(name, address, age, gender, basicSalary, commission);
		
		return sales;
		
	}
	
	@Override
	public void display() {
		System.out.println(name + " " + address + " " + age + " " + gender + " " + basicSalary + " " + commission);
	}
	
	
	public static SalesPerson[] salesSort(SalesPerson[] arr, int count) {
			
			for(int iTmp = 0; iTmp < count - 1; iTmp++) {
				for(int iTmp2 = 0; iTmp2 < count - 1 - iTmp; iTmp2++) {
					if(arr[iTmp2].name.compareTo(arr[iTmp2 + 1].name) > 0 ) {
						SalesPerson temp = arr[iTmp2];
						arr[iTmp2] = arr[iTmp2 + 1];
						arr[iTmp2 + 1] = temp;
					}
				}
			}		
			return arr;
		}

	
	
}


