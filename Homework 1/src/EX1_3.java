import java.util.Scanner;

public class EX1_3 {
	public static void main(String[] args) {
		String input;
		System.out.printf("Please enter a number: ");
		Scanner scnr = new Scanner(System.in);
		input = scnr.next();
		char[] inputC = input.toCharArray();
		int x = 0;
		int y = 0;
		int z = 0;
		int integer = 0;
		int length;
		//PT -- if (input[0] < '0' || inputC[0] > '9')
		if (inputC[0] < 48 || inputC[0] > 57) {
			//PT -- again, give the user another chance. -2
			System.out.printf("You did not give me a number", args);
		} 
		else {
			while (x < input.length()) {
				if (inputC[x] < 48 || inputC[x] > 57)
					break;
				else {
					y*=10;
					y+=(inputC[x++] - '0');
				}
			}
			System.out.printf("This is your int: %d", y);
			
		}
	}
}
