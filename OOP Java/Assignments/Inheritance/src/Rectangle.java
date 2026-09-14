
public class Rectangle {

	public int length;
	public int breadth;
	
	public Rectangle(int length, int breadth) {
		this.length = length;
		this.breadth = breadth;
	}
	
	public void printArea() {
		System.out.println("Area : " + length * breadth);
	}
	
	public void printPerimeter() {
		System.out.println("Perimeter : " + 2 * (length + breadth));		
	}
	
}
