
public abstract class Employee {
	protected String name;
	protected String address;
	protected int age;
	protected char gender;
	protected int basicSalary;
	
	public Employee(String name, String address, int age, char gender, int basicSalary) {
		this.name = name;
		this.address = address;
		this.age = age;
		this.gender = gender;
		this.basicSalary = basicSalary;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public String setName(String name) {
		if(name == null) 
			return "No name";
		else 
			return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String setAddress(String address) {
		if(address == null)
			return "No address";
		else
			return this.address;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int setAge(int age) {
		if(age < 18 || age > 65)
			return 18;
		else
			return this.age;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public char setGender(char gender) {
		if(gender != 'M' || gender != 'F' || gender != 'T')
			return 'M';
		else
			return this.gender;
	}
	
	public int getSalary() {
		return this.basicSalary;
	}
	
	public int setSalary(int basicSalary) {
		if(basicSalary < 10000)
			return 10000;
		else
			return this.basicSalary;
	}
	
	public void display() {
		System.out.println(name + " " + address + " " + age + " " + gender + " " + basicSalary + " ");
	}
	
	public static Employee[] employeeSort(Employee[] arr, int count) {
		
		for(int iTmp = 0; iTmp < count - 1; iTmp++) {
			for(int iTmp2 = 0; iTmp2 < count - 1 - iTmp; iTmp2++) {
				if(arr[iTmp2].name.compareTo(arr[iTmp2 + 1].name) > 0 ) {
					Employee temp = arr[iTmp2];
					arr[iTmp2] = arr[iTmp2 + 1];
					arr[iTmp2 + 1] = temp;
				}
			}
		}		
		return arr;
	}
	
}
