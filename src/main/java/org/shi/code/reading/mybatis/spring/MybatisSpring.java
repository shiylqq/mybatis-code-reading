package org.shi.code.reading.mybatis.spring;

import org.shi.code.reading.mybatis.pure.pojo.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        Service service = (Service) context.getBean("service");

//        service.getBook(1);
        Book book = new Book();
        book.setPrice(50);
        book.setName("java常用算法手册");
        service.addBook(book);
        System.out.println("添加完成");

    }
}
