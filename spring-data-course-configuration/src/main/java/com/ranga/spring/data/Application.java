package com.ranga.spring.data;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration.class);

		Book book = new Book();
		book.setTitle("A Text Book");
		book.setPageCount(100);
		book.setPublishDate(new Date());
		
		BookService service = context.getBean(BookService.class);
		service.save(book);

		System.out.println("--done--");
	}
}
