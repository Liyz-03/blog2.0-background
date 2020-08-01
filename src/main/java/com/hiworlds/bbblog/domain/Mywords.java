package com.hiworlds.bbblog.domain;

public class Mywords {
    private int mywords_id;
    private String mywords_content;

    @Override
    public String toString() {
        return "Mywords{" + "mywords_id=" + mywords_id + ", mywords_content='" + mywords_content + '\'' + '}';
    }

    public int getMywords_id() {
        return mywords_id;
    }

    public void setMywords_id(int mywords_id) {
        this.mywords_id = mywords_id;
    }

    public String getMywords_content() {
        return mywords_content;
    }

    public void setMywords_content(String mywords_content) {
        this.mywords_content = mywords_content;
    }

    public Mywords() {
    }

    public Mywords(int mywords_id, String mywords_content) {
        this.mywords_id = mywords_id;
        this.mywords_content = mywords_content;
    }
}
