package com.ranga.spring.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	// STS might give you error at below methods saying that invalid derived query
	// you can ignore these as these are coming from STS
	// apllication would run as we expected
	
	public List<Book> queryAllBooks();
	
	public List<Book> queryBooks2(int pageCount);
	
	public List<Book> queryBooks3(@Param("title") String title);
}
