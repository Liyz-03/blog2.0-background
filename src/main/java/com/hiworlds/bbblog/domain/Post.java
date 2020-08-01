package com.hiworlds.bbblog.domain;

import java.util.Date;

public class Post {
    private int post_id;
    private String post_title;
    private String post_description;
    private int post_author_id;
    private String user_name;
    private Date post_create_time;
    private Date post_public_time;
    private Boolean post_is_draft;
    private String post_content;
    private int post_category_id;
    private String category_name;

    public Post() {
    }

    public Post(int post_id, String post_title, String post_description, int post_author_id, String user_name, Date post_create_time, Date post_public_time, Boolean post_is_draft, String post_content, int post_category_id, String category_name) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.post_description = post_description;
        this.post_author_id = post_author_id;
        this.user_name = user_name;
        this.post_create_time = post_create_time;
        this.post_public_time = post_public_time;
        this.post_is_draft = post_is_draft;
        this.post_content = post_content;
        this.post_category_id = post_category_id;
        this.category_name = category_name;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_description() {
        return post_description;
    }

    public void setPost_description(String post_description) {
        this.post_description = post_description;
    }

    public int getPost_author_id() {
        return post_author_id;
    }

    public void setPost_author_id(int post_author_id) {
        this.post_author_id = post_author_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getPost_create_time() {
        return post_create_time;
    }

    public void setPost_create_time(Date post_create_time) {
        this.post_create_time = post_create_time;
    }

    public Date getPost_public_time() {
        return post_public_time;
    }

    public void setPost_public_time(Date post_public_time) {
        this.post_public_time = post_public_time;
    }

    public Boolean getPost_is_draft() {
        return post_is_draft;
    }

    public void setPost_is_draft(Boolean post_is_draft) {
        this.post_is_draft = post_is_draft;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public int getPost_category_id() {
        return post_category_id;
    }

    public void setPost_category_id(int post_category_id) {
        this.post_category_id = post_category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Post{" + "post_id=" + post_id + ", post_title='" + post_title + '\'' + ", post_description='" + post_description + '\'' + ", post_author_id=" + post_author_id + ", user_name='" + user_name + '\'' + ", post_create_time=" + post_create_time + ", post_public_time=" + post_public_time + ", post_is_draft=" + post_is_draft + ", post_content='" + post_content + '\'' + ", post_category_id=" + post_category_id + ", category_name='" + category_name + '\'' + '}';
    }
}
