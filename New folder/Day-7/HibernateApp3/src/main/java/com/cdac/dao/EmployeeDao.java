package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.sql.Select;

import com.cdac.entity.Employee;

public class EmployeeDao {

	public void add(Employee emp) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(emp);
		tx.commit();
		emf.close();
		
	}
	
	public Employee fetch(int empno) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//find works only with primary key
		
		Employee emp = em.find(Employee.class, empno);
		
		emf.close();
		return emp;
			
	}
	
	public List<Employee> fetchAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		Query emp = em.createQuery("select e from Employee e");
		List<Employee> empdata = emp.getResultList();
		
		emf.close();
		return empdata;
			
	}
	
	public List<Employee> fetchAllBySalary(double salary) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Query emp1 = em.createQuery("select e from Employee e where e.salary >= :sal");
		emp1.setParameter("sal", salary);
		
		List<Employee> empdata1 = emp1.getResultList();
		
		emf.close();
		return empdata1;
	}
	
	public List<Object[]> fetchByNameAndSalary() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Query emp2 = em.createQuery("select e.name, e.salary from Employee e");
		
		List<Object[]> empdata2 = emp2.getResultList();
		
		emf.close();
		return empdata2;
	}
	
	public List<String> fetchByName() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select e.name from Employee e"); //HQL/JPQL
		List<String> list = q.getResultList();
		
		emf.close();

		return list;
	}

}
