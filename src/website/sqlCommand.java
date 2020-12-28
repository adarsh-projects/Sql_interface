package website;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import website.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class sqlCommand {
	public static Connection getConnection() {
		Connection con = null;
		String user = "root";
		String password = "Root@7668";
		String url = "jdbc:mysql://localhost:3306/userinfo";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, user, password); 
		}catch(Exception e) {
			System.out.println("Exception : " + e);
		}
		return con;
	}
	public static ArrayList[] showData(String query){
		ArrayList[] list = (ArrayList [])new ArrayList[10];
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.clientPrepareStatement(query);
			ResultSet rs = ps.executeQuery();
			for(int i = 0; i < 10; i++) {
				list[i] = new ArrayList();
			}
			int i1=0,i2=0,i3=0,i4=0,i5=0,i6=0;
			while(rs.next()) {
				User u = new User();
				try {
					u.setId(rs.getInt("id"));
					if(i1 == 0) {
						list[0].add("Id");
						i1++;
					}
				}
				catch(Exception e) {
					if(i1 == 0) {
						list[0].add("Id");
						i1++;
					}
				}
				try {
					u.setName(rs.getString("name"));
					if(i2 == 0) {
						list[0].add("name");
						i2++;
					}
				}
				catch(Exception e) {
				}
				try {
					u.setEmail(rs.getString("email"));
					if(i4 == 0) {
						list[0].add("email");
						i4++;
					}
				}
				catch(Exception e) {}
				try {
					u.setSex(rs.getString("sex"));
					if(i5 == 0) {
						list[0].add("sex");
						i5++;
					}
				}
				catch(Exception e) {}
				try {
					u.setCountry(rs.getString("country")+"\n");
					if(i6 == 0) {
						list[0].add("country");
						i6++;
					}
				}
				catch(Exception e) {}
				list[1].add(u);
			}
		}catch(Exception e) {
			list[1].add(e.toString());
		}
		return list;
	}
	public static String CreateDropData(String query) {
		String res = "";
		try {
			Connection con = getConnection(); 
			PreparedStatement ps = (PreparedStatement) con.clientPrepareStatement(query);
			ps.execute();
			res = "SQL Commond Excecuted Successfully!";
		}catch(Exception e) {
			res = e.toString();
		}
		return res;
	}
}
