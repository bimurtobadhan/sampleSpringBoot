package com.bimurto.sampleSpringBoot.dao;

import com.bimurto.sampleSpringBoot.domain.Book;

import java.util.List;

public interface BookDao {
    void save(Book book);

    Book getBookbyId(Long id);

    List<Book> getBookList();

    Book getBookByName(String name);
}
