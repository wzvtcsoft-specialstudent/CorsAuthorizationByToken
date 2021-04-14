package com.example.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.test.entity.Result;
import com.example.test.entity.User;
import com.example.test.utils.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class TestController {
    @PostMapping("/login")
    public JSONResult login(@RequestBody User user, HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(user.getUsername()+"    "+user.getPassword());
        if(!user.getUsername().equals("admin")||!user.getPassword().equals("admin")){
            return JSONResult.error("用户名或密码错误");
        }
        Result result=new Result();
        result.setSession_id(session.getId());
        result.setUsername(user.getUsername());
        result.setId(1);
        session.setAttribute("result",result);
        session.setMaxInactiveInterval(300);
        return JSONResult.build(1,"登录成功",result);
    }

    @GetMapping("/user")
    public JSONResult user(HttpServletRequest request){
        HttpSession session=request.getSession();
        Result result=(Result) session.getAttribute("result");
        if(result!=null){
            return JSONResult.build(1,"",result);
        }else {
            return JSONResult.build(2,"未登录",null);
        }
    }
}
