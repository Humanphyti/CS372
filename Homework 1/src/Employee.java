import java.util.Scanner;

public class Employee {
	void Employee() {
		
	}
	private String name;
	private String date;
	private String position;
	private String boss;
	private int ID;
	
	public void setID(int employeeID) {
			ID = employeeID;
	}
	
	//PT -- need get functions so this class is usable. -3
	
	public void setName(String employeeName) {
		name = employeeName;
	}
	
	public void setHireDate(String employeeDate) {
		date = employeeDate;
	}
	
	public void setPosition(String employeePosition) {
		position = employeePosition;
	}
	
	public void setBoss(String employeeBoss) {
		boss = employeeBoss;
	}
	
	public void print() {
		System.out.println("Name: " + name + "\n" + "ID: " + ID + "\n" + "Position: " + position + "\n" + "Boss: " + boss + "\n" + "Hire Date: " + date);
	}
	
}
