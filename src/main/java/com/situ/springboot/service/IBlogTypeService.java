package com.situ.springboot.service;

import com.situ.springboot.pojo.vo.BlogTypeCountVO;

import java.util.List;
public interface IBlogTypeService{
    List<BlogTypeCountVO> selectBlogTypeCount();
}
