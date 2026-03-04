public class Car
{
	private int model;
	private int[] yearWisePrice;
	
	public static void main(String[] args)
	{
		int x = 'a';
		char c = 97;
		double y = 4;
		
		int[] arr = {1, 2, 3};
		for(int i = 0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		for(int t : arr)
		{
			t = t * 2;
			System.out.println(t);
		}
		for(int i = 0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		// arr[arr[arr.length - 1] - 1 ] = 5;
		//int b, c;

		System.out.println(arr.length);
		
		Car[] cArr = new Car[3];
		cArr[0] = new Car();
		cArr[1] = new Car(2025);
		cArr[2] = new Car(2026);
		
		Car[] cArr2 = {new Car(), new Car(2025)};
		System.out.println(cArr2.length);
	}
	public Car()
	{
		this.yearWisePrice = new int[3];
		this.model = 2001;
	}
	public void setYearWisePrice(int[] arr)
	{
		yearWisePrice = arr;
	}
	
	public int[] getYearWisePrice()
	{
		return yearWisePrice;
	}

	public Car(int model)
	{
		this.model = model;
	}
	
	public int getModel()
	{
		return model;
	}

	
	
	public void setModel(int m)
	{
		if(m>=1980 && m<=2026)
			model = m;
		
	}
	
	
}