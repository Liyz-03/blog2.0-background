package com.hiworlds.bbblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiworlds.bbblog.domain.Liuyan;
import com.hiworlds.bbblog.domain.User;
import com.hiworlds.bbblog.domain.admin.AdminLiuyan;
import com.hiworlds.bbblog.domain.home.HomeLiuyan;
import com.hiworlds.bbblog.mapper.LiuyanDao;
import com.hiworlds.bbblog.mapper.UserDao;
import com.hiworlds.bbblog.utils.SendHttp;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Liyz
 * @Date: 2020/7/23 10:25
 * @Description:留言控制器
 **/
@ResponseBody
@Controller
public class LiuyanController {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private LiuyanDao liuyanDao;
    @Autowired
    private UserDao userDao;
    private Logger logger = LoggerFactory.getLogger(LiuyanController.class);

    /**
     * 前台获取所有留言
     *
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/home/findAllLiuyans")
    public String findAllLiuyans() throws JsonProcessingException {
        System.out.println("findAllLiuyans");
        List<HomeLiuyan> allLiuyansForhome = liuyanDao.findAllLiuyansForhome();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("data", allLiuyansForhome);
        map.put("msg", "获取所有留言成功");
        return objectMapper.writeValueAsString(map);
    }

    /**
     * 通过第三方api获取qq信息
     *
     * @param qq
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    @GetMapping("/home/findQQInfor")
    public String findQQInfor(@Param(value = "qq") String qq) throws IOException, URISyntaxException {
        System.out.println(qq);
        //http://users.qzone.qq.com/fcg-bin/cgi_get_portrait.fcg?uins=1970782037
        String httpData = SendHttp.getHttpData("https://api.vvhan.com/api/qq?qq=" + qq);
        return httpData;
    }

    @PostMapping(value = "/home/saveLiuYan")
    public String saveALiuYan(@RequestBody Map<String, String> params) throws JsonProcessingException {
        logger.debug(params.toString());
        Map<String, Object> result = new HashMap<>();
        //1.根据UserEmail查询user信息
        User userByEmail = userDao.findOneUserByEmail(params.get("UserEmail"));
        //内容为空
        if (params.get("UserContent").length() == 0 || params.get("UserContent") == null) {
            result.put("msg", "输入为空");
            result.put("code", 400);
            result.put("data", null);
            return objectMapper.writeValueAsString(result);
        }
        if (userByEmail == null) {
            logger.debug("该访客第一次发表留言");
            //这次评论人没发表过评论,则保存这次发表人的信息
            User saveUser = new User();
            saveUser.setUser_email(params.get("UserEmail"));
            saveUser.setUser_blog(params.get("UserBlog"));
            if (params.get("UserNickName") == null || params.get("UserNickName").length() == 0) {
                saveUser.setUser_name( "我是昵称" +(System.currentTimeMillis()+"").substring(7));

            }
            if (!(params.get("UserNickName") == null || params.get("UserNickName").length() == 0)) {
                saveUser.setUser_name(params.get("UserNickName"));
            }
            if (params.get("UserTX") != null && params.get("UserTX").length() > 0) {
                saveUser.setUser_headimg(params.get("UserTX"));
            }
            saveUser.setUser_create_time(new Date());
            userDao.saveUser(saveUser);
            //保存留言到数据库
            Liuyan saveLiuyan = new Liuyan();
            saveLiuyan.setLiuyan_user_id(saveUser.getUser_id());
            saveLiuyan.setLiuyan_content(params.get("UserContent"));
            saveLiuyan.setLiuyan_time(new Date());
            liuyanDao.saveALiuYan(saveLiuyan);
            result.put("msg", "保存成功");
            result.put("code", 200);
            List<HomeLiuyan> allLiuyans = liuyanDao.findAllLiuyansForhome();
            result.put("data", allLiuyans);
            return objectMapper.writeValueAsString(result);
        }
        if (userByEmail != null) {
            logger.debug("该访客已发表过留言");
            if (userByEmail.isUser_is_forbid()) {
                logger.debug("该用户已被禁止留言");
                result.put("msg", "该用户已被禁止留言");
                result.put("code", 400);
                result.put("data", null);
                return objectMapper.writeValueAsString(result);
            }
            if (!userByEmail.isUser_is_forbid()) {
                logger.debug("留言权限ok");
                Liuyan saveLiuyan = new Liuyan();
                saveLiuyan.setLiuyan_content(params.get("UserContent"));
                saveLiuyan.setLiuyan_time(new Date());
                saveLiuyan.setLiuyan_user_id(userByEmail.getUser_id());
                liuyanDao.saveALiuYan(saveLiuyan);
                result.put("msg", "留言成功");
                result.put("code", 200);
                List<HomeLiuyan> allLiuyans = liuyanDao.findAllLiuyansForhome();
                result.put("data", allLiuyans);
                return objectMapper.writeValueAsString(result);
            }
        }
        result.put("msg", "输入或服务器错误");
        result.put("code", 400);
        result.put("data", null);
        return objectMapper.writeValueAsString(result);
    }

    /**
     *
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/admin/findAllLiuyanForAdmin")
    public String findAllLiuyanForAdmin() throws JsonProcessingException {
        List<AdminLiuyan> allLiuyanForAdmin = liuyanDao.findAllLiuyanForAdmin();
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "获取成功!");
        map.put("code", 200);
        map.put("data", allLiuyanForAdmin);
        return objectMapper.writeValueAsString(map);
    }

    @GetMapping("/admin/deleteLiuyanById")
    public String deleteLiuyanById(@RequestParam("id") Integer id) throws JsonProcessingException {
        logger.debug(id.toString());
        liuyanDao.deleteLiuyanById(id);
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "删除!");
        map.put("code", 200);
        map.put("data", null);
        return objectMapper.writeValueAsString(map);
    }
}
