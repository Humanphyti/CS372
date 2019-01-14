
public class Police extends Person implements Employee {
	public enum policeRole{Patrol, Seargent, Captain, Chief};
	private policeRole role;

	public Police(int age, String phoneNumber, String name, policeRole role) {
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.role = role;	
	}
	
	public policeRole getRole() {
		return this.role;
	}
	
	@Override
	public int getID(Employee emp) {
		return Employee.ID;
	}

	@Override
	public boolean getMoney(Employee emp) {
		return true;
	}
}
