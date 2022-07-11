package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.Address;
import com.cdac.entity.Customer;
import com.cdac.entity.Employee;


public class CustomerAddressDao {

	public void add(Customer cust) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(cust);
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

	public Customer fetchCustomer(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// find works only with primary key

		Customer emp = em.find(Customer.class, id);

		emf.close();
		return emp;

	}
	
	public List<Customer> fetchAllByEmail(String domain) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Query emp1 = em.createQuery("select c from Customer c where c.email like :em");
		emp1.setParameter("em", "%" + domain + "");
		
		List<Customer> empdata1 = emp1.getResultList();
		
		emf.close();
		return empdata1;
	}
	
	public List<Customer> fetchAllByCity(String city) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Query emp1 = em.createQuery("select c from Customer c join c.address a where a.city = :ct");
		emp1.setParameter("ct", city);
		
		List<Customer> empdata2 = emp1.getResultList();
		
		emf.close();
		return empdata2;
	}
	
	public Address fetchAddressByCustomerName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		Query emp1 = em.createQuery("select a from Customer c join c.address a where c.name= :nm");
		emp1.setParameter("nm", name);
		
		Address addr = (Address)emp1.getSingleResult();
		
		emf.close();
		return addr;
	}

	public void add(Address addr) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(addr);
		tx.commit();
		emf.close();

	}

	public Address fetchAddress(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// find works only with primary key

		Address emp = em.find(Address.class, id);

		emf.close();
		return emp;

	}

}
