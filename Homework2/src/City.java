
public class City {
	public static void main(String[] args) {
		Building buildings[] = {new CityHall(), new School()};
		Person people[] = {new Police(25,1234567,"George"), new Teacher(42,7456321,"Jane"), new Kid(5,3216547, "Bobby")};
		
		for (Person p: people )
			System.out.printf("%s\n", p.getName());
		for (Building b: buildings)
			System.out.printf("%s\n", b.getName());
			
        if (buildings[0] instanceof CityHall){
            for (int i = 0; i < buildings[0].getLength()){
                if (buildings[0].isPolice(i) == true){
                    system.out.printf(people[i])
                    if (buildings[0].isEmployee(i))
                        system.out.printf("This is an employee and has been paid");
                }
            }
        }
        else if(buildings[1] instanceof School){
            for (int j = 0; j < buildings[1].getLength()){
                if (buildings[1].isTeacher(i) == true){
                    system.out.printf(people[i]);
                    if (buildings[0].isEmployee(i))
                        system.out.printf("This is an employee and has been paid");
                }
                else if (buildings[1].isKid.getLength())
                    system.out.printf(people[i]);
            }
        }
        for (int i = 0; i < people.length();
		
	}
}
