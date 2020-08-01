package com.hiworlds.bbblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiworlds.bbblog.domain.CaiCai;
import com.hiworlds.bbblog.domain.Liuyan;
import com.hiworlds.bbblog.domain.admin.LogcaicaiCity;
import com.hiworlds.bbblog.mapper.CaicaiDao;
import com.hiworlds.bbblog.mapper.LiuyanDao;
import com.hiworlds.bbblog.utils.UserAgentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Liyz
 * @Date: 2020/7/23 14:16
 * @Description:
 **/

@ResponseBody
@Controller
public class LogCaiCaiController {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CaicaiDao caicaiDao;
    @Autowired
    private LiuyanDao liuyanDao;

    /**
     * 访问记录
     * @param params
     * @return
     * @throws JsonProcessingException
     */
    @PostMapping("/home/setALogCaicai")
    public String setALogCaicai(@RequestBody Map<String, String> params) throws JsonProcessingException {

        Map<String,Object> responseMap =new HashMap();
        //参数有误
        if (params.get("ip")==null || params.get("city")==null || params.get("browser")==null) {
            responseMap.put("code", 201);
            responseMap.put("msg", "传来的参数有误");
            responseMap.put("data", null);
            return objectMapper.writeValueAsString(responseMap);
        }
        CaiCai caicai = new CaiCai();
        caicai.setLogcaicai_ip(params.get("ip"));
        caicai.setLogcaicai_city(params.get("city"));
        caicai.setLogcaicai_browser(UserAgentUtil.getUserAgentInfo(params.get("browser")).get("浏览器名称"));
        caicai.setLogcaicai_time(new Date());
        caicaiDao.setALogCaicai(caicai);
        responseMap.put("code", 200);
        responseMap.put("msg", "保存成功");
        responseMap.put("data", null);
        return objectMapper.writeValueAsString(responseMap);
    }

    /**
     * 获取留言总数，踩踩总数
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/home/findAllLogCaicai")
    public String findAllLogCaicai() throws JsonProcessingException {
        List<CaiCai> allLogCaicai = caicaiDao.findAllLogCaicai();
        List<Liuyan> allLiuyans = liuyanDao.findAllLiuyans();
        Map<String, Object> map = new HashMap<>();
        Map<String,Object> innerMap = new HashMap<>();
        innerMap.put("caicaitotal",  allLogCaicai.size());
        innerMap.put("liuyantotal", allLiuyans.size());
        map.put("code", 200);
        map.put("msg", "获取统计人数成功！");
        map.put("data",innerMap);
        return objectMapper.writeValueAsString(map);
    }

    /**
     * 统计访问地区
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/admin/findLogcaicaiCity")
    public String findLogcaicaiCity() throws JsonProcessingException {
        List<LogcaicaiCity> logcaicaiCity = caicaiDao.findLogcaicaiCity();
        HashMap<String, Object> map = new HashMap<>();

        map.put("code", 200);
        map.put("msg", "获取统计访问地区成功！");
        map.put("data",logcaicaiCity);
        return objectMapper.writeValueAsString(map);
    }

}
