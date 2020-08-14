package com.hiworlds.bbblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiworlds.bbblog.domain.Log;
import com.hiworlds.bbblog.mapper.LogDao;
import com.hiworlds.bbblog.utils.MyResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: Liyz
 * @Date: 2020/7/22 21:34
 * @Description:博客日志管理
 **/

@RestController
public class LogController {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LogDao logDao;

    /**
     * 获取所有博客
     *
     * @return
     * @throws JsonProcessingException
     */

    @GetMapping(value = "/home/findAllLog")
    public Map findAllLog() throws JsonProcessingException {
        List<Log> allLogs = logDao.findAllLog();
        return MyResponseJson.responseSuccessWithData(allLogs, "获取博客日志成功");
    }

    @GetMapping("/admin/deleteLogById")
    public Map deleteLogdeleteLogById(Integer id) throws JsonProcessingException {
        logDao.deleteLogdeleteLogById(id);
        return MyResponseJson.responseSuccessNoData("获取博客日志成功");
    }

    @PostMapping("/admin/changeLogContent")
    public Map changeLogContent(@RequestBody Map params) throws JsonProcessingException {
        Log log = new Log();
        log.setLog_content((String) params.get("log_content"));
        log.setLog_time(new Date());
        log.setLog_id((Integer) params.get("log_id"));
        logDao.changeLogContent(log);
        return MyResponseJson.responseSuccessNoData("修改成功");
    }

    @PostMapping("/admin/saveLog")
    public Map saveLog(@RequestBody Map params) throws JsonProcessingException {
        Log log = new Log();
        log.setLog_content((String) params.get("log_content"));
        log.setLog_time(new Date());
        logDao.saveLog(log);
        return MyResponseJson.responseSuccessNoData("修改成功");
    }

}
