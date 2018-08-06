package com.bimurto.sampleSpringBoot.dao;

import com.bimurto.sampleSpringBoot.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

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
}
