package website;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class JavaDatabase {
	public static Connection getConnection(){
		Connection con = null;
		String user = "root";
		String password = "Root@7668";
		String url = "jdbc:mysql://localhost:3306/userinfo";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =  (Connection) DriverManager.getConnection(url, user, password);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	public static boolean saveData(User user) {
		boolean status = false;
		String sql = "insert into user(id,name,password,email,sex,country) value(?,?,?,?,?,?)";
		try {
			Connection c = getConnection();
			PreparedStatement ps = (PreparedStatement) c.clientPrepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getSex());
			ps.setString(6, user.getCountry());
			ps.execute();
			status = true;
		}catch(Exception e) {
			System.out.println("Exception :-" + e);
		}
		return status;
	}
	public static boolean deleteData(int id) {
		boolean status = false;
		String deleteSql = "delete from user where id = ?";
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.clientPrepareStatement(deleteSql);
			ps.setInt(1, id);
			ps.execute();
			status = true;
		}catch(Exception e) {
			System.out.println("Exceptiom :-" + e);
		}
		return status;
	}
	public static boolean updateData(User user) {
		// we have to change all this parameter when i worked for real site
		boolean status = false;
		String update = "update user set id = ?, name = ?, password = ?, email = ?, sex = ?, country = ? where id = ?";
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.clientPrepareStatement(update);
			ps.setInt(1, user.getId());
			ps.setString(2,	user.getName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getSex());
			ps.setString(6, user.getCountry());
			ps.setLong(7, user.getId());
			ps.execute();
			status = true;
		}catch(Exception e) {
			System.out.println("Exception : " + e);
		}
		return status;
	}
	public static ArrayList<User> showData() {
		ArrayList<User> list = new ArrayList<User>();
		String query = "select * from user";
		try {
			Connection con = getConnection();
			PreparedStatement ps = 
					(PreparedStatement) con.clientPrepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User u = new User();
				try {u.setId(rs.getInt("id"));}
				catch(Exception e) {u.setId(0);}
				try {u.setName(rs.getString("name"));}
				catch(Exception e) {u.setName(null);}
				try {u.setPassword(rs.getString("password"));}
				catch(Exception e) {u.setPassword(null);}
				try {u.setEmail(rs.getString("email"));}
				catch(Exception e) {u.setEmail(null);}
				try {u.setSex(rs.getString("sex"));}
				catch(Exception e) {u.setSex(null);}
				try {u.setCountry(rs.getString("country")+"\n");}
				catch(Exception e) {u.setCountry(null);}
				list.add(u);
			}
		}catch(Exception e) {
			System.out.println("Exception : " + e);
		}
		return list;
	}
	public static void showDataById(int id) {
		String query = "select * from user where id = ?";
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.clientPrepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Person " + rs.getInt("id"));
				System.out.println("Id : " + rs.getInt("id")+"\n Name : "+rs.getString("name")+"\n Password : "+rs.getString("password")
				+"\n Email : "+rs.getString("email")+"\n Sex : " + rs.getString("sex")+"\n Country : "+rs.getString("country")+"\n");
			}
		}catch(Exception e) {
			System.out.println("Exception : " + e);
		}
	}
}
