package com.xhtx.service;

import com.xhtx.dao.AuthorMapper;
import com.xhtx.pojo.Author;

public class AuthorServiceImpl implements AuthorService{
    private AuthorMapper authorMapper;

    public void setAuthorMapper(AuthorMapper authorMapper) {
        this.authorMapper = authorMapper;
    }

    @Override
    public Author getAuthorByID(int authorID) {
        return authorMapper.getAuthorByID(authorID);
    }
}
