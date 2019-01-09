import java.util.Random;

public abstract class Person {
	protected int age;
	protected int phoneNumber;
	protected String name;
	private static int LASTNUMBER = 1111111;
	Random r = new Random();
	
	public Person() {
		age = 0;
		phoneNumber = LASTNUMBER;
		name = "name";
		LASTNUMBER++;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getName() {
		return name;
	}
}
