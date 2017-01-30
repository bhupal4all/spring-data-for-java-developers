package com.ranga.spring.data;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		BookRepository repository = context.getBean(BookRepository.class);

		printBooks(repository.findTopByOrderByPageCountDesc());

		printBooks(repository.findFirstByOrderByPageCountAsc());

		printBooks(repository.findTop3ByOrderByPageCountDesc());
		
		printBooks(repository.findTop3ByTitleOrderByPriceDesc("Design Patterns"));
		
		printBooks(repository.findTop3ByTitleLikeIgnoreCaseOrderByPriceDesc("%of%"));
		
		printBooks(repository.findTop3ByTitleContainingOrderByPriceDesc("%of%"));
	}

	public static void printBooks(List<Book> books) {
		System.out.println("Books ? " + books.size());
		for (Book book : books) {
			System.out.println("> " + book);
		}
	}
}
