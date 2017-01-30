package com.ranga.spring.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> findByPublishDateAfter(Date date);	
	
	public List<Book> findByPublishDateBefore(Date date);
	
	public List<Book> findByPublishDateBetween(Date date1, Date date2);
	
	
	
}
