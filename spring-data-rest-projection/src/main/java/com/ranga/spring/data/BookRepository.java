package com.ranga.spring.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path="classics", collectionResourceRel="classics")
public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> findByTitle(@Param("title") String title);
	
	@RestResource(path="gtPageCount", rel="gtPageCount")
	public List<Book> findByPageCountGreaterThan(@Param("pageCount") int pageCount);
	
	@RestResource(exported=false)
	public List<Book> findByTitleNot(@Param("title") String title);
}
