package com.bimurto.sampleSpringBoot.dao;

import com.bimurto.sampleSpringBoot.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Repository
public class BookDaoImpl implements BookDao {

    private final EntityManager entityManager;

    @Autowired
    public BookDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Book book){
        entityManager.persist(book);
    }

    @Override
    public Book getBookbyId(Long id){
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> getBookList(){
        TypedQuery<Book> query = entityManager.createQuery("select * from Book b", Book.class);
        List<Book> bookList = query.getResultList();
        return bookList;
    }

    @Override
    public Book getBookByName(String name){
        TypedQuery<Book> query = entityManager.createQuery("from Book b where b.name=:name", Book.class);
        query.setParameter("name", name);
        Book book = query.getSingleResult();
        return book;
    }
}
