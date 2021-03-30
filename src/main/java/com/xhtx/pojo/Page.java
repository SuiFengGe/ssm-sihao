package com.xhtx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
    //总记录数
    private int totalCount;
    //总页码
    private int totalPage;
    //每页的数据
    private List<T> list;
    //当前页码
    private int currentPage;
    //当前记录数
    private int startRow;


}
