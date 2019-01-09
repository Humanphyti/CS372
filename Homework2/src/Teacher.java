
public class Teacher extends Person implements Employee{
	private String teachCert;
	private String teachGradelevel;
	
	public Teacher(int age, int phoneNumber, String name, String teachCert, String teachGradeLevel) {
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.teachCert = teachCert;
		this.teachGradelevel = teachGradeLevel;		
	}
	
	@Override
	public int getID(Employee emp) {
		// TODO Auto-generated method stub
		return Employee.ID;
	}
	@Override
	public boolean getMoney(Employee emp) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
