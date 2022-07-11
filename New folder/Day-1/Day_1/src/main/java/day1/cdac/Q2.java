
/*
 
2. Write a form to take the date of birth of the user
   then write a servlet to display the age based on the date of birth supplied
   for ex:
   If the user enters: 10-Mar-1995
   Then the output should be:
   Version 1: Your age is 27 yrs
   Version 2: You are 27 yrs 3 months 12 Days old
   
 */
package day1.cdac;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Q2")
public class Q2 extends HttpServlet {
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String DOB=request.getParameter("DOB");
    System.out.println(DOB);
    Date  date = new Date();
    
    int yyyy=LocalDate.now().getYear();
    int mm=LocalDate.now().getMonthValue();
    int dd=LocalDate.now().getDayOfMonth();
    
    
    
    String[] str = DOB.split("-");
    
    int YYYY=Integer.parseInt(str[0]);
    int MM=Integer.parseInt(str[1]);
    int DD=Integer.parseInt(str[2]);
    
    System.out.println("Your age is"+(YYYY-yyyy) +"yrs");
    System.out.println("Your age is "+(YYYY-yyyy)+ " yrs " +(MM-mm)+" months " +(DD-dd)+" Days old ");
    
    PrintWriter out = response.getWriter();
    out.write("Your age is"+(YYYY-yyyy) +"yrs"  );
    out.write("Your age is "+(YYYY-yyyy)+ " yrs " +(MM-mm)+" months " +(DD-dd)+" Days old ");
     
    
    

    
    
    
    
    
    		
	
	
	}

	

}
