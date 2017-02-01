package com.ranga.spring.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends BaseRepository<Book, Long>, BookRepositoryCustom {

	@Query(value = "select book.* from book where book.title = :title", nativeQuery = true)
	public Book fireNativeQuery(@Param("title") String title);

	@Query(value = "select book.PAGE_COUNT from book where book.title = :title", nativeQuery = true)
	public int fireNativeQuery2(@Param("title") String title);
	
	@Query(value = "select book.BOOK_ID, book.PAGE_COUNT, book.PUBLISH_DATE, author.FIRST_NAME from book, author where book.author_id = author.author_id and  book.title = :title", nativeQuery = true)
	public Object[][] fireNativeQuery3(@Param("title") String title);
	
	@Query(value = "select book.BOOK_ID, book.PAGE_COUNT, book.PUBLISH_DATE, author.FIRST_NAME from book, author where book.author_id = author.author_id and  book.title = :title", nativeQuery = true)
	public List<String[]>fireNativeQuery4(@Param("title") String title);

}
