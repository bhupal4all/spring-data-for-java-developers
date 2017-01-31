package com.ranga.spring.data;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends BaseRepository<Book, Long>, BookRepositoryCustom {

	public List<Book> findByPageCountGreaterThan(int pageCount, Pageable pageable);

}
