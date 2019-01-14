import java.util.ArrayList;

public abstract class Building {
	String name = "";
	String address = "";
	public ArrayList<Person> currentOccupants = new ArrayList<Person>();
	public static ArrayList<String> names = new ArrayList<String>();
	
	public Building(){
		name  = "Name";
		address = "";
		currentOccupants = null;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getName() {
		return name;
	}
    
    public int getLength(){
        return currentOccupants.size();
    }
    
    public boolean isPolice(int i){
        if (currentOccupants.get(i) instanceof Police)
            return true;
        else
            return false;
    }
    public boolean isTeacher(int i){
        if (currentOccupants.get(i) instanceof Teacher)
            return true;
        else
            return false;
    }
    
    public boolean isKid(int i){
        if (currentOccupants.get(i) instanceof Kid)
            return true;
        else
            return false;
    }

    public boolean isEmployee(int i){
        if (currentOccupants.get(i) instanceof Employee)
            return true;
        else
            return false;
    }
}