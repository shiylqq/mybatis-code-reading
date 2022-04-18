package org.shi.code.reading.mybatis.test1.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.shi.code.reading.mybatis.test1.pojo.Book;

import java.util.List;
//开启或关闭二级缓存
//@CacheNamespace
public interface BookMapper {
        @Options
        @Select("SELECT * FROM book WHERE id = #{id}")
        Book selectBook(int id);

        @Insert("insert into book(name, price) value (#{name}, #{price});")
        int add(Book book);

        @Select("select * from book")
        List<Book> getAll(RowBounds rowBounds);
}
