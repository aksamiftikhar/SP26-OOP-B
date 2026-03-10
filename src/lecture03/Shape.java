package lecture03;

import java.util.Scanner;

public class Shape
{
	int x;
	int y;
	String color;
	int size;
	
	public Shape()
	{
		x = 1;
		y = 1;
		color = "red";
	}
	public Shape(int X, int Y, String c, int sz)
	{
		x = X;
		y = Y;
		color = c;
		size = sz;
	}
	
	public String getColor()
	{
		return color;
	}

	public void setColor(String c)
	{
		if(color=="red" || color=="blue")
			color = c;
	}
	public static void main(String[] args)
	{
		Shape s = new Shape();
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		int y = input.nextInt();
		Shape s2 = new Shape(x, y, "blue", 10);
		// int x; 
		// System.out.println(x); // error
		s.setColor("Ali");
		System.out.println(s2.getColor());
		//s.color = "Ali";
		//s.size = -1; // logical error
	}
}
