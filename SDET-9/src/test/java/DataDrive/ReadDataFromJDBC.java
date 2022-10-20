package DataDrive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ReadDataFromJDBC {
	@Test
	public void readDataTest() throws Throwable {
		//Step-1 register the driver
		// Step-2 connect to database
		Connection con=null;
		try {
			Driver dre = new Driver();
			DriverManager.registerDriver(dre);
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			
			//Step-3 create statement
			Statement stmt = con.createStatement();
			
			//Step-4 execute query
			ResultSet res = stmt.executeQuery("select* from student_info;");
			while (res.next()) {
			System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		//close connect with dataBase
		con.close();
		System.out.println("connection is closed");
		}
		
	}

}
