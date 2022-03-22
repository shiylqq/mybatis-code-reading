package org.shi.code.reading.mybatis.test1;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.shi.code.reading.mybatis.test1.mapper.BookMapper;
import org.shi.code.reading.mybatis.test1.pojo.Book;

import java.io.IOException;

public class AddTest {
    public static void main(String[] args) throws IOException {
        SqlSessionFactory sessionFactory = MyTest1.getSqlSessionFactory();
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            Book book = new Book();
            book.setName("MyBatis3源码深度解析");
            book.setPrice(70);
            bookMapper.add(book);
            sqlSession.commit();
        }
    }
}
