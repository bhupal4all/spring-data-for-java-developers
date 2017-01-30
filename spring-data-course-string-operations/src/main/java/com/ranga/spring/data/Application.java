package com.ranga.spring.data;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		BookRepository repository = context.getBean(BookRepository.class);

		// = <>
		Book book = repository.findByTitle("Design Patterns");
		System.out.println("=> by title " + book);
		
		// Like <>
		printBooks(repository.findByTitleLike("%sign%"));
		
		// Like %<>%
		printBooks(repository.findByTitleContaining("sign"));
		
		// Like <>%
		printBooks(repository.findByTitleStartingWith("Design"));
		
		// Like %<>
		printBooks(repository.findByTitleEndingWith("Patterns"));
		
		// = Upper(<>)
		printBooks(repository.findByTitleIgnoreCase("design Patterns"));
	}
	
	public static void printBooks(List<Book> books) {
		System.out.println("Books ? "+books.size());
		for(Book book: books) {
			System.out.println("> " + book);
		}
	}
}
