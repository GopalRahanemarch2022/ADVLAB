package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional.TxType;

public class GenericDao {

	public void save(Object obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			// can be used for insert and update 2in1
			em.merge(obj);
			tx.commit();

		} finally {
			emf.close();
		}

	}

	public Object fetchById(Class clazz, Object pk) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		try {
			EntityManager em = emf.createEntityManager();

			Object obj = em.find(clazz, pk);

			return obj;

		} finally {
			emf.close();

		}
	}
	
	public void delete(Class clazz, Object pk) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			Object obj = em.find(clazz, pk);
			em.remove(obj);
			tx.commit();

		} finally {
			emf.close();

		}
	}
	
	
	
//	public List<Person> fetchPersonByPassportExpiryYear(int year) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
//		EntityManager em = emf.createEntityManager();
//		
//		Query q = em.createQuery("select p from Person p join p.passport ps where year(ps.expiryDate) = :yr");
//		q.setParameter("yr", year);
//		
//		List<Person> p = q.getResultList();
//		
//		emf.close();
//		return p;
//	}

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

//	public Address fetchAddress(int id) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//
//		// find works only with primary key
//
//		Address emp = em.find(Address.class, id);

//		emf.close();
//		return emp;
//
//	}

}
