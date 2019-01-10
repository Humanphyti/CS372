public class City {
	public static void main(String[] args) {
		Building buildings[] = {new CityHall(), new School()};
		Person people[] = {new Police(25,1234567,"George", Police.policeRole.Captain), new Teacher(42,7456321,"Jane", "Washington", "third Grade"), new Kid(5,3216547, "Bobby", "gummy sharks")};
		
		for (Person p: people )
			System.out.printf("%s\n", p.getName());
		for (Building b: buildings)
			System.out.printf("%s\n", b.getName());
			
        if (buildings[0] instanceof CityHall){
            for (int i = 0; i < buildings[0].getLength(); i++){
                if (buildings[0].isPolice(i) == true){
                    System.out.print(people[i]);
                    if (buildings[0].isEmployee(i))
                        System.out.printf("This is an employee and has been paid");
                }
            }
        }
        else if(buildings[1] instanceof School){
            for (int j = 0; j < buildings[1].getLength(); j++){
                if (buildings[1].isTeacher(j) == true){
                    System.out.print(people[j]);
                    if (buildings[0].isEmployee(j))
                        System.out.printf("This is an employee and has been paid");
                }
                else if (buildings[1].isKid(j))
                    System.out.print(people[j]);
            }
        }
        //for (int i = 0; i < people.length;
		
	}
}