package com.hiworlds.bbblog.domain.home;

import java.util.Date;

public class HomeLiuyan {
    //liuyan_id  liuyan_content  liuyan_time  //user_id user_name user_email  user_blog
    private int liuyan_id;
    private String liuyan_content;
    private Date liuyan_time;
    private int user_id;
    private String user_name;
    private String user_blog;
    private String user_headimg;
    private String user_role;

    public HomeLiuyan(int liuyan_id, String liuyan_content, Date liuyan_time, int user_id, String user_name, String user_blog, String user_headimg, String user_role) {
        this.liuyan_id = liuyan_id;
        this.liuyan_content = liuyan_content;
        this.liuyan_time = liuyan_time;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_blog = user_blog;
        this.user_headimg = user_headimg;
        this.user_role = user_role;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    @Override
    public String toString() {
        return "HomeLiuyan{" + "liuyan_id=" + liuyan_id + ", liuyan_content='" + liuyan_content + '\'' + ", liuyan_time=" + liuyan_time + ", user_id=" + user_id + ", user_name='" + user_name + '\'' + ", user_blog='" + user_blog + '\'' + ", user_headimg='" + user_headimg + '\'' + ", user_role='" + user_role + '\'' + '}';
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

    public String getUser_blog() {
        return user_blog;
    }

    public void setUser_blog(String user_blog) {
        this.user_blog = user_blog;
    }

    public String getUser_headimg() {
        return user_headimg;
    }

    public void setUser_headimg(String user_headimg) {
        this.user_headimg = user_headimg;
    }

    public HomeLiuyan() {
    }
}
