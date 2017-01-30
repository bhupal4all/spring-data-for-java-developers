package com.ranga.spring.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	// select book0_.BOOK_ID as BOOK_ID1_0_, book0_.PAGE_COUNT as PAGE_COU2_0_,
	// book0_.PRICE as PRICE3_0_, book0_.PUBLISH_DATE as PUBLISH_4_0_,
	// book0_.TITLE as TITLE5_0_
	// from BOOK book0_
	// where book0_.TITLE=?
	public Book findByTitle(String title);
	
	public List<Book> findByTitleLike(String title);
	
	public List<Book> findByTitleContaining(String title);
	
	public List<Book> findByTitleStartingWith(String title);
	
	public List<Book> findByTitleEndingWith(String title);
	
	public List<Book> findByTitleIgnoreCase(String title);
}
