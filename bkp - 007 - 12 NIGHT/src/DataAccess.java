import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class DataAccess {
	private Connection con;
	private Statement stat;
	private ResultSet res;

	public DataAccess(){
		try {
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
//			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/user", "root", "");
//			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/falldb", "root", "");
			stat = (Statement) con.createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Couldn't connect to the database.");
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	public boolean login(String name, String pass){
		String sql = "Select * from user where name = '" + name + "' and password ='" + pass + "'";
		try{
			res = stat.executeQuery(sql);
			if(res.next()){
				// strType = "receptionist";
				// strType = res.getString("type");
				//System.out.println(res.getString("type"));
				LoginGui.typeLogIn = res.getString("type");
				if(LoginGui.typeLogIn.equals("doctor")) {
					LoginGui.doctorIdStr = res.getString("id");
				}
				return true;
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<User> GetUsers(String sql){
		ArrayList<User> list = new ArrayList<User>();
		
		try{
			res = stat.executeQuery(sql);
			while(res.next())
			{
				User u  	=	new User();
				u.id		=	res.getInt("id");
				u.name		=	res.getString("name");
				u.password	=	res.getString("password");
				u.type		=	res.getString("type");
				list.add(u);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	// GetDoctor or
	// Modify & create another function?

	public ArrayList<Doctor> GetDoctors(String sql){
		ArrayList<Doctor> list = new ArrayList<Doctor>();

		try{
			res = stat.executeQuery(sql);
			while(res.next())
			{
				Doctor u  	=	new Doctor();
				u.id		=	res.getInt("id");
				u.name		=	res.getString("name");
				u.password	=	res.getString("password");
				u.type		=	res.getString("type");
				u.specialty		=	res.getString("specialty");
				list.add(u);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public void insert(String sql){
		try {
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// GetPatients function

	public ArrayList<Patient> GetPatients(String sql){
		ArrayList<Patient> list = new ArrayList<Patient>();

		try{
			res = stat.executeQuery(sql);
			while(res.next())
			{
				Patient u  	=	new Patient();
				u.name		=	res.getString("name");
				u.age		=	res.getString("age");
				u.contactNo	=	res.getString("contact no");
				u.gender	=	res.getString("gender");
				list.add(u);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	public void update(String sql){
		try {
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void newDocDb(String sql){
		try {
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void deleteRow(String sql) {


	// sql - "DELETE FROM `user` WHERE `id` = '"+delValue+"'";
	// sql - "DELETE FROM `user` WHERE `user`.`id` = 213"?
	// sql - "DELETE FROM `user` WHERE `user`.`id` = "+id+"";

		try {
			// stat.executeUpdate(sql);
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
