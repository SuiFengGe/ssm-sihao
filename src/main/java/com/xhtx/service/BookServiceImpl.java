package com.xhtx.service;

import com.xhtx.dao.BookMapper;
import com.xhtx.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{
    //service调到层：组合Dao
    private BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }



    @Override
    public int resetID1() {
        return bookMapper.resetID1();
    }

    @Override
    public int resetID2() {
        return bookMapper.resetID2();
    }

    @Override
    public int findTotalCount() {
        return bookMapper.findTotalCount();
    }

    @Override
    public int queryBookByLikeName(String bookName) {
        return bookMapper.queryBookByLikeName(bookName);
    }

    @Override
    public List<Books> tenResult(String bookName,int startRow) {
        return bookMapper.tenResult(bookName,startRow);
    }

    @Override
    public List<Books> tenCount(int startRow) {
        return bookMapper.tenCount(startRow);
    }
}
