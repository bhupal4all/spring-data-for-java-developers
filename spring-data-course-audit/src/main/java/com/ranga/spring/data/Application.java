package com.ranga.spring.data;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		BookRepository repository = context.getBean(BookRepository.class);
	
		Book book = BookUtil.create();
		repository.save(book);
		System.out.println(repository.findOne(book.getBookId()));
		
//		book.setTitle("title changed");
//		repository.save(book);
//		System.out.println(repository.findOne(book.getBookId()));
		
		System.out.println(" -- done -- ");
	}

}
