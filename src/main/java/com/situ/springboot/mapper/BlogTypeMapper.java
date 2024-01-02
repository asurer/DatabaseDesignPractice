package com.situ.springboot.mapper;

import com.situ.springboot.pojo.vo.BlogTypeCountVO;

import java.util.List;

public interface BlogTypeMapper {
    List<BlogTypeCountVO> selectBlogTypeCount();
}
