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

	public void addNewPatient(Patient pt) {
		
		try {
			Connection con = dbConnection();
			String sql="INSERT INTO patient(name,email,age,city,gender) VALUES(?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pt.getName());
			ps.setString(2,pt.getEmail());
			ps.setInt(3, pt.getAge());
			ps.setString(4,pt.getCity());
			ps.setString(5, pt.getGender());
			
			System.out.println(ps);
			
			ps.executeUpdate();
			
		}catch(Exception e) {
			
		}
		
	}

	public Patient selectOldPatient(int id) {
		Connection con = dbConnection();
		
		Patient oldPatient = null;
		
		try {
			
			String sql = "SELECT * FROM patient WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			
			System.out.println(ps);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String email=rs.getString("email");
				int age=rs.getInt("age");
				String city = rs.getString("city");
				String gender = rs.getString("gender");
				
				oldPatient = new Patient(id,name,email,age,city,gender);
				
			}
		}catch(Exception e) {
			
		}
		
		return oldPatient;
	}

	public boolean updateOldPatient(Patient updatedPatient) {
		Connection con = dbConnection();
		boolean update = false;
		try {
			String sql = "UPDATE patient SET name=?,email=?,age=?,city=?,gender=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			ps.setString(1,updatedPatient.getName());
			ps.setString(2,updatedPatient.getEmail());
			ps.setInt(3, updatedPatient.getAge());
			ps.setString(4,updatedPatient.getCity());
			ps.setString(5,updatedPatient.getGender());
			
			ps.setInt(6,updatedPatient.getId());
			update = ps.executeUpdate() > 0;
			
		}catch(Exception e) {
			
		}
		return update;
	}

	
	
	
	public void deletePatient(int id) {
		Connection con = dbConnection();
		
		try {
			String query ="DELETE FROM patient WHERE id=?";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
			System.out.print("Delete Success");
			
		}catch(Exception e) {
			
		}
		
	}

}
