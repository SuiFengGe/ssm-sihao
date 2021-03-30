package com.xhtx.filter;

import javax.servlet.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class NoCacheFilter implements Filter {



    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;

        String url = req.getRequestURI();
        System.out.println(url);

        if (url.contains("/book")){
            HttpSession session = req.getSession();
            Object loginUser = session.getAttribute("loginUser");
            if (loginUser==null){
                System.out.println("想强制登录被发现羁押返回了");
                resp.sendRedirect("/user/toLogin");
                return;
            }

        }
            chain.doFilter(req, resp);
    }



    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
