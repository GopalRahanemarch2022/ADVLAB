package day_2.cdac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import day_2.cdac.reser;


@WebServlet("/JDBC")
public class JDBC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int mobileNo = Integer.parseInt(request.getParameter("mobileNo"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		
		reser obj=new reser();
		boolean present=obj.doubleEmail(email);
		
		if(present) {
			out.write("<h1> This Email is allready exits</h1>");
		}
		else {
			obj.register(name,email,mobileNo,username,password);
			out.write("<h1>Registration successful!</h1>");
		}
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/khamgaon", "root", "cdac");
//			PreparedStatement st = conn.prepareStatement("insert into Registation(name, email, mobileno, username, password) values(?, ?, ?, ?, ?)");
//			st.setString(1, name); //substituting ? with actual value
//			st.setString(2, email);
//			st.setInt(3, mobileNo);
//			st.setString(4, username);
//			st.setString(5, password);
//			st.executeUpdate();
//			conn.close();
//			
//			
//			
//			out.write("<h1>Registration successful!</h1>");
//			out.write("</body></html>");
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
		
		
	}

}
