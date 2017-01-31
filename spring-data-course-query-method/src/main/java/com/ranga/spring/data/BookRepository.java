package com.ranga.spring.data;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
//	public Collection<Book> findByPageCountGreaterThan(int pageCount);
	
//	public Iterable<Book> findByPageCountGreaterThan(int pageCount);
	
//	public Page<Book> findByPageCountGreaterThan(int pageCount, Pageable pageable);
	
	public Slice<Book> findByPageCountGreaterThan(int pageCount, Pageable pageable);
	
}
