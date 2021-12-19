package com.example.demo.web;

import com.example.demo.common.Result;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/index")
    public Result index(String name,String age){

        if(StringUtils.isEmpty(name)){
            return Result.returnFalse("name should not empty");
        }


        return Result.returnTrue("this is index page");
    }

    //@RequiresPermissions("login")
    @RequestMapping("/login")
    public Result login(String userName,String password){

        if(StringUtils.isEmpty(userName)){
            return Result.returnFalse("name should not empty");
        }

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,password);

        SecurityUtils.getSubject().login(usernamePasswordToken);

        System.out.println(usernamePasswordToken.getHost());


        return Result.returnTrue("this is index page");
    }


    @RequestMapping("/getUserInfo")
    public Result getUserInfo(){


        System.out.println(SecurityUtils.getSubject().getSession().getId());


        return Result.returnTrue("the user is "+SecurityUtils.getSubject().getPrincipal().toString());
    }



    @RequiresPermissions("create")
    @RequestMapping("/create")
    public Result create(String userName){


        return Result.returnTrue("create is success");
    }


}
