
import java.sql.*;
import java.util.LinkedList;

import javax.swing.JOptionPane;
public class CarDB {
	
//C:/Users/aasma/workspace/FinalProject/
	
		//static final String DATABASE_URL="jdbc:ucanaccess://Database11.accdb"; //for access
		static final String DATABASE_URL="jdbc:mysql://localhost/lambo"; //for access
		
		
		
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		PreparedStatement insertNewCar=null;
		PreparedStatement insertCustomer=null;
		public boolean status=false;
		
		
		
		PreparedStatement insertNewOrder=null;
		
		public CarDB(String user, String Pass) {
			
				//ESTABLISH CONNECTION 
				//connection=DriverManager.getConnection(DATABASE_URL);
				//System.out.println("made a connection");
				//create statement for querying database
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		System.out.println("Driver loaded");
	    		// Establish a connection
	    		//Connection connection = DriverManager.getConnection
	    		//("jdbc:mysql://localhost/test");
	    		
	    		//Sample connection if you have a password set on your machine
	    		if(user.equals("") && Pass.equals(""))
	    		{
	    			 try {
	 					connection = DriverManager.getConnection
	 							(DATABASE_URL);
	 					status=true;
	 				} catch (SQLException e) {
	 					// TODO Auto-generated catch block
	 					//JOptionPane.showMessageDialog(null,e.getMessage());
	 					e.printStackTrace();
	 					return;
	 				}
	    		}
	    			
	    		else
	    		{	    			
	    			try {
	    				connection = DriverManager.getConnection
	    						(DATABASE_URL,user, Pass);
	    				status=true;
	    			} catch (SQLException e) {
	    				// TODO Auto-generated catch block
	    				//JOptionPane.showMessageDialog(null,e.getMessage());
	    				e.printStackTrace();
	    				return;
	    			}	    		
	    		}
	    		
	    		
	    		
	    		
				
				
				try {
					statement=connection.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("established statement");
				
				//sample select statement;
				try {
					resultSet =statement.executeQuery("SELECT Make, Model, Years,Fuel,Color,driveTrain, Transmission,Mileage,Price FROM inventory");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
				System.out.println("Have a resultSet");
				
		
		}
		
		
		
		public int addCar(String m,String mod,int y,String f, String c,String d, String t,int ml, double p) throws SQLException
		{
			int result=0;
			try
			{
				insertNewCar = connection.prepareStatement("INSERT INTO "+
							"inventory(Make, Model, Years,Fuel,Color,driveTrain, Transmission,Mileage,Price, Sold)"
							+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)", Statement.RETURN_GENERATED_KEYS);
				insertNewCar.setString(1, m);
				insertNewCar.setString(2, mod);
				insertNewCar.setInt(3, y);
				insertNewCar.setString(4, f);
				insertNewCar.setString(5, c);
				insertNewCar.setString(6, d);
				insertNewCar.setString(7, t);
				insertNewCar.setInt(8, ml);
				insertNewCar.setDouble(9, p);
				insertNewCar.setBoolean(10,false);
							
				result=insertNewCar.executeUpdate();
				JOptionPane.showMessageDialog(null, "The Car has been added to Inventory!");
							
				
			}
			catch(SQLException sqlex)
			{
				
				
				JOptionPane.showMessageDialog(null, sqlex.getMessage(),"DataBase insert",JOptionPane.ERROR_MESSAGE);
				result=0;
			}
			
			return result;
			
		}// end of AddPerson
		
	//========================================================================	
		public LinkedList<car>  getCars() throws SQLException
		{
			
		LinkedList<car> cars= new LinkedList<car>();
		
		
		resultSet=statement.executeQuery("SELECT ID, make, model, years, Fuel, color, driveTrain,"
				+ " transmission, mileage, price, sold FROM Inventory");
		
		while (resultSet.next())
		{
			
			cars.add(new car(resultSet.getInt(1),resultSet.getString(2),
					resultSet.getString(3),resultSet.getInt(4),
					resultSet.getString(5),resultSet.getString(6),
					resultSet.getString(7),resultSet.getString(8),
					resultSet.getInt(9),resultSet.getDouble(10), resultSet.getBoolean(11)));
		   
		}
	
			
			
			return cars;
			
		}
		//////////////////////////////////////////////////////
		
		public void removeCar(int i)throws SQLException
		{
			
			
			statement.executeUpdate
			("delete  from inventory WHERE ID = " + i + ";");
	
			JOptionPane.showMessageDialog(null, "The Car has been removed!");

			
		}
		
		//////////////////////////////////////////////////////
		
		public int sell(int carid,String a, String b, int c)throws SQLException
		{
			
			int result=0;
			
			try
			{
				insertCustomer = connection.prepareStatement("INSERT INTO "+
							"customer( ID,firstName, lastName,Phone)"
							+ " VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
				insertCustomer.setInt(1, carid);
				insertCustomer.setString(2, a);
				insertCustomer.setString(3, b);
				insertCustomer.setInt(4, c);
				
				
				result=insertCustomer.executeUpdate();
				
									
				
			}
			catch(SQLException sqlex)
			{
				
				
				JOptionPane.showMessageDialog(null, sqlex.getMessage(),"DataBase insert",JOptionPane.ERROR_MESSAGE);
				result=0;
			}

			return result;
			
			
			
		}
		
		public int changeSold(int carid)throws SQLException
		{
			
			int count= statement.executeUpdate( "update  inventory set Sold=true where ID= "+carid+";");
			System.out.println("count: "+count);
			return count;
		
		}
					

	}//end of class



