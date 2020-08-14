package com.hiworlds.bbblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiworlds.bbblog.domain.Mywords;
import com.hiworlds.bbblog.mapper.MywordsDao;
import com.hiworlds.bbblog.utils.MyResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MywordsController {
    @Autowired
    private MywordsDao mywordsDao;
    @Autowired
    private ObjectMapper objectMapper;
    private Logger logger = LoggerFactory.getLogger(MywordsController.class);

    /**
     * 获取
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/home/findMywords")
    public Map findMywords() throws JsonProcessingException {
        Mywords mywords = mywordsDao.findMywords();
        return MyResponseJson.responseSuccessWithData(mywords,"获取words成功!");
    }

    @PostMapping("/admin/changeMywords")
    public Map changeMywords(@RequestBody Map parames) throws JsonProcessingException {
        logger.debug("changeMywords获取参数为:"+parames);
        Mywords mywords = new Mywords();
        mywords.setMywords_id((Integer) parames.get("mywords_id"));
        mywords.setMywords_content((String) parames.get("mywords_content"));
        mywordsDao.changeMywords(mywords);
        return MyResponseJson.responseSuccessNoData("获取words成功！");
    }

}
