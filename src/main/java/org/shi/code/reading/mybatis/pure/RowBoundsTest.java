package org.shi.code.reading.mybatis.pure;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.shi.code.reading.mybatis.pure.mapper.BookMapper;
import org.shi.code.reading.mybatis.pure.pojo.Book;

import java.io.IOException;
import java.util.List;

public class RowBoundsTest {

    public static void main(String[] args) throws IOException {
        SqlSessionFactory sessionFactory = QueryTest.getSqlSessionFactory();
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            List<Book> bookList = bookMapper.getAll(new RowBounds(0, 2));
            System.out.println(bookList);
        }
    }
}
