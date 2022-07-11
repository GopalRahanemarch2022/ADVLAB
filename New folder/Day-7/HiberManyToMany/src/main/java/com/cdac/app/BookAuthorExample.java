package com.cdac.app;

import java.util.ArrayList;
import java.util.List;

import com.cdac.dao.GenericDao;
import com.cdac.entity.Author;
import com.cdac.entity.Book;

public class BookAuthorExample {

	public static void main(String[] args) {
		GenericDao dao = new GenericDao();
		
		Author author = new Author();
		author.setName("Elisabeth Robson");
		author.setEmail("elisa@gmail.com");
		dao.save(author);
		

	
	}
}
