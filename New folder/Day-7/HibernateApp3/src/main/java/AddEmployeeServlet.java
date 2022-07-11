

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.EmployeeDao;
import com.cdac.entity.Employee;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
		emp.setName(request.getParameter("name"));
		emp.setSalary(Double.parseDouble(request.getParameter("salary")));
		emp.setDateOfJoining(LocalDate.parse(request.getParameter("doj")));
		
		EmployeeDao dao = new EmployeeDao();
		dao.add(emp);
		
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.write("<h1>Record Added..!!!</h1>");
	}

}
