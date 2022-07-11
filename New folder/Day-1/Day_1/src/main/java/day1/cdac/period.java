package day2.cdac;
import java.time.LocalDate;
import java.time.Period;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class period
 */
@WebServlet("/period")
public  class period extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String date1=null;
		try {
   date1=(request.getParameter("date"));
	}catch (Exception e) {
		// TODO: handle exception
	}

	LocalDate d=LocalDate.parse(date1);
		LocalDate date=java.time.LocalDate.now();

	int age=date.getYear()-d.getYear();
	Period p= Period.between(d ,date);
	System.out.println("year is " +p.getYears());
	System.out.println("year is " +p.getMonths());
	System.out.println("year is " +p.getDays());
	
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	out.write("<html><body>");
	out.write("<h1>age is" +p.getYears()+"years"+p.getMonths()+"months"+p.getDays()+"days</h1>");
	out.write("</body></html>");
	}
}
	
