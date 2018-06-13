package com.example.springproject;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            // 세션 key를 가진 정보가 널일경우 로그인페이지로 이동
            if(request.getSession().getAttribute("login") == null ){
                response.sendRedirect("/login");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 세션 key 존재시 main 페이지 이동
        return true;
    }
}
