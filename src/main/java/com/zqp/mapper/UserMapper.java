package com.zqp.mapper;

import com.zqp.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAllUsers();
    User selectUserById(Integer id);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(int id);

}
