package nethmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HmsDao {
	
	public Connection dbConnection(){
		 Connection con = null;
		   
		 String url="jdbc:mysql://localhost:3306/hms";
		 String un="root";
		 String pw="";
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 con = DriverManager.getConnection(url,un,pw);
			 System.out.println("Database coonnectiion sucess");
		 }catch(Exception e) {
			 
		 }
		return con;
	}

	public boolean doctorCheck(String un, String up) {
		Connection con =dbConnection();
		
		try {
			String query ="SELECT * FROM doctor WHERE un=? AND pw=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, un);
			ps.setString(2,up);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {
			
		}
		return false;
	}

	public List<Patient> getAllPatients() {
		List<Patient> ptList =new ArrayList<>();
		Connection con =dbConnection();
		
		String query="SELECT * FROM patient";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id =rs.getInt("id");
				String name =rs.getString("name");
				String email =rs.getString("email");
				int age =rs.getInt("age");
				String city = rs.getString("city");
				String gender = rs.getString("gender");
				
				ptList.add(new Patient(id ,name,email,age,city,gender));
				
			}
		}catch(Exception e) {
			
		}
		return ptList;
	}

}
