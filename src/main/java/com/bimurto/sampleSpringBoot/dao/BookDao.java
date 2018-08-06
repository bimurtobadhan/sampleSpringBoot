package com.bimurto.sampleSpringBoot.dao;

import com.bimurto.sampleSpringBoot.domain.Book;

public interface BookDao {
    void save(Book book);

    Book getBookbyId(Long id);
}
