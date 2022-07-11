package com.cdac.info;

import java.util.List;

import com.cdac.dao.CustomerAddressDao;
import com.cdac.entity.Address;
import com.cdac.entity.Customer;

public class AddCustomerAndAddress {
	public static void main(String[] args) {
		CustomerAddressDao dao = new CustomerAddressDao();
	
//		Customer c = new Customer();
//		c.setName("Himanshu");
//		c.setEmail("himanshu@gmail");
//		dao.add(c);
//	
//		Address a = new Address();
//		a.setPincode(400703);
//		a.setCity("Kanpur");
//		a.setState("UP");
//		dao.add(a);
		
//		Customer c = new Customer();
//		c.setName("Shrutika");
//		c.setEmail("shrutika@gmail");
//		dao.add(c);
//		
//		Address a = new Address();
//		a.setPincode(400703);
//		a.setCity("Navi Mumbai");
//		a.setState("MH");
//		dao.add(a);
		
		
//		Customer c = dao.fetchCustomer(2);
//		Address a = dao.fetchAddress(2);
//		
//		c.setAddress(a);
//		dao.update(c);
		
//		Customer c = new Customer();
//		c.setName("Gopal");
//		c.setEmail("gopal@gmail");
//
//	
//		Address a = new Address();
//		a.setPincode(400703);
//		a.setCity("Shegaon");
//		a.setState("MH");
		
//		Customer c = new Customer();
//		c.setName("Bediskar");
//		c.setEmail("bedu@outlook");
//
//	
//		Address a = new Address();
//		a.setPincode(400712);
//		a.setCity("Amalner");
//		a.setState("MH");
//		
//		c.setAddress(a);
//		dao.add(c);
		
		List<Customer> list = dao.fetchAllByEmail("gmail");
		for(Customer c: list)
			System.out.println(c.getId()+" "+c.getName()+" "+c.getEmail());
		
		List<Customer> list1 = dao.fetchAllByEmail("outlook");
		for(Customer c: list1)
			System.out.println(c.getId()+" "+c.getName()+" "+c.getEmail());
		
		List<Customer> list2 = dao.fetchAllByCity("Navi Mumbai");
		for(Customer c: list2)
			System.out.println(c.getId()+" "+c.getName()+" "+c.getEmail());
	
		Address address = dao.fetchAddressByCustomerName("Himanshu");
		System.out.println(address.getId()+" "+ address.getCity()+" "+address.getPincode()+" "+ address.getState());
	
	
	
	}
}
