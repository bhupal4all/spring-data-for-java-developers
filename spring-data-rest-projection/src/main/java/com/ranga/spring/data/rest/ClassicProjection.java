package com.ranga.spring.data.rest;

import org.springframework.data.rest.core.config.Projection;

import com.ranga.spring.data.Book;

@Projection(name="classic", types={Book.class})
public interface ClassicProjection {

	public String getTitle();

	public int getPageCount();
}
