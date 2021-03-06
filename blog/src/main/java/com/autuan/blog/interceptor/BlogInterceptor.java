package com.autuan.blog.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BlogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("-------------拦截器");
        // 取 session
        HttpSession session = httpServletRequest.getSession();
        // 取 cookie
        Cookie[] cookies = httpServletRequest.getCookies();
        // 没 cookie 直接返回 false
        if (cookies == null || cookies.length == 0) {
            httpServletResponse.sendRedirect("/login/toLogin");
            return false;
        }
        for (Cookie cookie : cookies) {
            // 验证成功
            if (cookie.getName().equals("autuanBlog")) {
               String s = (String) session.getAttribute("autuanBlog");
               if(cookie.getValue().equals(s)) {
                // 重置 服务器 用户过期时间
                session.setMaxInactiveInterval(60);
                // 返回 结果
                return true;
               }
            }
        }
        //httpServletRequest.getRequestDispatcher("page-login").forward(httpServletRequest, httpServletResponse);
        httpServletResponse.sendRedirect("/login/toLogin");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // 处理请求完成后视图渲染前的拦截操作
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        // 视图渲染之后的操作
    }
}
