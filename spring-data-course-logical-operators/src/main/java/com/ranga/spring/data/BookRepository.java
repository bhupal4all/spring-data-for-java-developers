package com.ranga.spring.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> findByTitleContainingOrTitleContaining(String title, String title2);
	
	public List<Book> findByTitleContainingAndPageCountGreaterThan(String title, int pageCount);
	
	public List<Book> findByTitleNot(String title);

	
	
}
