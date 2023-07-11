package com.dhu.staffmanagement.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Component
public class MyAccessDenied implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        //设置相应状态码
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        //设置相应数据格式
        httpServletResponse.setContentType("application/json;charset=utf-8");
        //输入响应内容
        httpServletResponse.sendRedirect("/noAccess");
    }
}
