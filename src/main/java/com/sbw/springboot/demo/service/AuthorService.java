package com.sbw.springboot.demo.service;

import com.sbw.springboot.demo.domain.Author;

import java.util.List;

/**
 * Created by sbw on 2017/11/30.
 */
public interface AuthorService {

    int add(Author author);

    int update(Author author);

    int delete(Long id);

    Author findAuthor(Long id);

    List<Author> findAuthorList();
}