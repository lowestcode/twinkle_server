package com.twinkle.controller;

import com.twinkle.pojo.User;
import com.twinkle.result.Result;
import com.twinkle.result.StatusCode;
import com.twinkle.service.AdminService;
import com.twinkle.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 管理员注册
     *
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody User user) {
        adminService.save(user);
        return new Result(true, StatusCode.OK, "管理员注册成功");
    }

    /**
     * 管理员登录
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user) {
        user = adminService.login(user);
        if (user == null) {
            return new Result(true, StatusCode.LOGINERROR, "管理员用户名或密码错误");
        }
        //使用jwt生成token
        String token = jwtUtil.createJWT(user.getUserId(), user.getUserName(), user.getUserRoles());
        Map<String, Object> map = new HashMap<>();
        map.put("token",token);
        map.put("role",user.getUserRoles());
        map.put("user",user);
        return new Result(true, StatusCode.OK, "管理员登录成功", map);
    }
}
