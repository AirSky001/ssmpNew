package com.itheima.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private IBookService bookService;
    @Test
    void selectById() {
        System.out.println(bookService.getById(2));
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper();
        lqw.like(Book::getName, "%spring%");
        bookService.list(lqw);
    }

    @Test
    void getPage() {
        IPage<Book> page = bookService.getPage(2, 4);
        System.out.println(page.getRecords());
    }
}
