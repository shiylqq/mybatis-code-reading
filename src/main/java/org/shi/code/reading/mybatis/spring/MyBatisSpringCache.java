package org.shi.code.reading.mybatis.spring;

import org.shi.code.reading.mybatis.pure.pojo.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBatisSpringCache {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        Service service = (Service) context.getBean("service");

        Book book = service.getBook(1);
        System.out.println(book);
        Book book1 = service.getBook(1);
        System.out.println(book1);
    }
}
