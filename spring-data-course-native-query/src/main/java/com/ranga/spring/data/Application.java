package com.ranga.spring.data;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		BookRepository repository = context.getBean(BookRepository.class);
	
		System.out.println(repository.fireNativeQuery("Design Patterns"));
		System.out.println("PAGE_COUNT="+repository.fireNativeQuery2("Design Patterns"));

		for(Object[] row: repository.fireNativeQuery3("Design Patterns")) {
			System.out.println(">> "+row[3]);
		}

		for(Object[] row: repository.fireNativeQuery4("Design Patterns")) {
			System.out.println(">> "+row[1].toString());
		}
		
		System.out.println(" -- done -- ");
	}

}
