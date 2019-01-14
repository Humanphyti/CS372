
public class School extends Building{

	School(String name, String address){
		this.name = name;
		this.address = address;
		currentOccupants = null;
		names = null;
	}
	
	public void peopleArrive(Person t, Person k) {
		if (t instanceof Teacher) {
			currentOccupants.add(t);
			String n = t.getName();
			names.add(n);
		}
		else
			currentOccupants.add(k);
	}
}
