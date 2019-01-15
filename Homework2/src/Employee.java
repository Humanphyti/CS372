
public interface Employee {
	//PT -- ID shouldn't be a member of the interface. It should be implemented in Police, Teacher. -1
	int ID = 0;
	//PT -- these functions don't need to take a parameter. -2
	int getID(Employee emp);
	
	boolean getMoney(Employee emp);
}
