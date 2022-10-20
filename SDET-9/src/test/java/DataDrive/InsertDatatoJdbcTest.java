package DataDrive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDatatoJdbcTest {
	public void insertDataJdbcTest() throws Throwable {
		
		//Step-1 Register the drive
		Driver dre = new Driver();
		DriverManager.registerDriver(dre);
		
		//Step-2 CoNNECT the data to dataBase
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		//Step-3 create statement
		Statement stmt = con.createStatement();
		int res = stmt.executeUpdate("insert into students_info(regno,firstname,middlename,lastname)values(7,'today','visit','v');");
		if(res==1) {
		System.out.println("Data is stored");
		}
		else {
		System.out.println("Data is not stored");
		}
		
		//step-5 close the database connection
		con.close();

	}
	
}
