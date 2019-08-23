package com.twinkle.controller;

import com.twinkle.pojo.User;
import com.twinkle.result.Result;
import com.twinkle.result.StatusCode;
import com.twinkle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody User user){
        userService.save(user);
        return new Result(true, StatusCode.OK, "用户注册成功");
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody User user){
        user = userService.login(user);
        if(user == null){
            return new Result(true, StatusCode.LOGINERROR, "用户名或密码错误");
        }
        //todo 使用jwt
        return new Result(true, StatusCode.OK, "用户登录成功");
    }

}
