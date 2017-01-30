package com.ranga.spring.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		// one book
		BookRepository repository = context.getBean(BookRepository.class);
		Book book = repository.findOne(1L);
		System.out.println(book);

		// Find all
		List<Book> books = repository.findAll();
		for (Book bk : books) {
			System.out.println(bk);
		}

		// Find all by ids
		List<Book> books2 = repository.findAll(new ArrayList<Long>() {
			{
				add(1L);
				add(3L);
				add(7L);
			}
		});
		for (Book bk : books2) {
			System.out.println(bk);
		}

		// Save One
		Book nBook = new Book("Title One", new Date(), 300, new BigDecimal(300.01));
		nBook = repository.save(nBook);
		System.out.println("new book => " + nBook);
		
		// Save Multiple
		List<Book> nbooks = BookUtil.create(5);
		nbooks = repository.save(nbooks);
		for (Book bk : nbooks) {
			System.out.println("new book > "+ bk);
		}
		
		// Modifing
		nBook.setTitle("title got changed");
		nBook = repository.save(nBook);
		System.out.println("modified => " + nBook);

		// changing the id, so it would create a new one
		nBook.setBookId(1000L);
		nBook.setTitle("new title");
		nBook = repository.save(nBook);
		System.out.println("modified for new one => " + nBook);

		// delete by id
		repository.delete(2L);
		
		// delete a list
		/*
		 * Hibernate: delete from BOOK where BOOK_ID=?
		 */
		repository.delete(repository.findAll(new ArrayList<Long>() {
			{
				add(1L);
				add(3L);
				add(7L);
			}
		}));
		
		// delete batch
		
		/*
		 * Hibernate: delete from BOOK where BOOK_ID=? or BOOK_ID=? or BOOK_ID=?
		 */
		repository.deleteInBatch(repository.findAll(new ArrayList<Long>() {
			{
				add(4L);
				add(5L);
				add(6L);
			}
		}));
		
		// delete all in batch
		/*
		 *  Hibernate: delete from BOOK
		 */
		repository.deleteAllInBatch();
		
		
		// read only repo
		
		System.out.println("--- read only repo ---");
		
		BookReadOnlyRepository readonlyRepo = context.getBean(BookReadOnlyRepository.class);
		System.out.println(readonlyRepo.findAll());
		
	}
}
