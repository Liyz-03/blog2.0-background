package com.hiworlds.bbblog.domain;

import java.util.Date;

public class User {
    private int user_id;
    private String user_name;
    private String user_role;
    private String user_email;
    private String user_password;
    private String user_blog;
    private boolean user_is_forbid;
    private Date user_create_time;
    private String user_headimg;

    public User(int user_id, String user_name, String user_role, String user_email, String user_password, String user_blog, boolean user_is_forbid, Date user_create_time, String user_headimg) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_role = user_role;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_blog = user_blog;
        this.user_is_forbid = user_is_forbid;
        this.user_create_time = user_create_time;
        this.user_headimg = user_headimg;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", user_name='" + user_name + '\'' + ", user_role='" + user_role + '\'' + ", user_email='" + user_email + '\'' + ", user_password='" + user_password + '\'' + ", user_blog='" + user_blog + '\'' + ", user_is_forbid=" + user_is_forbid + ", user_create_time=" + user_create_time + ", user_headimg='" + user_headimg + '\'' + '}';
    }

    public String getUser_headimg() {
        return user_headimg;
    }

    public void setUser_headimg(String user_headimg) {
        this.user_headimg = user_headimg;
    }

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_blog() {
        return user_blog;
    }

    public void setUser_blog(String user_blog) {
        this.user_blog = user_blog;
    }

    public boolean isUser_is_forbid() {
        return user_is_forbid;
    }

    public void setUser_is_forbid(boolean user_is_forbid) {
        this.user_is_forbid = user_is_forbid;
    }

    public Date getUser_create_time() {
        return user_create_time;
    }

    public void setUser_create_time(Date user_create_time) {
        this.user_create_time = user_create_time;
    }

}
