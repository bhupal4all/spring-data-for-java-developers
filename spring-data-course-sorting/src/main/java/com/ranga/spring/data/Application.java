package com.ranga.spring.data;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		BookRepository repository = context.getBean(BookRepository.class);

		System.out.println("-- Paging Demo --");

		printBooks(repository.findAll());

		printBooks(repository.findAll(new Sort("pageCount")));
		
		printBooks(repository.findAll(new Sort(Sort.Direction.DESC, "pageCount")));
		
		printBooks(repository.findAll(new Sort(Sort.Direction.ASC,"author.lastName", "pageCount")));

		printBooks(repository.findAll(new Sort(Sort.Direction.ASC,"author.lastName").and(new Sort(Sort.Direction.DESC, "pageCount"))));
		
		printBooks(repository.findByPageCountGreaterThan(250, new Sort(Sort.Direction.DESC,"pageCount")));
	}
	
	public static void printBooks(List<Book> books) {
		System.out.println("Books ? " + books.size());
		for (Book book : books) {
			System.out.println("> " + book);
		}
	}
}
