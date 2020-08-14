package com.hiworlds.bbblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiworlds.bbblog.domain.Liuyan;
import com.hiworlds.bbblog.domain.User;
import com.hiworlds.bbblog.domain.admin.AdminLiuyan;
import com.hiworlds.bbblog.domain.home.HomeLiuyan;
import com.hiworlds.bbblog.mapper.LiuyanDao;
import com.hiworlds.bbblog.mapper.UserDao;
import com.hiworlds.bbblog.utils.MyResponseJson;
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
    public Map findAllLiuyans() throws JsonProcessingException {
        System.out.println("findAllLiuyans");
        List<HomeLiuyan> allLiuyansForhome = liuyanDao.findAllLiuyansForhome();
        return MyResponseJson.responseSuccessWithData(allLiuyansForhome, "获取所有留言成功");
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
    public Map saveALiuYan(@RequestBody Map<String, String> params) throws JsonProcessingException {
        logger.debug(params.toString());
        //1.根据UserEmail查询user信息
        User userByEmail = userDao.findOneUserByEmail(params.get("UserEmail"));
        //内容为空
        if (params.get("UserContent").length() == 0 || params.get("UserContent") == null) {
            return MyResponseJson.responseFailedNoData("输入为空");
        }
        if (userByEmail == null) {
            logger.debug("该访客第一次发表留言");
            //这次评论人没发表过评论,则保存这次发表人的信息
            User saveUser = new User();
            saveUser.setUser_email(params.get("UserEmail"));
            saveUser.setUser_blog(params.get("UserBlog"));
            if (params.get("UserNickName") == null || params.get("UserNickName").length() == 0) {
                saveUser.setUser_name("我是昵称" + (System.currentTimeMillis() + "").substring(7));

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
            List<HomeLiuyan> allLiuyans = liuyanDao.findAllLiuyansForhome();
            return MyResponseJson.responseSuccessWithData(allLiuyans, "保存成功");
        }
        if (userByEmail != null) {
            logger.debug("该访客已发表过留言");
            if (userByEmail.isUser_is_forbid()) {
                logger.debug("该用户已被禁止留言");
                return MyResponseJson.responseFailedNoData("该用户已被禁止留言");
            }
            if (!userByEmail.isUser_is_forbid()) {
                logger.debug("留言权限ok");
                Liuyan saveLiuyan = new Liuyan();
                saveLiuyan.setLiuyan_content(params.get("UserContent"));
                saveLiuyan.setLiuyan_time(new Date());
                saveLiuyan.setLiuyan_user_id(userByEmail.getUser_id());
                liuyanDao.saveALiuYan(saveLiuyan);
                List<HomeLiuyan> allLiuyans = liuyanDao.findAllLiuyansForhome();
                return MyResponseJson.responseSuccessWithData(allLiuyans, "留言成功");
            }
        }
        return MyResponseJson.responseFailedNoData("输入或服务器错误");
    }

    /**
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/admin/findAllLiuyanForAdmin")
    public Map findAllLiuyanForAdmin() throws JsonProcessingException {
        List<AdminLiuyan> allLiuyanForAdmin = liuyanDao.findAllLiuyanForAdmin();
        return MyResponseJson.responseSuccessWithData(allLiuyanForAdmin,"获取成功!");
    }

    @GetMapping("/admin/deleteLiuyanById")
    public Map deleteLiuyanById(@RequestParam("id") Integer id) throws JsonProcessingException {
        logger.debug(id.toString());
        liuyanDao.deleteLiuyanById(id);
        return MyResponseJson.responseSuccessNoData("删除成功!");
    }
}
