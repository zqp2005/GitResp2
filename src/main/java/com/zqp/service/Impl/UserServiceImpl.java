package com.zqp.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zqp.mapper.UserMapper;
import com.zqp.pojo.User;
import com.zqp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List< User>findAllUsers() {
        return userMapper.selectAllUsers();
    }
    @Override
    public User findUserById(Integer id) {
        return userMapper.selectUserById(id);
    }
    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }
    @Override
    public PageInfo< User> findAllUser(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> users= userMapper.selectAllUsers();
        PageInfo< User> info=new PageInfo<>(users);
        return info;
    }
}
