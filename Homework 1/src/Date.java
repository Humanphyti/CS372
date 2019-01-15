import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;

public class Date {
	private int day;
	private int month;
	private int year;
	
	//PT -- Functionality missing, e.g. get today's date, diff. -5
	
	public void setDay(int userDay) {
		//PT -- Need to validate these inputs. -2
		day = userDay;
	}
	
	public void setMonth(int userMonth) {
		month = userMonth;
	}
	
	public void setYear(int userYear) {
		year = userYear;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void print() {
		System.out.printf("%d/%d/%d", day, month, year);
	}
	
	public boolean leapYear() {
		
		return false;
	}
	
	public 
}
