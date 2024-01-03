package com.situ.springboot.service.impl;

import com.situ.springboot.mapper.UserMapper;
import com.situ.springboot.pojo.entity.User;
import com.situ.springboot.service.IUserService;
import com.situ.springboot.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//Alt+Enter快速修复一些错误
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    //业务
    @Override
    public List<User> selectAll() {
        List<User> list = userMapper.selectAll();
        for(User user : list) {
            user.setName("situ-" + user.getName());
        }
        return list;
    }

    @Override
    public void deleteById(Integer id) {
            userMapper.deleteById(id);
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User login(String name, String password) {
        return userMapper.login(name, password);
    }

    //totalCount:101
    //pageSize:10
    @Override
    public PageInfo selectByPage(Integer pageNo, Integer pageSize) {
        int offset = (pageNo - 1) * pageSize;
        List<User> list = userMapper.selectByPage(offset, pageSize);
        int totalCount = userMapper.selectTotalCount();
        int totalPage = (int)Math.ceil((double)totalCount / pageSize);
        return new PageInfo(list, totalPage, pageNo, pageSize);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        userMapper.deleteAll(ids);
    }
}


