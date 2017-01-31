package com.ranga.spring.data;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		BookRepository repository = context.getBean(BookRepository.class);
	
		System.out.println(">> Updated count ? " + repository.updateBookPageCount("Animal Farm", 100));
		
		for(Book b: repository.findAll()){
			System.out.println(b);
		}
		
		System.out.println(" -- done -- ");
	}

}
