package com.ranga.spring.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> findByPageCountEquals(int pageCount);

	public List<Book> findByPageCountGreaterThan(int pageCount);

	public List<Book> findByPageCountGreaterThanEqual(int pageCount);

	public List<Book> findByPageCountLessThan(int pageCount);

	public List<Book> findByPageCountBetween(int min, int max);

}
