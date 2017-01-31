package com.ranga.spring.data;

import org.springframework.stereotype.Repository;

@Repository
public interface BookReadOnlyRepository extends ReadOnlyRepository<Book, Long> {
}
