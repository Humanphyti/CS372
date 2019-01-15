//PT -- missing javadoc. -2
public class Police extends Person implements Employee {
	public enum policeRole{Patrol, Seargent, Captain, Chief};
	private policeRole role;

	public Police(int age, int phoneNumber, String name, policeRole role) {
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.role = role;	
	}
	
	@Override
	public int getID(Employee emp) {
		return Employee.ID;
	}

	@Override
	public boolean getMoney(Employee emp) {
		//PT -- ??? Why return a bool?
		return true;
	}
}
