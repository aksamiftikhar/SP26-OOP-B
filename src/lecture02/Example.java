package lecture02;

public class Example
{
	public static void main(String[] args)
	{
		double a, b, c;
		a = 1;
		b=2;
		c=4;
		
		double x = (-b + (b*b-4*a*c))/(2*a);
		
		System.out.print("The root is: ");
		System.out.println(x);
		
		for(int i=0;i<5;i++)
		{
			a+=1;
			x = computeRoot(a, b, c);
			System.out.println(x);
		}
	}
	public static double computeRoot(double a, double b, double c)
	{
		double x = (-b + (b*b-4*a*c))/(2*a);
		return x;
	}
	
}
