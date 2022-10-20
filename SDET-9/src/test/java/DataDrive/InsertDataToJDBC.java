package DataDrive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class InsertDataToJDBC {
	@Test
	public void insertDataToJDBC() throws Throwable {
		
		Connection con=null;
		try {
			//Step-1 Register the drive
			Driver dre = new Driver();
			DriverManager.registerDriver(dre);
			//Step-2 CoNNECT the data to dataBase
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			
			//Step-3 create statement
			Statement stmt = con.createStatement();
			
			//step-4 insert the data 
			
			int res = stmt.executeUpdate("insert into students_info(regno,firstname,middlename,lastname)values(5,'hello','my','village');");
			if(res==1) {
			System.out.println("Data is stored");
			}
			else {
			System.out.println("data is not stored");
			}
		} 
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			finally {
				
			// Step-5 Close the Database connection
			System.out.println("connection closed");
	
			con.close();
		}
		
	}

}
