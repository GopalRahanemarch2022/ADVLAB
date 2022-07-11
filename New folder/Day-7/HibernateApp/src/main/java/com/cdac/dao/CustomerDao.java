package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.entity.Customer;


public class CustomerDao {
	public void add(Customer user1)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("team4");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = em.getTransaction();
	    tx.begin();
	    em.persist(user1);
	    
	    tx.commit();
	    
	    emf.close();
	    
}
	}
