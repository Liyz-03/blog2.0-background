package com.hiworlds.bbblog.domain;

import java.util.Date;

public class Log {
    private int log_id;
    private String log_content;
    private Date log_time;

    @Override
    public String toString() {
        return "Log{" + "log_id=" + log_id + ", log_content='" + log_content + '\'' + ", log_time=" + log_time + '}';
    }

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public String getLog_content() {
        return log_content;
    }

    public void setLog_content(String log_content) {
        this.log_content = log_content;
    }

    public Date getLog_time() {
        return log_time;
    }

    public void setLog_time(Date log_time) {
        this.log_time = log_time;
    }

    public Log() {
    }

    public Log(int log_id, String log_content, Date log_time) {
        this.log_id = log_id;
        this.log_content = log_content;
        this.log_time = log_time;
    }
}
