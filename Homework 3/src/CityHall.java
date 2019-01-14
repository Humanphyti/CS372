public class CityHall extends Building{
	
	CityHall(String name, String address){
		this.name = name;
		this.address = address;
		currentOccupants = null;
		names = null;
	}
	
	public void peopleArrive(Police p) {
		currentOccupants.add(p);
		String n = p.getName();
		names.add(n);
	}
	
}
