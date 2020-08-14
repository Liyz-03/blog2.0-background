package com.hiworlds.bbblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiworlds.bbblog.domain.CaiCai;
import com.hiworlds.bbblog.domain.Liuyan;
import com.hiworlds.bbblog.domain.admin.LogcaicaiCity;
import com.hiworlds.bbblog.mapper.CaicaiDao;
import com.hiworlds.bbblog.mapper.LiuyanDao;
import com.hiworlds.bbblog.utils.MyResponseJson;
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
     *
     * @param params
     * @return
     * @throws JsonProcessingException
     */
    @PostMapping("/home/setALogCaicai")
    public Map setALogCaicai(@RequestBody Map<String, String> params) throws JsonProcessingException {
        //参数有误
        if (params.get("ip") == null || params.get("city") == null || params.get("browser") == null) {
//            responseMap.put("code", 201);
//            responseMap.put("msg", "传来的参数有误");
//            responseMap.put("data", null);
            return MyResponseJson.responseFailedNoData("传来的参数有误");
        }
        CaiCai caicai = new CaiCai();
        caicai.setLogcaicai_ip(params.get("ip"));
        caicai.setLogcaicai_city(params.get("city"));
        caicai.setLogcaicai_browser(UserAgentUtil.getUserAgentInfo(params.get("browser")).get("浏览器名称"));
        caicai.setLogcaicai_time(new Date());
        caicaiDao.setALogCaicai(caicai);
        return MyResponseJson.responseSuccessNoData("保存成功");
    }

    /**
     * 获取留言总数，踩踩总数
     *
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/home/findAllLogCaicai")
    public Map findAllLogCaicai() throws JsonProcessingException {
        List<CaiCai> allLogCaicai = caicaiDao.findAllLogCaicai();
        List<Liuyan> allLiuyans = liuyanDao.findAllLiuyans();
        Map<String, Object> innerMap = new HashMap<>();
        innerMap.put("caicaitotal", allLogCaicai.size());
        innerMap.put("liuyantotal", allLiuyans.size());
        return MyResponseJson.responseSuccessWithData(innerMap, "保存成功");
    }

    /**
     * 统计访问地区
     *
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/admin/findLogcaicaiCity")
    public Map findLogcaicaiCity() throws JsonProcessingException {
        List<LogcaicaiCity> logcaicaiCity = caicaiDao.findLogcaicaiCity();
        return MyResponseJson.responseSuccessWithData(logcaicaiCity, "保存成功");
    }

}
