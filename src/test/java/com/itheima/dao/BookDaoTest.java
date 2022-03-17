package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTest {
    @Autowired
    private BookDao bookDao;

    @Test
    void selectById() {
        System.out.println(bookDao.selectById(2));
    }

    @Test
    void selectAll() {
        bookDao.selectList(null);
    }

    @Test
    void selectPage() {
        IPage<Book> page = new Page<>(2,5);
        IPage<Book> iPage = bookDao.selectPage(page, null);
        System.out.println(iPage.getCurrent());
        System.out.println(iPage.getSize());
        System.out.println(iPage.getTotal());
        System.out.println(iPage.getPages());//可分成几页
        System.out.println(iPage.getRecords());
    }


//    按条件查询
    @Test
    void selectByCondition() {
        String name = "1";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name!=null,Book::getName,"%spring%");//添加条件
        bookDao.selectList(lqw);
    }

}
