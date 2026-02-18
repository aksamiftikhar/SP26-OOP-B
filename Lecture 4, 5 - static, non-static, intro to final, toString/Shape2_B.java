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
		String color = "pink";
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
		String s = "Hello";
		
		String s2 = s + "World";
		
		System.out.println(s2 + " Bye " + (12 + 3));
		/*
		//Math.PI = 3.24;
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
		Rectangle r = new Rectangle();
		//System.out.println(Rectangle.totalRect);
		//System.out.println(r.totalRect);
		System.out.println(Rectangle.getTotalRect());
		//System.out.println(Rectangle.getWidth());

		//System.out.println(Rectangle.totalRect);

		//System.out.println(Rectangle.width);
		System.out.println(r.width);
		System.out.println(Math.cos(90));
		
		System.out.println(r);
		
	}
	
}

class Rectangle
{
	public int width;
	public int height;
	
	private static int totalRect=10;
	
	public static int getTotalRect()
	{
		// width = 100;
		//int w = getWidth();
		return totalRect;
	}		
	public String toString()
	{
		return "Rectangle (" + width + ", " + height + ")";
	}
	
	public Rectangle()
	{
		width = 5;
		height = 5;
	}
	
	public int getWidth()
	{
		totalRect = 200;
		return width;
	}
	
}