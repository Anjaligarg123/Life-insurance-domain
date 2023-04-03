package com.GeneralUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection con=null;
	public void connectTODb() throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstants.DBURL,IPathConstants.DBUSERNAME,IPathConstants.DBPASSWORD);
	}
	public String executeQueryAndGetData(String query,String expData,int colIndex) throws Throwable {
		ResultSet result=con.createStatement().executeQuery(query);
		boolean flag=false;
		 while(result.next()) {
			 String data=result.getString(colIndex);
			 if(data.equalsIgnoreCase(expData))
			 {
				 flag=true;
				 break;
			 }
		 }
		 if(flag)
		 {
			 System.out.println("data is verfied");
			 return expData;
		 }
		 else {
			 System.out.println("data is not updated");
			 return "";
		 }
		
	}
	public void closeDB() throws Throwable
	{
		con.close();
		System.out.println("database connection closed");
	}

}
