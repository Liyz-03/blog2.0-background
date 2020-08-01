package com.hiworlds.bbblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiworlds.bbblog.domain.User;
import com.hiworlds.bbblog.mapper.UserDao;
import com.hiworlds.bbblog.myException.errorMsgConstant.ResponseMsgConstant;
import com.hiworlds.bbblog.myException.myExceptions.LoginFailedException;
import com.hiworlds.bbblog.utils.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Liyz
 * @Date: 2020/7/22 13:54
 * @Description:用户控制器
 **/


@Controller
public class UserController {


    @Autowired
    private UserDao userDao;
    @Autowired
    ObjectMapper objectMapper;

    @ResponseBody
    @PostMapping(value = "/admin/login")
    public String postLogin(@RequestBody Map<String, String> loginningUser) throws JsonProcessingException {
        String email = loginningUser.get("email");
        String password = loginningUser.get("password");
        System.out.println(email+"--"+password);
        //输入为空
        if (!(email != null && email.length() > 0 && password != null && password.length() > 0)) throw new LoginFailedException(ResponseMsgConstant.ERROR_MSG_LOGIN);
        User oneUserByEmailAndPassword = userDao.findOneUserByEmailAndPassword(email, password);
        System.out.println(oneUserByEmailAndPassword);
        //密码或者邮箱错误
        if(oneUserByEmailAndPassword == null){
            throw new LoginFailedException(ResponseMsgConstant.ERROR_MSG_LOGIN);
        }
        String token = JwtToken.createToken(oneUserByEmailAndPassword);
        Map<String, Object> resultMap = new HashMap<>();
        Map<String,Object> innerMap = new HashMap<>();
        innerMap.put("user_id", oneUserByEmailAndPassword.getUser_id());
        innerMap.put("user_role", oneUserByEmailAndPassword.getUser_role());
        innerMap.put("user_name", oneUserByEmailAndPassword.getUser_name());
        innerMap.put("token", token);
        resultMap.put("code", 200);
        resultMap.put("msg", "登录成功");
        resultMap.put("data", innerMap);
        return objectMapper.writeValueAsString(resultMap);
    }

}
