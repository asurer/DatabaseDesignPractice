package com.situ.springboot.util;

import com.situ.springboot.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/*
封装分页相关的信息
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo {
    //当前页的数据集合
    private List<User> list;
    //一共多少页
    private Integer totalPage;
    //当前页号
    private Integer pageNo;
    //一页多少数据
    private Integer pageSize;
}
