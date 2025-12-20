package com.zqp.controller;

import com.github.pagehelper.PageInfo;
import com.zqp.pojo.User;
import com.zqp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAllUsers(){
        System.out.println("查询所有用户!");
        //int i = 10/0;
        return userService.findAllUsers();
    }
    @GetMapping("/findOne/{id}")
    @ResponseBody
    public User findOneUser(@PathVariable Integer id){
        return userService.findUserById(id);
    }
    @PostMapping("/insert")
    @ResponseBody
    public int insertUser(@RequestBody User user){
        return userService.insertUser(user);
    }
    @PutMapping("/update")
    @ResponseBody
    public int updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @Transactional(propagation= Propagation.REQUIRED)//添加事务
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public int deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }
    @GetMapping("/find/list")
    @ResponseBody
    public PageInfo< User> findAllUser(Integer pageNum, Integer pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }
}
