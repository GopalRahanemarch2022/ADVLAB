package com.cdac.info;

import java.time.LocalDate;
import java.util.List;

import com.cdac.dao.PersonPassportDao;
import com.cdac.entity.Passport;
import com.cdac.entity.Person;

public class PersonPassportExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonPassportDao dao = new PersonPassportDao();
		
//		Person person = new Person();
//		person.setName("Snehal");
//		person.setEmail("snehal@gmail.com");
//		person.setDateOfBirth(LocalDate.of(1993, 10, 18));
//		
//		Passport psPassport = new Passport();
//		psPassport.setIssueDate(LocalDate.of(2019, 7, 30));
//		psPassport.setExpiryDate(LocalDate.of(2029, 7, 30));
//		psPassport.setIssuedBy("Governmnet Of India");
//		
//		person.setPassport(psPassport);
//		psPassport.setPerson(person);
//		
//		dao.add(person);
		
//		Person p = dao.fetchPassportByPassportNo(3);
//		System.out.println(p.getId()+" "+p.getName() + " " + p.getEmail());
	
		List<Person> p1 = dao.fetchPersonByPassportExpiryYear(2030);
		for(Person p: p1)
			System.out.println(p.getId()+" "+p.getName() + " " + p.getEmail());
	
	}

}
