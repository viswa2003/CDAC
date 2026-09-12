
public class Complex {
	public int real = 1;
	public int image = 1;
	
	public Complex(int real, int image) {
		this.real = real;
		this.image = image;
	}
	
	public void add(Complex c) {
		this.real += c.real;
		this.image += c.image;
		
	}
	
	public void subtract(Complex c) {
		this.real -= c.real;
		this.image -= c.image;
	}
	
	public void multiply(Complex c) {
		this.real *= c.real;
		this.image *= c.image;
	}
	
	
	
	
	
	
}
