package com.cdac.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.CustomerDao;

import com.cdac.entity.Customer;



public class CustomerServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub4
		
		Customer customer=new Customer();
		
	customer.setEmpno(Integer.parseInt(request.getParameter("empno")));
 
	customer.setName(request.getParameter("name"));	

		customer.setSalary( Integer.parseInt(request.getParameter("Salary")));

	customer.setLocation( request.getParameter("location"));

		
		CustomerDao dao = new CustomerDao();

	     dao.add(customer);
		PrintWriter out = response.getWriter();
		out.write("<h1>heee inserted</h1>");

	}

}
