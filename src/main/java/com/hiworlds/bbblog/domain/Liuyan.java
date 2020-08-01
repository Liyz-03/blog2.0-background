package com.hiworlds.bbblog.domain;

import java.util.Date;

public class Liuyan {
    private int liuyan_id;
    private String liuyan_content;
    private int liuyan_user_id;
    private Date liuyan_time;

    @Override
    public String toString() {
        return "Liuyan{" + "liuyan_id=" + liuyan_id + ", liuyan_content='" + liuyan_content + '\'' + ", liuyan_user_id=" + liuyan_user_id + ", liuyan_time=" + liuyan_time + '}';
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

    public int getLiuyan_user_id() {
        return liuyan_user_id;
    }

    public void setLiuyan_user_id(int liuyan_user_id) {
        this.liuyan_user_id = liuyan_user_id;
    }

    public Date getLiuyan_time() {
        return liuyan_time;
    }

    public void setLiuyan_time(Date liuyan_time) {
        this.liuyan_time = liuyan_time;
    }

    public Liuyan() {
    }

    public Liuyan(int liuyan_id, String liuyan_content, int liuyan_user_id, Date liuyan_time) {
        this.liuyan_id = liuyan_id;
        this.liuyan_content = liuyan_content;
        this.liuyan_user_id = liuyan_user_id;
        this.liuyan_time = liuyan_time;
    }
}
