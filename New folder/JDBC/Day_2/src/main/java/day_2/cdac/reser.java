package day_2.cdac;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class reser {

	public boolean doubleEmail(String email) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/khamgaon", "root", "cdac");

			boolean present = false;
			
			PreparedStatement pst = conn.prepareStatement("select count(*) from Registation where email = ?");
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				int c = rs.getInt(1);
				if(c == 1)
					present = true;
			}
			return present;
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
	
	public void register(String name, String email, int mobileNo, String username, String password) {
		Connection conn = null;
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/khamgaon", "root", "cdac");
				PreparedStatement st = conn.prepareStatement("insert into Registation(name, email, mobileno, username, password) values(?, ?, ?, ?, ?)");
				st.setString(1, name); //substituting ? with actual value
				st.setString(2, email);
				st.setInt(3, mobileNo);
				st.setString(4, username);
				st.setString(5, password);
				st.executeUpdate();
				conn.close();
				
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}		
}
}
		