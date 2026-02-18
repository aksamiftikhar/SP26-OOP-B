import java.util.Scanner;

public class Shape2
{
	String color;
	int size;
	
	private static int area=100;

	public String getColor()
	{
		return color;
	}
	public static int getArea()
	{
		//String color = "pink";
		//setColor("pink");
		return area;
	}
	public void setColor(String c)
	{
		if(color=="red" || color=="blue")
			color = c;
	}
	
	public int getSize()
	{
		return size;
	}
	public static void main(String[] args)
	{
		
		//System.out.println(Shape2.area);
		System.out.println(Shape2.getArea());
		Shape2 s = new Shape2();
		s.size = 100;
		Shape2 s2 = new Shape2();
		s2.size = 200;
		System.out.println(s.size);
		System.out.println(s2.size);
		System.out.println();
		
		Shape2 s3 = s;
		s3.size = 500;
		System.out.println(s.size);
		System.out.println(s2.size);
		System.out.println(s3.size);
		
		System.out.println(Math.cos(90));
		
		/*
		//System.out.println(s.getColor());
		System.out.println(s.getSize());
		
		int size = 20;
		System.out.println(size);*/
	}
}