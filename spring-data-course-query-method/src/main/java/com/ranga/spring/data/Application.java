package com.ranga.spring.data;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		BookRepository repository = context.getBean(BookRepository.class);

		System.out.println("-- Method Types Demo --");

//		for (Book book : repository.findByPageCountGreaterThan(250)) {
//			System.out.println("> " + book);
//		}

//		Page page = repository.findByPageCountGreaterThan(250, new PageRequest(0, 3));
//		System.out.println(page.getTotalElements());
//		
//		for (Book book : repository.findByPageCountGreaterThan(250, new PageRequest(0, 3))) {
//			System.out.println("> " + book);
//		}
				
		Slice slice = repository.findByPageCountGreaterThan(250, new PageRequest(3, 3));
		System.out.println("Are there any ? " +slice.hasNext());
		
		for (Book book : repository.findByPageCountGreaterThan(250, new PageRequest(0, 3))) {
			System.out.println("> " + book);
		}	
	}

}
