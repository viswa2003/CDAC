
public class Employee {
	
	String name;
	int yearOfJoining;
	int salary;
	String address;
	
	int hoursPerDay;
	
	
	public Employee(String name, int year, int salary, String address) {
		
		this.name = name;
		this.yearOfJoining = year;
		this.salary = salary;
		this.address = address;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYearOfJoining() {
		return yearOfJoining;
	}
	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setHours(int hours) {
		this.hoursPerDay = hours;
	}
	
	public void display() {
		System.out.print(name);
		System.out.print("\t" + yearOfJoining + "\t\t");
		System.out.println(address);
	}
	
	
//	Question 6
	public void getInfo() {
		System.out.println("Salary : " + this.salary + " Hours : " +this.hoursPerDay);
	}
	
	public void addSal() {
		if(this.salary < 500) {
			this.salary += 10;
		}
	}
	
	public void addWork() {
		if(this.hoursPerDay > 6) 
			this.salary += 5;
	}
	
	
}
