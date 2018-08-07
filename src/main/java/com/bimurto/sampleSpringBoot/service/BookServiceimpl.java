package com.bimurto.sampleSpringBoot.service;

import com.bimurto.sampleSpringBoot.api.model.BookRequest;
import com.bimurto.sampleSpringBoot.dao.BookDao;
import com.bimurto.sampleSpringBoot.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shawrup on 07-Aug-18.
 */
@Service
public class BookServiceImpl implements BookService{

    private final BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Book getBook(Long id) {
        return bookDao.getBookbyId(id);
    }

    @Override
    public List<Book> getBookList() {
        return bookDao.getBookList();
    }

    @Override
    public void createBook(BookRequest request) {
        Book book = Book.builder()
                .name(request.getName())
                .author(request.getAuthor())
                .build();
        bookDao.save(book);
    }
}
