package com.hiworlds.bbblog.utils;


import java.util.HashMap;
import java.util.Map;

public class MyResponseJson {

    /**
     * 返回成功数据
     *
     * @param data
     * @param msg
     * @return
     */
    public static Map responseSuccessWithData(Object data, String msg) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("data", data);
        map.put("msg", msg);
        return map;
    }

    public static Map responseSuccessNoData(String msg) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("data", null);
        map.put("msg", msg);
        return map;
    }

    /**
     * 返回失败数据
     *
     * @param data
     * @param msg
     * @return
     */
    public static Map responseFailedWithData(Object data, String msg) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 400);
        map.put("data", data);
        map.put("msg", msg);
        return map;
    }

    public static Map responseFailedNoData(String msg) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 400);
        map.put("data", null);
        map.put("msg", msg);
        return map;
    }
}
