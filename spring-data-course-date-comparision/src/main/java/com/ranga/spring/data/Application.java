package com.ranga.spring.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		BookRepository repository = context.getBean(BookRepository.class);
		
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-mm-dd");
		
		try {
			printBooks(repository.findByPublishDateAfter(simpleDate.parse("1948-11-08")));
			
			printBooks(repository.findByPublishDateBefore(simpleDate.parse("1948-11-08")));
			
			printBooks(repository.findByPublishDateBetween(simpleDate.parse("1932-11-08"),simpleDate.parse("1943-11-08")));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public static void printBooks(List<Book> books) {
		System.out.println("Books ? " + books.size());
		for (Book book : books) {
			System.out.println("> " + book);
		}
	}
}
