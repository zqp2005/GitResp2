package com.zqp.service;

import com.github.pagehelper.PageInfo;
import com.zqp.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserById(Integer id);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(Integer id);
    PageInfo< User> findAllUser(Integer pageNum, Integer pageSize);
}
