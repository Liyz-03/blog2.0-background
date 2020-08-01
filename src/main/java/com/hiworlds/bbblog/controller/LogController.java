package com.hiworlds.bbblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiworlds.bbblog.domain.Log;
import com.hiworlds.bbblog.mapper.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  @author: Liyz
 *  @Date: 2020/7/22 21:34
 *  @Description:博客日志管理
 **/

@RestController
public class LogController {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LogDao logDao;

    /**
     * 获取所有博客
     * @return
     * @throws JsonProcessingException
     */

    @GetMapping(value = "/home/findAllLog")
    public String findAllLog() throws JsonProcessingException {
        List<Log> allLogs = logDao.findAllLog();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 200);
        resultMap.put("msg", "获取博客日志成功");
        resultMap.put("logs", allLogs);
        return objectMapper.writeValueAsString(resultMap);
    }

    @GetMapping("/admin/deleteLogById")
    public String deleteLogdeleteLogById(Integer id) throws JsonProcessingException {
        logDao.deleteLogdeleteLogById(id);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 200);
        resultMap.put("msg", "删除成功");
        resultMap.put("data", null);
        return objectMapper.writeValueAsString(resultMap);
    }

    @PostMapping("/admin/changeLogContent")
    public String changeLogContent(@RequestBody Map params) throws JsonProcessingException {
        Log log = new Log();
        log.setLog_content((String) params.get("log_content"));
        log.setLog_time(new Date());
        log.setLog_id((Integer) params.get("log_id"));
        logDao.changeLogContent(log);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 200);
        resultMap.put("msg", "修改成功");
        resultMap.put("data", null);
        return objectMapper.writeValueAsString(resultMap);
    }

    @PostMapping("/admin/saveLog")
    public String saveLog(@RequestBody Map params) throws JsonProcessingException {
        Log log = new Log();
        log.setLog_content((String) params.get("log_content"));
        log.setLog_time(new Date());
        logDao.saveLog(log);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 200);
        resultMap.put("msg", "修改成功");
        resultMap.put("data", null);
        return objectMapper.writeValueAsString(resultMap);
    }

}
