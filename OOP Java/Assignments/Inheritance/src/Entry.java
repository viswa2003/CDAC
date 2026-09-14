
public class Entry {

	public static void main(String[] args) {
		
//		Q1
		
		Parent obj = new Parent();
		obj.display();
		
		Child obj1 = new Child();
		obj1.display();
		
		Parent obj2 = new Child();
		obj2.display();

		
		
//		Q2
		
		System.out.println("Enter name : ");
		String name = ConsoleInput.getString();

		System.out.println("Enter age: ");
		int age = ConsoleInput.getInt();
		
		System.out.println("Enter phone: ");
		String phone = ConsoleInput.getString();
		
		System.out.println("Enter address : ");
		String address = ConsoleInput.getString();
		
		System.out.println("Enter salary: ");
		int salary = ConsoleInput.getInt();
		
		System.out.println("Enter joining year : ");
		int year= ConsoleInput.getInt();
		
		System.out.println("Enter joining fees : ");
		int fees= ConsoleInput.getInt();
		
		System.out.println("Enter is active ( Y / N : ");
		char active = ConsoleInput.getString().charAt(0);
		boolean activeStatus;
		if(active == 'Y')
			activeStatus = true;
		else
			activeStatus = false;
		
		
		PrimeMembers prime = new PrimeMembers();
		prime.setName(name);
		prime.setAge(age);
		prime.setPhone(phone);
		prime.setAddress(address);
		prime.setSalary(salary);
		prime.setJoiningYear(year);
		prime.setJoiningFees(fees);
		prime.setActive(activeStatus);
			
		prime.display();
		
		
//		Q3
		
		Rectangle rect = new Rectangle(10,15);
		rect.printArea();
		rect.printPerimeter();
		
		Square sq = new Square(10);
		sq.printArea();
		sq.printPerimeter();
		
		
//		Q4
		System.out.println();
		
		SquareClass squareObj = new SquareClass();
		
		squareObj.displaySquare();
		squareObj.displayRectangle();
		squareObj.displayShape();
		
	}

}
