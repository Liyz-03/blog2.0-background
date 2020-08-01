package com.hiworlds.bbblog.domain;


import java.util.Date;

public class CaiCai {
    private int logcaicai_id;
    private String logcaicai_ip;
    private String logcaicai_city;
    private String logcaicai_browser;
    private Date logcaicai_time;

    public CaiCai() {
    }

    public CaiCai(int logcaicai_id, String logcaicai_ip, String logcaicai_city, String logcaicai_browser, Date logcaicai_time) {
        this.logcaicai_id = logcaicai_id;
        this.logcaicai_ip = logcaicai_ip;
        this.logcaicai_city = logcaicai_city;
        this.logcaicai_browser = logcaicai_browser;
        this.logcaicai_time = logcaicai_time;
    }

    public int getLogcaicai_id() {
        return logcaicai_id;
    }

    public void setLogcaicai_id(int logcaicai_id) {
        this.logcaicai_id = logcaicai_id;
    }

    public String getLogcaicai_ip() {
        return logcaicai_ip;
    }

    public void setLogcaicai_ip(String logcaicai_ip) {
        this.logcaicai_ip = logcaicai_ip;
    }

    public String getLogcaicai_city() {
        return logcaicai_city;
    }

    public void setLogcaicai_city(String logcaicai_city) {
        this.logcaicai_city = logcaicai_city;
    }

    public String getLogcaicai_browser() {
        return logcaicai_browser;
    }

    public void setLogcaicai_browser(String logcaicai_browser) {
        this.logcaicai_browser = logcaicai_browser;
    }

    public Date getLogcaicai_time() {
        return logcaicai_time;
    }

    public void setLogcaicai_time(Date logcaicai_time) {
        this.logcaicai_time = logcaicai_time;
    }

    @Override
    public String toString() {
        return "CaiCai{" + "logcaicai_id=" + logcaicai_id + ", logcaicai_ip='" + logcaicai_ip + '\'' + ", logcaicai_city='" + logcaicai_city + '\'' + ", logcaicai_browser='" + logcaicai_browser + '\'' + ", logcaicai_time=" + logcaicai_time + '}';
    }
}
