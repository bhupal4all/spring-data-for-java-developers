package com.ranga.spring.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> findByTitleContainingOrderByTitleAsc(String title);

	public List<Book> findByTitleContainingOrderByTitleDesc(String title);

	public List<Book> findTopByOrderByPageCountDesc();

	public List<Book> findFirstByOrderByPageCountAsc();

	public List<Book> findTop3ByOrderByPageCountDesc();
	
	public List<Book> findTop3ByTitleOrderByPriceDesc(String title);
	
	public List<Book> findTop3ByTitleLikeIgnoreCaseOrderByPriceDesc(String title);
	
	public List<Book> findTop3ByTitleContainingOrderByPriceDesc(String title);
}
