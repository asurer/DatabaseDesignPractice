package com.situ.springboot.mapper;

import com.situ.springboot.pojo.User;

import java.util.List;
//IUserDao
public interface UserMapper {
    List<User> selectAll();
    void deleteById(Integer id);

    void add(User user);

    User selectById(Integer id);

    void update(User user);

    User login(String name, String password);

    List<User> selectByPage(int offset, Integer pageSize);

    int selectTotalCount();
}
