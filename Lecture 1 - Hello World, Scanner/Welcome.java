import java.util.Scanner;


public class Welcome
{
	public static void main(String[] args)
	{
		Scanner input;
		input = new Scanner(System.in);
		
		System.out.println("Enter x (int): ");
		int x = input.nextInt();
		System.out.println("Enter y (float): ");
		float y = input.nextFloat();
		
		System.out.print("y/x is ");
		System.out.println(y/x);
		
		// System.out.println("Welcome to Java");
		// System.out.print(args[0]);
		// System.out.print(args[1]);
		
	}
}