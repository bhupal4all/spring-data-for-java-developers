package com.ranga.spring.data;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		BookRepository repository = context.getBean(BookRepository.class);
	
		for(long i=1; i<=5;i++) {
			repository.findByIds(i);
		}

		System.out.println(" -- done -- ");
	}

}
