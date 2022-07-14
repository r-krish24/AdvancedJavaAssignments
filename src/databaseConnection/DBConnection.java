package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class DBConnection {
	
	public static void main(String[] args) {
		
		String url = "jdbc:sqlserver://MAVCHN1121638\\SQLEXPRESS;databaseName=testdb;integratedSecurity=true;encrypt=false;";
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Lets play around with Countires table in database.");
		int flag=0;
		while(flag==0)
		{
		try
		{	
			System.out.println("Enter the option\n 1) View \n 2) Update \n 3) Insert \n 4) Delete \n 5) Exit");
			int choice = sc.nextInt();
			switch(choice)
			{
			
			case 1:
			{
				try
				{		
					String query = "select * from Countries";
					try(Connection conn = DriverManager.getConnection(url))
						{
						
						System.out.println("Connection Successfull!");
						System.out.println("-------------------------------------");
						
						Statement stmt = conn.createStatement();
						ResultSet result = stmt.executeQuery(query);
						System.out.println("CountryName ~~ Capital ~~ CurrencyCode");
						System.out.println("-------------------------------------");
						while(result.next())
						{
							System.out.println(result.getString(3)+" ~~ "+result.getString(4)+" ~~ "+result.getString("CurrencyCode"));
						}
						System.out.println("-------------------------------------");
						conn.close();
						}
				
				}
				catch(SQLException e)
				{
				System.out.println("Connection failed!");
				flag=1;
				e.printStackTrace();
				}
				break;
			}
			case 2: 
			{
				System.out.println("Enter the CountryName and the new CurrencyCode to be updated seperated by '~'");
				sc.nextLine();
				String s = sc.nextLine();
				String ss[]=s.split("~");
				String upQuery = "Update Countries set CurrencyCode='"+ss[1]+"' where CountryName='"+ss[0]+"'";
				String chkQuery = "Select * from Countries where CountryName='"+ss[0]+"'";
				try(Connection conn = DriverManager.getConnection(url))
					{
						Statement tmt = conn.createStatement();
						ResultSet result = tmt.executeQuery(chkQuery);
						if(result.next())	
						{
						PreparedStatement stmt = conn.prepareStatement(upQuery);
						stmt.executeUpdate();
						System.out.println("Record updated");
						System.out.println("-------------------------------------");
						}
						else
						{
							System.out.println("Record not found! Kindly perform insertion!");
							System.out.println("-------------------------------------");
						}
						conn.close();
					}
				catch(SQLException e)
					{
						System.out.println("Connection failed!");
						flag=1;
						e.printStackTrace();
					}
				break;
			}
			
			case 3:
			{
				System.out.println("Enter the ISO~CountryName~Capital~CurrencyCode seperated by '~'");
				sc.nextLine();
				String s = sc.nextLine();
				String ss[]=s.split("~");
				String insQuery = "Insert into Countries values(?,?,?,?)";
				String chkQuery = "Select * from Countries where CountryName='"+ss[1]+"'";
				try(Connection conn = DriverManager.getConnection(url))
					{
						Statement tmt = conn.createStatement();
						ResultSet result = tmt.executeQuery(chkQuery);
						if(!result.next())	
						{
						PreparedStatement stmt = conn.prepareStatement(insQuery);
						stmt.setString(1,ss[0]);
						stmt.setString(2,ss[1]);
						stmt.setString(3,ss[2]);
						stmt.setString(4,ss[3]);
						stmt.executeUpdate();
						System.out.println("Record inserted");
						System.out.println("-------------------------------------");
						}
						else
						{
							System.out.println("Record already exists, perfom updation!");
							System.out.println("-------------------------------------");
						}
						conn.close();
					}
				catch(SQLException e)
					{
						System.out.println("Connection failed!");
						flag=1;
						e.printStackTrace();
					}
				break;
			}
			
			case 4: 
			{
				System.out.println("Enter the CountryName which needs to be deleted from the database.");
				sc.nextLine();
				String s = sc.nextLine();
				String delQuery = "delete from Countries where CountryName='"+s+"'";
				String chkQuery = "Select * from Countries where CountryName='"+s+"'";
				try(Connection conn = DriverManager.getConnection(url))
					{
						Statement tmt = conn.createStatement();
						ResultSet result = tmt.executeQuery(chkQuery);
						if(result.next())	
						{
						PreparedStatement stmt = conn.prepareStatement(delQuery);
						stmt.executeUpdate();
						System.out.println("Record deleted");
						System.out.println("-------------------------------------");
						}
						else
						{
							System.out.println("Record not found!");
							System.out.println("-------------------------------------");
						}
						conn.close();
					}
				catch(SQLException e)
					{
						System.out.println("Connection failed!");
						flag=1;
						e.printStackTrace();
					}
				break;
			}
			
			case 5:
				flag=1;
				System.out.println("Exit from program!");
				break;
			
			}
		
		}
		catch(Exception e)
		{
		System.out.println("Enter the right choice !!");
		flag=1;
		e.printStackTrace();
		}
		
		
		}
	}
}
