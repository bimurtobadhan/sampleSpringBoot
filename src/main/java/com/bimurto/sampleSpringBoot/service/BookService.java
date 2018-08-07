package com.bimurto.sampleSpringBoot.service;

import com.bimurto.sampleSpringBoot.api.model.BookRequest;
import com.bimurto.sampleSpringBoot.domain.Book;

import java.util.List;

/**
 * Created by Shawrup on 07-Aug-18.
 */
public interface BookService {
    Book getBook(Long id);

    List<Book> getBookList();

    void createBook(BookRequest request);
}
