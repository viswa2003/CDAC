
public class Triangle {

	public int side1;
	public int side2;
	public int side3;
	
	public Triangle(int a, int b, int c) 
	{
		side1 = a;
		side2 = b;
		side3 = c;
	}
	
	public double calculateArea() {
		double s = side1 + side2 + side3;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}


	
	
}
