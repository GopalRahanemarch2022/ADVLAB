package com.cdac.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.Address;
import com.cdac.entity.Customer;
import com.cdac.entity.Employee;
import com.cdac.entity.Person;


public class PersonPassportDao {

	public void add(Person person) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(person);
		tx.commit();
		emf.close();

	}

	public void update(Customer cust) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.merge(cust);
		tx.commit();
		emf.close();

	}

	public Person fetchPassportByPassportNo(int passportNo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();


		// find works only with primary key

		Query q = em.createQuery("select p from Person p join p.passport ps where ps.passportNo = :pno");
		q.setParameter("pno", passportNo);
		Person p = (Person)q.getSingleResult();
		emf.close();
		return p;

	}
//	
	public List<Person> fetchPersonByPassportExpiryYear(int year) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select p from Person p join p.passport ps where year(ps.expiryDate) = :yr");
		q.setParameter("yr", year);
		
		List<Person> p = q.getResultList();
		
		emf.close();
		return p;
	}
//	
//	public List<Customer> fetchAllByCity(String city) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		
//		Query emp1 = em.createQuery("select c from Customer c join c.address a where a.city = :ct");
//		emp1.setParameter("ct", city);
//		
//		List<Customer> empdata2 = emp1.getResultList();
//		
//		emf.close();
//		return empdata2;
//	}
//	
//	public Address fetchAddressByCustomerName(String name) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
//		EntityManager em = emf.createEntityManager();
//		
//		Query emp1 = em.createQuery("select a from Customer c join c.address a where c.name= :nm");
//		emp1.setParameter("nm", name);
//		
//		Address addr = (Address)emp1.getSingleResult();
//		
//		emf.close();
//		return addr;
//	}
//
//	public void add(Address addr) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//
//		em.persist(addr);
//		tx.commit();
//		emf.close();
//
//	}
//
//	public Address fetchAddress(int id) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//
//		// find works only with primary key
//
//		Address emp = em.find(Address.class, id);
//
//		emf.close();
//		return emp;
//
//	}

}
