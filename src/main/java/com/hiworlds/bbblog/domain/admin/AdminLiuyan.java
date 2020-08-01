package com.hiworlds.bbblog.domain.admin;

import java.util.Date;

public class AdminLiuyan {
    private String user_name;
    private String user_role;
    private String user_email;
    private String user_blog;
    private int liuyan_id;
    private String liuyan_content;
    private Date liuyan_time;

    public AdminLiuyan() {
    }

    public AdminLiuyan(String user_name, String user_role, String user_email, String user_blog, int liuyan_id, String liuyan_content, Date liuyan_time) {
        this.user_name = user_name;
        this.user_role = user_role;
        this.user_email = user_email;
        this.user_blog = user_blog;
        this.liuyan_id = liuyan_id;
        this.liuyan_content = liuyan_content;
        this.liuyan_time = liuyan_time;
    }

    @Override
    public String toString() {
        return "AdminLiuyan{" + "user_name='" + user_name + '\'' + ", user_role='" + user_role + '\'' + ", user_email='" + user_email + '\'' + ", user_blog='" + user_blog + '\'' + ", liuyan_id=" + liuyan_id + ", liuyan_content='" + liuyan_content + '\'' + ", liuyan_time=" + liuyan_time + '}';
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

    public String getUser_blog() {
        return user_blog;
    }

    public void setUser_blog(String user_blog) {
        this.user_blog = user_blog;
    }

    public int getLiuyan_id() {
        return liuyan_id;
    }

    public void setLiuyan_id(int liuyan_id) {
        this.liuyan_id = liuyan_id;
    }

    public String getLiuyan_content() {
        return liuyan_content;
    }

    public void setLiuyan_content(String liuyan_content) {
        this.liuyan_content = liuyan_content;
    }

    public Date getLiuyan_time() {
        return liuyan_time;
    }

    public void setLiuyan_time(Date liuyan_time) {
        this.liuyan_time = liuyan_time;
    }
}
