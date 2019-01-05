import java.util.Scanner;

public class EX1_2 {
	public static final double PI = 3.14;
	public static void main(String[] args) {
		int input;
		System.out.printf("Please enter a circle's radius: ");
		Scanner scnr = new Scanner(System.in);
		input = scnr.nextInt();
		double area = java.lang.Math.pow(input, 2) * PI;
		System.out.print(area);
	}
}
