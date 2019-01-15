import java.util.Scanner;
public class EX1_1 {
	public static void main(String[] args) {
		int input;
		do {
			System.out.printf("Please enter a number between 10 and 100: ");
			Scanner scnr = new Scanner(System.in);
			input = scnr.nextInt();
			if(input < 10 || input > 100)
				//PT -- don't just quit if the user entered an invalid number. Let them try again. -2
				System.out.printf("Incorrect, Please enter a number between 10 and 100\n");
			else {
				for (int i = 0; i <= input; i++) {
					System.out.print(i);
					System.out.printf(" ");
					if (i % 2 != 0)
						System.out.printf("odd\n");
					else
						System.out.printf("even\n");
				}
			}
			scnr.close();
		}while(input < 10 || input > 100);
	}
}
