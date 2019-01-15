import java.util.Scanner;

public class EX1_4 {
	public static void main(String[] args) {
		System.out.printf("Please enter your height in inches: ");
		Scanner scnr = new Scanner(System.in);
		double height = scnr.nextDouble();
		System.out.printf("Please enter your weight in pounds: ");
		scnr = new Scanner(System.in);
		double weight = scnr.nextDouble();
		//PT -- validate the input. -2
		//PT -- name these values: final double INCHES_PER_METER = 39.37;
		double heightm = height / 39.37;
		double weightm = weight / 2.2;
		double BMI = weightm / java.lang.Math.pow(heightm, 2);
		System.out.printf("Your BMI is: " + BMI);
	}
}
