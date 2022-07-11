package day1.cdac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Gopal")
public class Oneservlet extends HttpServlet {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   
	   String a1=request.getParameter("v1");
		String a2=request.getParameter("v2");
		String action=request.getParameter("action");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.write("<html><body>");
		
		
		if (action.equals("ADD")) {
			int total=Integer.parseInt(a2)+Integer.parseInt(a1);
			out.write("<h1>Sum is "+total+"<h1/>");
		}
		else {
			int total=Integer.parseInt(a1)-Integer.parseInt(a2);
			out.write("<h1>Sub is "+total+"<h1/>");
		}
		
		out.write("</body></html>");
		
	}


	
}
		
		



	
