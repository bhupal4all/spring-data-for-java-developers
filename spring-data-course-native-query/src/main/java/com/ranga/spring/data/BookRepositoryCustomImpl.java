package com.ranga.spring.data;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookRepositoryCustomImpl implements BookRepositoryCustom {

	private static Logger logger = LoggerFactory.getLogger(BookRepositoryCustomImpl.class);
	
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public void saveAndLog(Book book) {
		logger.trace("entering");
		
		logger.debug("saving book "+book);
		System.out.println("saving book "+book);
		entityManager.persist(book);
		
		logger.trace("exit");
	}
}
