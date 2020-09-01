package com.zhanziwei.test;

import com.zhanziwei.bean.Book;
import com.zhanziwei.dao.BookDao;
import com.zhanziwei.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "shuming", "作者", new BigDecimal(999), 1111111, 111, null));
    }

    @Test
    public void deleteBook() {
        bookDao.deleteBook(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "gggggggg", "作者", new BigDecimal(999), 1111111, 222, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        System.out.println(bookDao.queryBooks());
    }
}