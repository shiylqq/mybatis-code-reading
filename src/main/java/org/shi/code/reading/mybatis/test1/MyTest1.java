package org.shi.code.reading.mybatis.test1;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.shi.code.reading.mybatis.test1.mapper.BookMapper;
import org.shi.code.reading.mybatis.test1.pojo.Book;

import java.io.IOException;
import java.io.InputStream;

public class MyTest1 {
    public static void main(String[] args) throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            Book book = mapper.selectBook(1);
            System.out.println(book);
            Book book1 = mapper.selectBook(1);
            System.out.println(book1);
            Book book2 = mapper.selectBook(1);
            System.out.println(book2);
        }//在sqlSession调用Close方法时会根据当前事务情况选择二级缓存生效或丢弃




//        DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
//        TransactionFactory transactionFactory =
//                new JdbcTransactionFactory();
//        Environment environment =
//                new Environment("development", transactionFactory, dataSource);
//        Configuration configuration = new Configuration(environment);
//        configuration.addMapper(BlogMapper.class);
//        SqlSessionFactory sqlSessionFactory =
//                new SqlSessionFactoryBuilder().build(configuration);
    }

    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
}
