package com.fangshicai.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName SessionController
 * @Description TODO
 * @Author fangshicai
 * @Date 2021/7/6 15:28
 */
@RestController
public class SessionController {
    @RequestMapping("/session")
    public String setSession(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute("msg","helloSession");
       System.out.println(session.getId());

        Cookie cookie = new Cookie("JSESSION", session.getId());
        response.addCookie(cookie);
        return "设置成功";
    }
    @RequestMapping("/getSession")
    public  void getSession(HttpServletRequest request){

        HttpSession session;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("JSESSION")){
                System.out.println(cookie.getValue());
            }
        }




    }


}
