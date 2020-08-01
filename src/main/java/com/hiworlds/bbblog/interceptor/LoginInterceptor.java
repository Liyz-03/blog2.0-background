package com.hiworlds.bbblog.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.hiworlds.bbblog.utils.JwtToken;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        //获取 header里的token
        final String token = request.getHeader("sessionToken");

        // Except OPTIONS, other request should be checked by JWT


        if (token == null) {
            response.sendRedirect("http://127.0.0.1:8080/admin/login");
            return false;
        }

        Map<String, Claim> userData = JwtToken.verifyToken(token);
        if (userData == null) {
            response.sendRedirect("http://127.0.0.1:8080/admin/login");
            return false;
        }
        Integer id = userData.get("id").asInt();
        String name = userData.get("email").asString();
        String userName = userData.get("password").asString();
        //拦截器 拿到用户信息，放到request中
        request.setAttribute("id", id);
        request.setAttribute("name", name);
        request.setAttribute("userName", userName);
        return true;
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
