package com.ohgiraffers.section04.construction;

import java.util.Date;

public class User {
    private String id;
    private String pwd;
    private String name;
    private java.util.Date enrollDate;

    public User() {
        System.out.println("User 객체 생성 됩니다!~");
    }

    public User(String id, String pwd, String name, Date enrollDate) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.enrollDate = enrollDate;
    }

    public String forInformation() {
        return this.id + ", " +this.pwd + ", "+ this.name + ", " + this.enrollDate;
    }
}
