package com.hiworlds.bbblog.domain;


import org.springframework.stereotype.Component;

import java.io.Serializable;

public class Dbtest implements Serializable {
    private int id;
    private String content;

    @Override
    public String toString() {
        return "Dbtest{" + "id=" + id + ", content='" + content + '\'' + '}';
    }

    public Dbtest() {
    }

    public Dbtest(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
