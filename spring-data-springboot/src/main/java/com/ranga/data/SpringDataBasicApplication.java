package com.ranga.data;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataBasicApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataBasicApplication.class, args);
		
		BookRepository repository = context.getBean(BookRepository.class);
		
		Book book = new Book();
		book.setTitle("A Text Book");
		book.setPageCount(100);
		book.setPublishDate(new Date());
		
		repository.save(book);
	}
}
