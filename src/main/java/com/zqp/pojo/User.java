package com.zqp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor

public class User implements Serializable {
    private Integer id;
    private String uname;
    private String pwd;
    private String realname;
    private int identity;

    public User(Integer id, String uname, String pwd, String realname, int identity) {
        this.id = id;
        this.uname = uname;
        this.pwd = pwd;
        this.realname = realname;
        this.identity = identity;
    }
    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }
}
