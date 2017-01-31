package com.ranga.spring.data;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		BookRepository repository = context.getBean(BookRepository.class);

		System.out.println("-- Paging Demo --");
		
		printBooks(repository.findAll(new PageRequest(0, 3)).getContent());

		printBooks(repository.findAll(new PageRequest(2, 3)).getContent());		
		
		printBooks(repository.findByPageCountGreaterThan(450, new PageRequest(0, 2)));
	}

	public static void printBooks(List<Book> books) {
		System.out.println("Books ? " + books.size());
		for (Book book : books) {
			System.out.println("> " + book);
		}
	}
}
