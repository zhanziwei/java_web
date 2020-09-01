package com.zhanziwei.dao;

import com.zhanziwei.bean.Book;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);
    public int deleteBook(Integer id);
    public int updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();
}
