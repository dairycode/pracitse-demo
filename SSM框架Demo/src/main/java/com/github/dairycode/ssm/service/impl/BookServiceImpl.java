package com.github.dairycode.ssm.service.impl;

import com.github.dairycode.ssm.mapper.BookMapper;
import com.github.dairycode.ssm.pojo.Books;
import com.github.dairycode.ssm.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    // service 调 mapper层: 组合 mapper
    private BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBooks() {
        return bookMapper.queryAllBooks();
    }

    public Books queryBookName(String bookName) {
        return bookMapper.queryBookName(bookName);
    }
}
