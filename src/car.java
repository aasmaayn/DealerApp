
	public class car {
		private int ID;
		private String make;
		private String model;
		private int years;
		private String Fuel;
		private int mileage;
		private String color;
		private String driveTrain; 
		private String transmission;
		private double price;
		private boolean sold;
		
		public car ()
		{
			ID=0;
			make="";
			model="";
			years=0;
			Fuel="";
			color="";
			driveTrain="";
			transmission="";
			mileage=0;
			price=0;
			sold=false;
			
		}
		
		public car (int a ,String b,String c,int d,String e, String f,String g, String h,int i, double j, boolean k)
		{
			ID=a;
			make=b;
			model=c;
			years=d;
			Fuel=e;
			color=f;
			driveTrain=g;
			transmission=h;
			mileage=i;
			price=j;
			sold=k;
			
		}
		
		public int getID()
		{
			return ID;
		}
		
		
		public String getMake()
		{
			return make;
		}
		
		public String getColor()
		{
			return color;
		}
		public int getMileage()
		{
			return mileage;
		}
		public String getModel()
		{
			return model;
		}
		public int getyear()
		{
			return years;
		}
		
		public String getDriveTrain()
		{
			return driveTrain;
		}
		

		public String getTransmission()
		{
			return transmission;
		}
		
		public double getPrice()
		{
			return price;
		}
		
		public String getFuel()
		{
			return Fuel;
		}
		
		public boolean getSold()
		{
			return sold;
		}
	}





