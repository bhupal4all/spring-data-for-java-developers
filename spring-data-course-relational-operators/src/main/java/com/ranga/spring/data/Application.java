package com.ranga.spring.data;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		BookRepository repository = context.getBean(BookRepository.class);
		
		// =
		printBooks(repository.findByPageCountEquals(200));
		
		// >
		printBooks(repository.findByPageCountGreaterThan(200));

		// >=
		printBooks(repository.findByPageCountGreaterThanEqual(200));
		
		// <
		printBooks(repository.findByPageCountLessThan(200));

		// >
		printBooks(repository.findByPageCountBetween(300, 500));

	}

	public static void printBooks(List<Book> books) {
		System.out.println("Books ? " + books.size());
		for (Book book : books) {
			System.out.println("> " + book);
		}
	}
}
