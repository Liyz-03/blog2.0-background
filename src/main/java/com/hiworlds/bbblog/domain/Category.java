package com.hiworlds.bbblog.domain;

import java.util.Date;

public class Category {
    //category_id  category_name  category_create_time
    private int category_id;
    private String category_name;
    private Date category_create_time;


    @Override
    public String toString() {
        return "Category{" + "category_id=" + category_id + ", category_name='" + category_name + '\'' + ", category_create_time=" + category_create_time + '}';
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Date getCategory_create_time() {
        return category_create_time;
    }

    public void setCategory_create_time(Date category_create_time) {
        this.category_create_time = category_create_time;
    }

    public Category() {
    }

    public Category(int category_id, String category_name, Date category_create_time) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_create_time = category_create_time;
    }
}
