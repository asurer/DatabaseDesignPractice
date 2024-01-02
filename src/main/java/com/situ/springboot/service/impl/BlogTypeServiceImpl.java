package com.situ.springboot.service.impl;

import com.situ.springboot.mapper.BlogTypeMapper;
import com.situ.springboot.pojo.vo.BlogTypeCountVO;
import com.situ.springboot.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTypeServiceImpl implements IBlogTypeService {

    @Autowired
    private BlogTypeMapper blogTypeMapper;

    @Override
    public List<BlogTypeCountVO> selectBlogTypeCount() {
        return blogTypeMapper.selectBlogTypeCount();
    }
}