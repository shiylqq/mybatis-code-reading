package org.shi.code.reading.mybatis.spring;

import org.shi.code.reading.mybatis.test1.mapper.BookMapper;
import org.shi.code.reading.mybatis.test1.pojo.Book;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class Service {
    @Resource
    private BookMapper bookMapper;

    public Book getBook(Integer id){
        Book book = bookMapper.selectBook(id);
        //System.out.println(book);
        return book;
    }

    @Transactional
    public void addBook(Book book){
        bookMapper.add(book);
    }
}
