import java.util.Random;

public abstract class Person {
	protected int age;
	protected String phoneNumber;
	protected String name;
	private static String LASTNUMBER = "1111111111";
	Random r = new Random();
	
	public Person() {
		age = 0;
		phoneNumber = LASTNUMBER;
		name = "name";
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getName() {
		return name;
	}
}
