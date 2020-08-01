package com.hiworlds.bbblog.utils;


import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;
import cz.mallat.uasparser.UserAgentInfo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserAgentUtil {

    static UASparser uasParser = null;

    static {
        try {
            uasParser = new UASparser(OnlineUpdater.getVendoredInputStream());
            // java.lang.UnsupportedClassVersionError:
            // cz/mallat/uasparser/UASparser : Unsupported major.minor version 51.0
            // 用jdk1.6测试时会报以上错，需要jdk1.7以上版本支持
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String,String> getUserAgentInfo(String userAgent){
        try {
            UserAgentInfo userAgentInfo = uasParser.parse(userAgent);
            HashMap<String, String> map = new HashMap<>();
            map.put("操作系统家族",userAgentInfo.getOsFamily());
            map.put("操作系统详细名称", userAgentInfo.getOsName());
            map.put("浏览器名称和版本", userAgentInfo.getUaName());
            map.put("类型", userAgentInfo.getType());
            if(userAgentInfo.getUaFamily().equals("Android Webkit" )){
                map.put("浏览器名称", "Android端");
            }else {
                map.put("浏览器名称", userAgentInfo.getUaFamily());
            }
            map.put("浏览器版本", userAgentInfo.getBrowserVersionInfo());
            map.put("设备类型", userAgentInfo.getDeviceType());
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

