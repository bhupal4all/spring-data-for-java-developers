package com.ranga.spring.data;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		BookRepository repository = context.getBean(BookRepository.class);
	
		for(Book b: repository.findByIds(2L, 5L)) {
			System.out.println(b);
		}
	}

}
