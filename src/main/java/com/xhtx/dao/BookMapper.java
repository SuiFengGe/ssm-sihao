package com.xhtx.dao;

import com.xhtx.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("bookID") int id);

    //更新一本书的信息
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(@Param("bookID") int id);

    //查询全部的书
    List<Books> queryAllBook();



    //重置id
    int resetID1();

    //重置id
    int resetID2();

    //查询总记录数
    int findTotalCount();
    //分页查询
    List<Books> tenCount(int startRow);

    //查询模糊查询总记录数
    int queryBookByLikeName(@Param("bookName") String bookName);

    //模糊查询结果分页展示
    List<Books> tenResult(@Param("bookName") String bookName, @Param("startRow") int startRow);




}
