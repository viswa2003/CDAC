
public class Program {

	public static void main(String[] args) {
		
//	1 - Student
		Student s1 = new Student();
		
		s1.setRoll_no(2);
		s1.setName("John");
		s1.setPhone_no("7896584523");
		s1.setAddress("64C- WallsStreat");
		
		Student s2 = new Student();
		s2.setRoll_no(4);
		s2.setName("Sam");
		s2.setPhone_no("8978456523");
		s2.setAddress("68D- WallsStreat");
		
		s1.display();
		s2.display();
		

//	2 -Triangle
		Triangle t1 = new Triangle(3, 4, 5);
		System.out.println("\nArea : " + t1.calculateArea());
		
		
//  3 - Rectangle
		Rectangle r1 = new Rectangle(4,5);
		Rectangle r2 = new Rectangle(5, 8);
		
		System.out.println("\nArea of rectangle A : " + r1.area());
		System.out.println("Area of rectangle B : " + r2.area());
		
//	4 - Complex
		Complex c1 = new Complex(5, 6);
		Complex c2 = new Complex(1, 9);
		
		
		c1.add(c2);
		System.out.println("\nSum : " + c1.real + "+" + c1.image + "i");

		
		c1.subtract(c2);
		System.out.println("Difference : " + c1.real + "+" + c1.image + "i");
		

		c1.multiply(c2);
		System.out.println("Product : " + c1.real + "+" + c1.image + "i");
		
		
//	5 - Employee
		Employee e1 = new Employee("Robert", 1994, 5000, "64C- WallsStreat");
		Employee e2 = new Employee("Sam", 2000, 7000, " 68D- WallsStreat");
		Employee e3 = new Employee("John", 1999, 4000, "26B- WallsStreat");
		
		System.out.println("Name\t Year of Joining\t Address");
		e1.display();
		e2.display();
		e3.display();

//	6 - Employee
		e1.setSalary(600);
		e1.setHours(8);
		e1.getInfo();
		e1.addSal();
		e1.getInfo();

		e2.setSalary(400);
		e2.setHours(4);
		e2.getInfo();
		e2.addSal();
		e2.addWork();
		e2.getInfo();
	
	}
	
	
	
}
