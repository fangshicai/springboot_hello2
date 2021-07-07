package com.fangshicai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName myhello
 * @Description TODO
 * @Author fangshicai
 * @Date 2021/6/24 22:25
 */
@Controller
public class myhello {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {


        return "hello-springboot 方仕才";
    }
    @ResponseBody
    @RequestMapping("/setCookie")
    public String setCookie(HttpServletResponse response)
    {
        Cookie c = new Cookie("msg", "k");
        Cookie c1 = new Cookie("msg1", "k11111");
        c.setMaxAge(60*60);//可以存活60*60s,不论浏览器关闭与否
        response.addCookie(c);
        response.addCookie(c1);//c1只存在于当前浏览器的对话，一旦关闭则没有

        return "添加成功";

    }

    @ResponseBody
    @RequestMapping(value = "/getCookie",method = RequestMethod.GET)//get请求才可以
    public String getCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String s;
        for (Cookie cookie : cookies) {
//            System.out.println(cookie.getMaxAge());
            System.out.println("name="+cookie.getName()+",value="+cookie.getValue());
//            System.out.println(cookie.getValue());


        }

        return "获取";
    }


}
