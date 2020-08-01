package com.hiworlds.bbblog.domain.admin;

public class LogcaicaiCity {
    private String logcaicai_city;
    private String total;

    public LogcaicaiCity() {
    }

    public LogcaicaiCity(String logcaicai_city, String total) {
        this.logcaicai_city = logcaicai_city;
        this.total = total;
    }

    public String getLogcaicai_city() {
        return logcaicai_city;
    }

    public void setLogcaicai_city(String logcaicai_city) {
        this.logcaicai_city = logcaicai_city;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "LogcaicaiCity{" + "logcaicai_city='" + logcaicai_city + '\'' + ", total='" + total + '\'' + '}';
    }
}
