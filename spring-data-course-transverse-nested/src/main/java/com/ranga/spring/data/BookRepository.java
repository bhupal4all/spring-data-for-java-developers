package com.ranga.spring.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> findByAuthorFirstName(String firstName);
	
	public List<Book> findByAuthor_Country(String country);
}
