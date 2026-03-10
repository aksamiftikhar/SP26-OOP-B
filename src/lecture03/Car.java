package lecture03;

public class Car
{
	private int model;
	private String make;
	
	public Car()
	{
		model = 2025;
		make = "Unknown";
	}
	public Car(int md, String mk)
	{
		setModel(md);
		make = mk;
	}
	
	public Car(int md)
	{
		setModel(md);
	}
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
