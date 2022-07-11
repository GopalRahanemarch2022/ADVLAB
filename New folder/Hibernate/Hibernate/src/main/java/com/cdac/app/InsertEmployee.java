package com.cdac.app;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.dao.EmployeeDao;
import com.cdac.entity.Employee;



public class InsertEmployee {

	public static void main(String[] args) {
		Employee emp = new Employee();
//		emp.setEmpno(1004);
//		emp.setName("ram");
//		emp.setSalary(10000);
//		emp.setDateOfJoining(LocalDate.of(2022, 10, 10));

		EmployeeDao dao = new EmployeeDao();
//		dao.add(emp);
		
		// to call on the basis of we use the find methed................................................................
		
		Employee emp1 = dao.fetch(1002);
		System.out.println(emp1.getName() + " " + emp1.getSalary());
		
		// To fetch all data from Table.........................................................................
		List<Employee> list = dao.fetchAll();
		for(Employee emp11 : list)
			System.out.println(emp11.getEmpno() + " " + emp11.getName() + " " + emp11.getSalary() + " " + emp11.getDateOfJoining());

		
		System.out.println(".............");
		List<Employee> list2 = dao.fetchAllBySalary(5000);
		for(Employee emp2 : list2)
			System.out.println(emp2.getEmpno() + " " + emp2.getName() + " " + emp2.getSalary() + " " + emp2.getDateOfJoining());
		
		
		
		System.out.println("..............");
		List<String> names = dao.fetchAllNames();
		for(String name : names)
			System.out.println(name);
		
		
		
		System.out.println("..............");
		List<Object[]> namesAndSalaries = dao.fetchAllNamesAndSalaries();
		for(Object[] arr : namesAndSalaries)
			System.out.println(arr[0] + " " + arr[1]);
	}
}