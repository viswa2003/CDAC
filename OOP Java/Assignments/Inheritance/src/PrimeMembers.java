
public class PrimeMembers extends Member{

	int joiningYear;
	int joiningFees;
	boolean isActive = true;
	
	
	
	public int getJoiningYear() {
		return joiningYear;
	}



	public void setJoiningYear(int joiningYear) {
		this.joiningYear = joiningYear;
	}



	public int getJoiningFees() {
		return joiningFees;
	}



	public void setJoiningFees(int joiningFees) {
		this.joiningFees = joiningFees;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public void display() {
		System.out.println(name + " " + age + " " + phone + " " + address + " " + salary + " " + joiningYear + " " + joiningFees + " " + isActive);
	}
}
