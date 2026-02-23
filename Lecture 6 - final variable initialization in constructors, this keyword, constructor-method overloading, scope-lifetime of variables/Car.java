public class Car
{
	private final int numTyres;
	private int model=2001;
	private String make;
	private static int x;
	
	/*
	{
		model = 2000;
	}
	
	static
	{
		x = 123;
	}
	*/
	
	public static void main(String[] args)
	{

		// Car c2 = new Car(2025);
		// Car c3 = new Car(2001, "city", 5);
		// System.out.println(c3.numTyres);
		// String s = "Hello";
		// String s2 = "World";
		// String s3 = s + " " + s2 + 123;
		// System.out.println(s3);
		// //System.out.println(c2.model + " " + c2.make);
		
		// String msg = String.format("%s %s", c2.model, c2.make);
		// // msg = c2.model + " " + c2.make;
		// System.out.println(msg);

		// // System.out.println(c2.model + " " + c2.make);
		// // System.out.printf("%s %s", c2.model, c2.make);

	}
	
	// public Car()
	// {
	// 	this(2025, "Unknown", 4);
	// }
	// public Car(int md)
	// {
	// 	this(md, "Unknown", 4);
	// }
	// public Car(int md, String mk, int tyres)
	// {
	// 	numTyres = tyres;
	// 	setModel(md);
	// 	make = mk;
	// }
	
	
	public int getModel()
	{
		return model;
	}

	public String getMake()
	{
		return make;
	}
	
	public void setModel(int m)
	{
		if(m>=1980 && m<=2026)
			model = m;
		
	}
	
	
}