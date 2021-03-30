package com.xhtx.dao;

import com.xhtx.pojo.Author;
import org.apache.ibatis.annotations.Param;

public interface AuthorMapper {
    Author getAuthorByID(@Param("aid") int authorID);
}
