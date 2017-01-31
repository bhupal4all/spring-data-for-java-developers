package com.ranga.spring.data;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends BaseRepository<Book, Long>, BookRepositoryCustom {

	@Transactional
	@Modifying
	@Query("update Book b set b.pageCount = ?2 where b.title like ?1")
	public int updateBookPageCount(String title, int pageCount);

}
