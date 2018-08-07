package com.bimurto.sampleSpringBoot.api;

import com.bimurto.sampleSpringBoot.api.model.BookRequest;
import com.bimurto.sampleSpringBoot.domain.Book;
import com.bimurto.sampleSpringBoot.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Shawrup on 07-Aug-18.
 */
@Slf4j
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    public Book getUser(@PathVariable Long id){
        return bookService.getBook(id);
    }

    @RequestMapping(value = "/api/user/list", method = RequestMethod.GET)
    public List<Book> getUserList(@PathVariable Long id){
        return bookService.getBookList();
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public void getUserList(@RequestBody @Valid BookRequest request){
        log.info("Request {}", request);
        bookService.createBook(request);
    }
}
