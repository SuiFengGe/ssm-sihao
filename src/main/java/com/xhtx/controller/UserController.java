package com.xhtx.controller;

import com.xhtx.pojo.User;
import com.xhtx.service.UserService;
import com.xhtx.util.RandomValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    //跳转到登录页面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request,HttpSession session){
        String msg = null;
        String randomString = (String) request.getSession().getAttribute("key");
        System.out.println(randomString);
        String verifyCode = request.getParameter("verifyCode");
        System.out.println(verifyCode);
        if (randomString.equalsIgnoreCase(verifyCode)){
            System.out.println("hello");
            User loginUser = userService.getUser(user);
            System.out.println(loginUser);
            if (loginUser!=null){
                session.setAttribute("loginUser",loginUser);
                System.out.println(session.getAttribute("loginUser"));
                return "redirect:/book/allBook";
            }else{
                msg = "账户名或密码错误，请重试";
                session.setAttribute("msg",msg);
                return "login";
            }
        }else {
            System.out.println("no");
            msg = "验证码错误，请重试";
            session.setAttribute("msg",msg);
            return "login";
        }

    }

    //跳转到注册页面
    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "addUser";
    }

    @RequestMapping("/addUser")
    public String addUser(User user){
        int result = userService.addUser(user);
        if (result>0){
        return "addUserOK";
        }else {
            return "addUser";
        }
    }

    /**
     * 获取生成验证码显示到 UI 界面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value="/checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");

        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);

        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);//输出图片方法

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 退出登录
     */
    @RequestMapping("/doLogout")
    public String doLogout(HttpSession session){
        session.removeAttribute("loginUser");
        session.removeAttribute("msg");
        System.out.println(session.getAttribute("loginUser"));
        System.out.println(session.getAttribute("msg"));
        System.out.println(session);
        return "redirect:/user/toLogin";
    }





}
