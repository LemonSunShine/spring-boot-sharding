package com.sbw.springboot.demo.domain;

/**
 * 用于jdbcTemplate数据交互的对象
 * Created by sbw on 2017/11/30.
 */
public class Author {
    private Long id;
    private String realName;
    private String nickName;

    public Author(){}

    public Author(String realName, String nickName){
        this.realName = realName;
        this.nickName = nickName;
    }

    public Author(Long id, String realName, String nickName) {
        this.id = id;
        this.realName = realName;
        this.nickName = nickName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}