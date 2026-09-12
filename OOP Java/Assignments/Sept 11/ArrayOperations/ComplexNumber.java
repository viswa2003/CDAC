
public class ComplexNumber {
	int number1;
	int number2;
	
	
	public ComplexNumber(int num1, int num2) {
		number1 = num1;
		number2 = num2;
	}
	
	public int getNumber1() {
		return number1;
	}
	public void setNumber1(int number1) {
		this.number1 = number1;
	}
	public int getNumber2() {
		return number2;
	}
	public void setNumber2(int number2) {
		this.number2 = number2;
	}
	
	public int computeComplexNumber() {
		return number1 * number2;
	}
	
	
	
}
