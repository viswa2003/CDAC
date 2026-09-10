
public class Date {
	private int day;
	private int month;
	private int year;
	
	boolean isLeapYear(int year) {
		if(year % 400 == 0) {
			return true;
		}
		else if (year % 100 != 0 && year % 4 == 0) {
			return true;
		}
		else
			return false;
	}
	
	
	public void setDate(int day, int month, int year) {

//		Set month validation
		if(month < 1 || month > 12) {
			this.month = 1;
		}
		else
			this.month = month;
		
//		set Day validation
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			if(day < 1 || day> 31) {
				this.day = 1;
			}
			else
				this.day= day; 
		}
		else if( month == 4 || month == 6 || month == 9 || month == 11) {
			if(day < 1 || day> 30) {
				this.day = 1;
			}
			else
				this.day= day; 
		}
		else {
			if(isLeapYear(year)) {
				if(day < 1 || day > 29) {
					this.day = 1;
				}
				else {
					this.day = day;
				}
					
			}
			else if(day < 1 || day > 28) {
				this.day = 1;
			}
			else 
				this.day = day;			
		}
		
//		set Year validation
		if(year < 1) {
			this.year = 2026;
		}
		else {
			this.year = year;
		}
	}
	
	public int getDay() {
		return this.day;
	}
	public int getMonth() {
		return this.month;
	}
	public int getYear() {
		return this.year;
	}
	
	
//	Add days
	public void addDays(int addDays) {
		for(int iTmp = 1; iTmp <= addDays; iTmp++) {
			
			day++;
			
			int monthEnd;
			
			if(month == 2) {
				if(isLeapYear(year)) {
					monthEnd = 29;
				}
				else {
					monthEnd = 28;
				}
			}
			
			else if(month == 4 || month == 6 || month == 9|| month == 11) {
				monthEnd = 30;
			}
			
			else {
				monthEnd = 31;
			}
			
			if(day > monthEnd) {
				day = 1;
				month++;
			}
			
			if(month > 12) {
				month =1;
				year++;
			}
		}
	}
	
	
	void addMonths(int addMonth) {
		
		for(int iTmp = 1; iTmp <= addMonth; iTmp++) {
			this.month++;
			int monthEnd;
			
			if(month > 12) {
				month = 1;
				year++;
			}
			
			if(month == 2) {
				if(isLeapYear(year)) {
					monthEnd = 29;
				}else {
					monthEnd = 28;
				}
			}
			
			else if(month == 4 || month == 6 || month == 9 || month == 11) {
				monthEnd = 30;
			}
			else {
				monthEnd = 31;
			}
			
			if(day > monthEnd) {
				day = monthEnd;
			}
			
		}
	}
	
	
	public void addYear(int addYears) {
		this.year += addYears;
	}
	
	public void display() {
		System.out.println("The date is : " + getDay() + "/" + getMonth() + "/" + getYear() + "\n\n");
	}
}




