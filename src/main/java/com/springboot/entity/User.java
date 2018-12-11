package com.springboot.entity;

import javax.persistence.*;

@Table(name = "user")
public class User {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "userName")
    private String username;

    /**
     * 密码
     */
    private String pass;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return userName - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码
     *
     * @return pass - 密码
     */
    public String getPass() {
        return pass;
    }

    /**
     * 设置密码
     *
     * @param pass 密码
     */
    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    @Override
    public String toString(){
        return "[ userName: " + this.username + " pass: " + this.pass + " ]";
    }
}