package com.sbw.springboot.demo.jpa.entity;

import javax.persistence.*;

/**
 * Created by sbw on 2017/11/30.
 */
@Entity
@Table(name = "t_teacher")
public class Teacher{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="real_name")
    private String realName;

    @Column(name="nick_name")
    private String nickName;

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
