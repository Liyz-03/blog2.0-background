package com.hiworlds.bbblog.domain.admin;

public class PostTotal {
    private int allPost;
    private int draft;

    @Override
    public String toString() {
        return "PostTotal{" + "allPost=" + allPost + ", draft=" + draft + '}';
    }

    public int getAllPost() {
        return allPost;
    }

    public void setAllPost(int allPost) {
        this.allPost = allPost;
    }

    public int getDraft() {
        return draft;
    }

    public void setDraft(int draft) {
        this.draft = draft;
    }

    public PostTotal() {
    }

    public PostTotal(int allPost, int draft) {
        this.allPost = allPost;
        this.draft = draft;
    }
}