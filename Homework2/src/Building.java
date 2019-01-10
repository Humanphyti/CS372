public abstract class Building {
	String name = "";
	String address = "";
	Person currentOccupants[] = {};
	
	public Building(){
		name  = "Name";
		address = "";
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
        return currentOccupants.length;
    }
    
    public boolean isPolice(int i){
        if (currentOccupants[i] instanceof Police)
            return true;
        else
            return false;
    }
    public boolean isTeacher(int i){
        if (currentOccupants[i] instanceof Teacher)
            return true;
        else
            return false;
    }
    
    public boolean isKid(int i){
        if (currentOccupants[i] instanceof Kid)
            return true;
        else
            return false;
    }

    public boolean isEmployee(int i){
        if (currentOccupants[i] instanceof Employee)
            return true;
        else
            return false;
    }
}