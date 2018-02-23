

public class customer {
	private int ID;
	private String lastName;
	private String firstName;
	private String address;
	private int phoneNumber;
	
	void customer()
	{
		ID=0;
		lastName="";
		firstName="";
		phoneNumber=0;	
	}
	
	void customer(int a, String b, String c, int e)
	
	{
		ID=a;
		lastName=b;
		firstName=c;
		phoneNumber=e;	
	}
	
	public int getID()
	{
		return ID;
	}
	
	
	public String getLastName()
	{
		return lastName;
	}
	
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public int getPhone()
	{
		return phoneNumber;
	}
	
	
	

}
